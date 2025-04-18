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

        final Tecnico tec2 = new Tecnico(null, "Tenico2", "83961710010", "tecnico2@gmail.com", "123");

        final Cliente cli1 = new Cliente(null, "Linus Torvalds", "54494387029", "torvals@gmail.com", "123");
        final Cliente cli2 = new Cliente(null, "Cliente 2", "54494387010", "cliente2@gmail.com", "123");

        final Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
        final Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Segundo chamado", tec1, cli1);
        final Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 03", "Terceiro chamado", tec2, cli2);

        this.clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        this.tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
        this.chamadoRepository.saveAll(Arrays.asList(c1, c2, c3));

    }
}

