package br.com.lionani07.helpdesk.domain.request;

import br.com.lionani07.helpdesk.domain.enums.Prioridade;
import br.com.lionani07.helpdesk.domain.enums.Status;
import br.com.lionani07.helpdesk.validations.ValueOfEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ChamadoCreateRequest {

    private Integer id;

    @NotBlank(message = "Campo é obrigatório")
    private String titulo;

    @NotBlank(message = "Campo é obrigatório")
    private String observacoes;

    @NotBlank(message = "Campo é obrigatório")
    @ValueOfEnum(enumClass = Status.class)
    private String status;

    @NotBlank(message = "Campo é obrigatório")
    @ValueOfEnum(enumClass = Prioridade.class, message = "Deve ser algum valor do enum Prioridade")
    private String prioridade;

    @Positive(message = "Campo é obrigatório")
    private Integer tecnicoId;

    @Positive(message = "Campo é obrigatório")
    private Integer clienteId;
}
