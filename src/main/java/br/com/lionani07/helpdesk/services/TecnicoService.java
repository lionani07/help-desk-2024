package br.com.lionani07.helpdesk.services;

import br.com.lionani07.helpdesk.domain.Tecnico;
import br.com.lionani07.helpdesk.domain.dto.TecnicoDTO;
import br.com.lionani07.helpdesk.exceptions.ResourceNotFoundException;
import br.com.lionani07.helpdesk.repositories.TecnicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TecnicoService {

    private final TecnicoRepository repository;

    public TecnicoDTO findById(final Integer id) {
        return this.repository.findById(id)
                .map(Tecnico::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Tecnico não existe para id = " + id));
    }

    public List<TecnicoDTO> findAll() {
        return this.repository.findAll().stream().map(Tecnico::toDTO).collect(Collectors.toList());
    }
}
