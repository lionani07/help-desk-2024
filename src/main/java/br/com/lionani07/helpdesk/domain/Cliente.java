package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.Chamado;
import br.com.lionani07.helpdesk.domain.Pessoa;
import br.com.lionani07.helpdesk.domain.enums.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cliente extends Pessoa {

    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }
}
