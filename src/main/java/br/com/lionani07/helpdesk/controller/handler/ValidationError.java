package br.com.lionani07.helpdesk.controller.handler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationError extends StandarError {

    private List<FieldMessageEror> errors = new ArrayList<>();

    public ValidationError(HttpStatus status, String error, String message, String path) {
        super(status, error, message, path);
    }
}
