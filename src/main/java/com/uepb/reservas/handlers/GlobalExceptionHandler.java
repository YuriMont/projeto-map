package com.uepb.reservas.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

        // Exceções genéricas (não tratadas especificamente)
        @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("message", ex.getMessage());
            body.put("error", "Internal Server Error");

            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Exceção personalizada ou específica (exemplo: IllegalArgumentException)
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("message", ex.getMessage());
            body.put("error", "Bad Request");

            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
}
