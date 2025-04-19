package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "cpf"})
@Entity(name = "PESSOA")
@SuperBuilder
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String nome;

    @Column(unique = true)
    protected String cpf;

    @Column(unique = true)
    protected String email;

    protected String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    @Enumerated(EnumType.STRING)
    protected Set<Perfil> perfis = new HashSet<>();

    public Pessoa() {
        addPerfil(Perfil.CLIENTE);
    }

    public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        addPerfil(Perfil.CLIENTE);
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil);
    }
}
