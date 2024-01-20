package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.enums.Perfil;
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

    @OneToMany(mappedBy = "tecnico", fetch = FetchType.EAGER)
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        super();
        super.addPerfil(Perfil.TECNICO);
    }
    public Tecnico(Integer id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        super.addPerfil(Perfil.TECNICO);
    }
}
