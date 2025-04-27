package br.com.lionani07.helpdesk.domain.request;

import br.com.lionani07.helpdesk.domain.enums.Prioridade;
import br.com.lionani07.helpdesk.domain.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

//TODO: Validar enum com Bean CustomValidation
@Data
public class ChamadoCreateRequest {

    private Integer id;

    @NotBlank(message = "Campo é obrigatório")
    private String titulo;

    @NotBlank(message = "Campo é obrigatório")
    private String observacoes;

    @NotNull(message = "Campo é obrigatório")
    private Status status;

    @NotNull(message = "Campo é obrigatório")
    private Prioridade prioridade;

    @Positive(message = "Campo é obrigatório")
    private Integer tecnicoId;

    @Positive(message = "Campo é obrigatório")
    private Integer clienteId;
}
