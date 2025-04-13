package br.com.lionani07.helpdesk.controller.handler;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandarError {
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
}
