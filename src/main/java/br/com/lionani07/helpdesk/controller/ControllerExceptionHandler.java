package br.com.lionani07.helpdesk.controller;

import br.com.lionani07.helpdesk.exceptions.DataIntegrartionException;
import br.com.lionani07.helpdesk.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String RESOURCE_NOT_FOUND = "Resource not found";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandarError> ResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError standarError = StandarError.builder()
                .status(status)
                .error(RESOURCE_NOT_FOUND)
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(standarError);
    }

    @ExceptionHandler(DataIntegrartionException.class)
    public ResponseEntity<StandarError> dataIntegrationException(DataIntegrartionException e, HttpServletRequest request) {
        val status = HttpStatus.BAD_REQUEST;
        StandarError error = StandarError.builder()
                .status(status)
                .error("Validations Error")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }
}
