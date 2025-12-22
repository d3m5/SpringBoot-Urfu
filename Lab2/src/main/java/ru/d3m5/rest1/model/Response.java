package ru.d3m5.rest1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Response {
    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private Double annualBonus;
    private SystemName systemName;
    private ErrorCodes errorCode;
    private ErrorMessages errorMessage;
}
