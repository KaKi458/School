package com.school.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpStatus> handleException(Exception ex) {
        log.error("Unhandled exception occurred. ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @ExceptionHandler(SchoolApiException.class)
    public ResponseEntity<ErrorDetails> handleException(SchoolApiException ex) {
        log.error("API exception raised: {}", ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorDetails(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleException(MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidException raised: {}", ex.getMessage());

        FieldError fe = ex.getBindingResult().getFieldError();
        String field = "<unknown>";
        if (fe != null) {
            field = fe.getField();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorDetails("Validation failed for parameter '" + field + "'"));
    }
    
    @ExceptionHandler(ValueInstantiationException.class)
    public ResponseEntity<ErrorDetails> handleException(ValueInstantiationException ex) {
        log.error("ValueInstantiationException raised: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorDetails(
                        "Validation failed for parameter '" + ex.getPath().get(0).getFieldName()));
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDetails> handleException(HttpMessageNotReadableException ex) {
        Throwable throwable = ex.getCause();
        log.error(ex.getMessage());
        String errorMessage = ex.getMessage();
        if (throwable instanceof JsonEOFException) {
            errorMessage = "Invalid json: start '{' or end-braces '}'";
        } else if (throwable instanceof JsonParseException jsonParseException) {
            errorMessage = jsonParseException.getOriginalMessage();
        } else if (throwable instanceof UnrecognizedPropertyException unrecognizedPropertyException) {
            errorMessage = unrecognizedPropertyException.getMessage();
            List<Reference> jsonReferences = unrecognizedPropertyException.getPath();
            if (!jsonReferences.isEmpty()) {
                String invalidField = jsonReferences.get(0).getFieldName();
                errorMessage = "The field '" + invalidField + "' is an unsupported parameter.";
            }
        } else if (throwable instanceof JsonMappingException jsonMappingException) {
            List<JsonMappingException.Reference> jsonReferences = jsonMappingException.getPath();
            if (!jsonReferences.isEmpty()) {
                String invalidField = jsonReferences.get(0).getFieldName();
                errorMessage = "The field '" + invalidField + "' does not have the expected valuetype";
            }
        } else {
            errorMessage = "Undefined HTTP Message not readable exception" + errorMessage;
        }
        return ResponseEntity.badRequest().body(
                new ErrorDetails(errorMessage));
    }
    
//    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
//    public ResponseEntity<ErrorDetails> handleException(HttpMediaTypeNotAcceptableException ex) {
//        log.error("Unsupported media-type exception occurred. {}", ex.getMessage());
//        return ResponseEntity.status(ex.getStatusCode())
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(new ErrorDetails(ex.getMessage() + ". Supported media types: " + ex.getSupportedMediaTypes()));
//    }
    
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorDetails> handleException(HttpMediaTypeNotSupportedException ex) {
        log.error("Unsupported media-type exception occurred. {}", ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorDetails(ex.getMessage()));
    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorDetails> handleException(HttpRequestMethodNotSupportedException ex) {
        log.error("Method {} is not allowed for this endpoint. {}", ex.getMethod(), ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorDetails(ex.getMessage()));
    }
    
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErrorDetails> handleException(InvalidFormatException ex) {
        log.error("InvalidFormatException raised: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(
                new ErrorDetails("Required: " + ex.getTargetType().getSimpleName() + ", provided: '" + ex.getValue().toString() + "'"));
    }
}
