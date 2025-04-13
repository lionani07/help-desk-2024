package br.com.lionani07.helpdesk.controller.handler;

import br.com.lionani07.helpdesk.exceptions.DataIntegrationException;
import br.com.lionani07.helpdesk.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(DataIntegrationException.class)
    public ResponseEntity<StandarError> dataIntegrationException(DataIntegrationException e, HttpServletRequest request) {
        val status = HttpStatus.BAD_REQUEST;
        StandarError error = StandarError.builder()
                .status(status)
                .error("Validations Error")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandarError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        val status = HttpStatus.BAD_REQUEST;
        val errors = e.getFieldErrors().stream().map(it -> new FieldMessageEror(it.getField(), it.getDefaultMessage())).toList();

        val validationError = new ValidationError(
                status,
                "Validation Error",
                "Campos inválidos",
                request.getRequestURI()
        );

        validationError.setErrors(errors);

        return ResponseEntity.status(status).body(validationError);
    }
}
