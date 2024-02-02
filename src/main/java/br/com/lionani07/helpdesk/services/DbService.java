package br.com.lionani07.helpdesk.services;

import br.com.lionani07.helpdesk.domain.Chamado;
import br.com.lionani07.helpdesk.domain.Cliente;
import br.com.lionani07.helpdesk.domain.Tecnico;
import br.com.lionani07.helpdesk.domain.enums.Perfil;
import br.com.lionani07.helpdesk.domain.enums.Prioridade;
import br.com.lionani07.helpdesk.domain.enums.Status;
import br.com.lionani07.helpdesk.repositories.ChamadoRepository;
import br.com.lionani07.helpdesk.repositories.ClienteRepository;
import br.com.lionani07.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    public void initDB() {
        final Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "83961710090", "valdir@gmail.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        final Cliente cli1 = new Cliente(null, "Linus Torvalds", "54494387029", "torvals@gmail.com", "123");

        final Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);

        this.clienteRepository.saveAll(Arrays.asList(cli1));
        this.tecnicoRepository.saveAll(Arrays.asList(tec1));
        this.chamadoRepository.saveAll(Arrays.asList(c1));

    }
}
