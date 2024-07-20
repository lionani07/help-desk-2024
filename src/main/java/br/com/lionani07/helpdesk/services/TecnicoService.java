package br.com.lionani07.helpdesk.services;

import br.com.lionani07.helpdesk.domain.Tecnico;
import br.com.lionani07.helpdesk.exceptions.ResourceNotFoundException;
import br.com.lionani07.helpdesk.repositories.TecnicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TecnicoService {

    private final TecnicoRepository repository;

    public Tecnico findById(final Integer id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tecnico nao existe"));
    }
}
