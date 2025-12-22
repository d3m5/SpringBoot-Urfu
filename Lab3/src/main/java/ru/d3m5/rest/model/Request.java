package ru.d3m5.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Request {
    @NotBlank(message = "Пустой uid")
    private String uid;
    @NotBlank(message = "Пустой operationUid")
    private String operationUid;
    private String systemName;
    @NotBlank(message = "Нет даты-времени")
    private String systemTime;
    private String source;

    @Min(1)
    @Max(100000)
    private Integer communicationId;
    private Integer templateId;
    private Integer productCode;
    private Integer smsCode;
    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId='" + communicationId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", smsCode='" + smsCode +
                '}';
    }
}
