package br.com.lionani07.helpdesk.services;

import br.com.lionani07.helpdesk.domain.Cliente;
import br.com.lionani07.helpdesk.domain.dto.ClienteDTO;
import br.com.lionani07.helpdesk.domain.request.ClienteCreateRequest;
import br.com.lionani07.helpdesk.exceptions.DataIntegrationException;
import br.com.lionani07.helpdesk.repositories.ClienteRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteDTO save(@Valid ClienteCreateRequest request) {
        try {
            return this.clienteRepository.save(Cliente.from(request)).toDto();
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrationException("Cpf ou email já cadastrado");
        }
    }
}
