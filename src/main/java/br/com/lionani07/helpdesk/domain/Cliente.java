package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.dto.ClienteDTO;
import br.com.lionani07.helpdesk.domain.request.ClienteCreateRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "CLIENTE")
@SuperBuilder
@NoArgsConstructor
public class Cliente extends Pessoa {

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public static Cliente from(ClienteCreateRequest request) {
        return Cliente.builder()
                .id(null)
                .cpf(request.getCpf())
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(request.getSenha())
                .dataCriacao(LocalDate.now())
                .perfis(request.getPerfis())
                .build();
    }

    public ClienteDTO toDto() {
        return ClienteDTO.builder()
                .id(this.id)
                .nome(this.nome)
                .cpf(this.cpf)
                .email(this.email)
                .senha(this.senha)
                .dataCriacao(this.dataCriacao)
                .perfis(this.perfis)
                .chamados(this.chamados.stream().map(Chamado::toDTO).toList())
                .build();
    }

    public ClienteDTO toDtoDetails() {
        return ClienteDTO.builder()
                .id(this.id)
                .nome(this.nome)
                .build();
    }
}
