package ru.d3m5.rest1.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.d3m5.rest1.exeption.UnsupportedCodeException;
import ru.d3m5.rest1.exeption.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult)
            throws  ValidationFailedException;

    void unSupport(BindingResult bindingResult)
        throws UnsupportedCodeException;
}
