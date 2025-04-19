package br.com.lionani07.helpdesk.domain.request;

import br.com.lionani07.helpdesk.domain.enums.Perfil;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.HashSet;
import java.util.Set;

@Data
public class ClienteCreateRequest {

    private Integer id;
    @NotBlank(message = "campo é obrigatório")
    private String nome;
    @CPF(message = "Cpf inválido")
    private String cpf;
    @NotBlank(message = "campo é obrigatório")
    private String email;
    @NotBlank(message = "campo é obrigatório")
    private String senha;
    private Set<Perfil> perfis = new HashSet<>();
}
