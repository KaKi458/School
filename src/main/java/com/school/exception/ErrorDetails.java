package com.school.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorDetails {

    private Date timestamp;
    private HttpStatusCode httpStatusCode;
    private String message;
}
