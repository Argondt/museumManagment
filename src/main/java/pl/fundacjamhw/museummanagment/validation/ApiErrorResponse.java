package pl.fundacjamhw.museummanagment.validation;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private final Integer code;
    private final String message;
}