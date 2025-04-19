package br.com.lionani07.helpdesk.controller;

import br.com.lionani07.helpdesk.domain.dto.ClienteDTO;
import br.com.lionani07.helpdesk.domain.request.ClienteCreateRequest;
import br.com.lionani07.helpdesk.services.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteCreateRequest request) {
        val clienteCreated = this.clienteService.save(request);
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand("/{cliente_id}")
                .expand(clienteCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(clienteCreated);
    }
}
