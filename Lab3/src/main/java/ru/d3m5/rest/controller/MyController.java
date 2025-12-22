package ru.d3m5.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.d3m5.rest.exeption.UnsupportedCodeException;
import ru.d3m5.rest.exeption.ValidationFailedException;
import ru.d3m5.rest.model.*;
import ru.d3m5.rest.service.ValidationService;
import ru.d3m5.rest.util.DateTimeUtil;

import javax.validation.Valid;
import java.util.Date;
@Slf4j
@RestController
public class MyController {
    private final ValidationService validationService;

    @Autowired
    public MyController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult){
        log.info("request: {}", request);


        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .systemName(request.getSystemName())
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        try {
            validationService.unSupport(bindingResult);
            log.info("response: {}", response);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.error("Error: {}", response.getErrorMessage().getName());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            validationService.isValid(bindingResult);
            String requestTime = request.getSystemTime();
            Long currentTime = new Date().getTime();
           long timeRequestResponse = currentTime - Long.valueOf(requestTime);
            System.out.printf("Milliseconds: %s \n",timeRequestResponse);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("Error: {}", response.getErrorMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error("Error: {}", response.getErrorMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
