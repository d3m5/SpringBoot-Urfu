package ru.d3m5.rest.service;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.d3m5.rest.exeption.UnsupportedCodeException;
import ru.d3m5.rest.exeption.ValidationFailedException;

import java.util.Objects;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()){
            throw new
                    ValidationFailedException(Objects.requireNonNull(bindingResult.getFieldError()).toString());
        }
    }
    public void unSupport(BindingResult bindingResult) throws UnsupportedCodeException {
       String uid = Objects.requireNonNull(bindingResult.getFieldValue("uid")).toString();
        if (Integer.valueOf(uid) == 123){
           throw new UnsupportedCodeException("Ошибка");
       }
    }

}