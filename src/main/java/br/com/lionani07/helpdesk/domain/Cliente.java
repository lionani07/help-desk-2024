package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.dto.ClienteDTO;
import br.com.lionani07.helpdesk.domain.request.ClienteCreateRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity(name = "CLIENTE")
@SuperBuilder
public class Cliente extends Pessoa {

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public static Cliente from(ClienteCreateRequest request) {
        return (Cliente) Cliente.builder()
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
}
