package br.com.lionani07.helpdesk.domain.dto;

import br.com.lionani07.helpdesk.domain.enums.Perfil;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class ClienteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private LocalDate dataCriacao;
    private Set<Perfil> perfis;
    private List<ChamadoDTO> chamados;
}
