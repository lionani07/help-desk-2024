package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.enums.Perfil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "cpf"})
public abstract class Pessoa {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    protected Set<Integer> perfis = new HashSet<>();
    private LocalDate dataCriacao = LocalDate.now();
    public Pessoa() {
        addPerfil(Perfil.CLIENTE);
    }

    public Pessoa(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        addPerfil(Perfil.CLIENTE);
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(Perfil::toEnum).collect(Collectors.toSet());
    }
}
