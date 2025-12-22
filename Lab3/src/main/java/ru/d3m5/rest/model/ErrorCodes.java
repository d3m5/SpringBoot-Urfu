package ru.d3m5.rest.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {
    EMPTY(""), VALIDATION_EXCEPTION("Ошибка валидации"),
    UNSUPPORTED_EXCEPTION("Произошла непредвиденная ошибка"),
    UNKNOWN_EXCEPTION("Не поддерживаемая ошибка");
    private final String name;

    ErrorCodes(String name) {

        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
