package br.com.lionani07.helpdesk.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldMessageEror {
    private String fieldName;
    private String message;
}
