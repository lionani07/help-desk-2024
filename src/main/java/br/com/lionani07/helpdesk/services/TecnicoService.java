package br.com.lionani07.helpdesk.services;

import br.com.lionani07.helpdesk.domain.Tecnico;
import br.com.lionani07.helpdesk.domain.dto.TecnicoDTO;
import br.com.lionani07.helpdesk.exceptions.DataIntegrationException;
import br.com.lionani07.helpdesk.exceptions.ResourceNotFoundException;
import br.com.lionani07.helpdesk.repositories.TecnicoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TecnicoService {

    private final TecnicoRepository repository;

    public TecnicoDTO findByIdAsDto(final Integer id) {
        return this.findById(id).toDTO();
    }

    public Tecnico findById(final Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tecnico não existe para id = " + id));
    }

    public List<TecnicoDTO> findAll() {
        return this.repository.findAll().stream().map(Tecnico::toDTO).collect(Collectors.toList());
    }

    public TecnicoDTO create(TecnicoDTO tecnicoDTO) {
        try {
            return this.repository.save(Tecnico.from(tecnicoDTO)).toDTO();
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrationException("Cpf ou Email Já cadastrado");
        }
    }

    public TecnicoDTO update(Integer id, @Valid TecnicoDTO tecnicoDTO) {
        try {
        val tecnicoFound = this.findById(id);
        BeanUtils.copyProperties(tecnicoDTO, tecnicoFound, "id");
        return this.repository.save(tecnicoFound).toDTO();
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrationException("Cpf ou Email Já cadastrado");
        }
    }

    public void delete(Integer id) {
        val tecnico = this.findById(id);
        if (!tecnico.getChamados().isEmpty()) {
            throw new DataIntegrationException("Tecnico não pode ser deletado. Possui ordens de serviço!");
        }

        this.repository.deleteById(id);
    }
}
