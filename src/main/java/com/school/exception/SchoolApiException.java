package com.school.exception;

import org.springframework.http.HttpStatus;

public class SchoolApiException extends RuntimeException {

    private final HttpStatus httpStatus;

    public SchoolApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
