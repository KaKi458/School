package com.school.exception;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ErrorDetails {

    private final LocalDateTime timestamp;
    private final String message;

    public ErrorDetails(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }
}
