package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.enums.Prioridade;
import br.com.lionani07.helpdesk.domain.enums.Status;

import java.time.LocalDate;

public class Chamado {
    private Integer id;
    private String titulo;
    private String observacoes;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataFechamento;
    private Status status;
    private Prioridade prioridade;
    private Tecnico tecnico;
    private Cliente cliente;

}
