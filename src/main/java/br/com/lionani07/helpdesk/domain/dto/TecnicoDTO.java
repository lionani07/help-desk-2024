package br.com.lionani07.helpdesk.domain.dto;

import br.com.lionani07.helpdesk.domain.enums.Perfil;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class TecnicoDTO {

    private Integer id;
    @NotBlank(message = "campo é obrigatório")
    private String nome;
    @NotBlank(message = "campo é obrigatório")
    private String cpf;
    @NotBlank(message = "campo é obrigatório")
    private String email;
    @NotBlank(message = "campo é obrigatório")
    private String senha;
    private LocalDate dataCriacao;
    private Set<Perfil> perfis = new HashSet<>();
    private List<ChamadoDTO> chamados = new ArrayList<>();
}
