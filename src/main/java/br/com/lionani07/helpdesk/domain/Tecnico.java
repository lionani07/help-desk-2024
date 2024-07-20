package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "TECNICO")
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
}
