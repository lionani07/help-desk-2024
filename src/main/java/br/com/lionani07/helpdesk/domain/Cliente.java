package br.com.lionani07.helpdesk.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "CLIENTE")
public class Cliente extends Pessoa {

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }
}
