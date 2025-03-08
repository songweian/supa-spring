package org.opengear.supa.http;

import lombok.SneakyThrows;
import org.opengear.supa.common.UniResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;


import org.opengear.supa.exception.UniException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UniExceptionHandler {

    @SneakyThrows
    @ExceptionHandler(UniException.class)
    public ResponseEntity<UniResult<?>> handleUniException(UniException ex) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ex.toUniResult());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UniResult<?>> handleGenericException(Exception ex) {
        // Handle generic exceptions and return a response
        return ResponseEntity.status(HttpStatus.OK).body(UniResult.ofError("500",null,ex,""));
    }

}
