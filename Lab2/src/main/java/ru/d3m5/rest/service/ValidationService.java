package ru.d3m5.rest.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.d3m5.rest.exeption.UnsupportedCodeException;
import ru.d3m5.rest.exeption.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult)
            throws  ValidationFailedException;

    void unSupport(BindingResult bindingResult)
        throws UnsupportedCodeException;
}
