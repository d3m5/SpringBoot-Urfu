package ru.d3m5.rest1.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {
    EMPTY(""),
    VALIDATION("Ошибка валидации"),
    UNSUPPORTED("Uid не поддерживается"),
    UNKNOWN("Не поддерживаемая ошибка");
    private final String description;
    ErrorMessages(String description) {
        this.description = description;
    }
    @JsonValue
    public String getName(){
        return description;
    }
}
