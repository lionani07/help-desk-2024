package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.dto.TecnicoDTO;
import br.com.lionani07.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.val;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity(name = "TECNICO")
@SuperBuilder
public class Tecnico extends Pessoa {

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico", fetch = FetchType.EAGER)
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        super();
        super.addPerfil(Perfil.TECNICO);
    }
    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        super.addPerfil(Perfil.TECNICO);
    }

    public static Tecnico from(TecnicoDTO dto) {
        val tecnico = new Tecnico(null, dto.getNome(), dto.getCpf(), dto.getEmail(), dto.getSenha());
        tecnico.getPerfis().addAll(dto.getPerfis());
        return tecnico;
    }

    public TecnicoDTO toDTO() {
        return TecnicoDTO.builder()
                .id(this.id)
                .nome(this.nome)
                .cpf(this.cpf)
                .email(this.email)
                .senha(this.senha)
                .dataCriacao(this.dataCriacao)
                .perfis(this.perfis)
                .chamados(this.chamados.stream().map(Chamado::toDTO).collect(Collectors.toList()))
                .build();
    }
}
