package ru.d3m5.rest1.service;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.d3m5.rest1.exeption.UnsupportedCodeException;
import ru.d3m5.rest1.exeption.ValidationFailedException;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()){
            throw new
                    ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
    public void unSupport(BindingResult bindingResult) throws UnsupportedCodeException {
       String uid = bindingResult.getFieldValue("uid").toString();
        if (Integer.valueOf(uid) == 123){
           throw new UnsupportedCodeException("Ошибка");
       }
    }

}