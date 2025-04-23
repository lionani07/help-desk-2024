package br.com.lionani07.helpdesk.domain.dto;

import br.com.lionani07.helpdesk.domain.enums.Prioridade;
import br.com.lionani07.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Builder
public class ChamadoDTO {

    private Integer id;
    private String titulo;
    private String observacoes;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Status status;
    private Prioridade prioridade;
    private Integer tecnicoId;
    private String tecnicoNome;
    private Integer clienteId;
    private String clienteNome;
}
