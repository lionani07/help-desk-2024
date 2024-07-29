package br.com.lionani07.helpdesk.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class StandarError {
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
}
