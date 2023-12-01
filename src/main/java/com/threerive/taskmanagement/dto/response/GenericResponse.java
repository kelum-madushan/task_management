package com.threerive.taskmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {
    private HttpStatus status;

    private String message;

    private String responseCode;

    private T response;
}
