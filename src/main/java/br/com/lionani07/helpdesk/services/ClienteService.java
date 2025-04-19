package br.com.lionani07.helpdesk.services;

import br.com.lionani07.helpdesk.domain.Cliente;
import br.com.lionani07.helpdesk.domain.dto.ClienteDTO;
import br.com.lionani07.helpdesk.domain.request.ClienteCreateRequest;
import br.com.lionani07.helpdesk.exceptions.DataIntegrationException;
import br.com.lionani07.helpdesk.exceptions.ResourceNotFoundException;
import br.com.lionani07.helpdesk.repositories.ClienteRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteDTO save(ClienteCreateRequest request) {
        try {
            return this.clienteRepository.save(Cliente.from(request)).toDto();
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrationException("Cpf ou email já cadastrado");
        }
    }

    public void update(Integer id, @Valid ClienteCreateRequest request) {
        try {
            val clienteToUpdate = this.findById(id);
            BeanUtils.copyProperties(request, clienteToUpdate, "id");
            this.clienteRepository.save(clienteToUpdate).toDto();
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrationException("Cpf ou email já cadastrado!");
        }
    }

    private Cliente findById(Integer id) {
        return this.clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
    }
}
