package br.com.lionani07.helpdesk.controller;

import br.com.lionani07.helpdesk.domain.dto.ChamadoDTO;
import br.com.lionani07.helpdesk.domain.request.ChamadoCreateRequest;
import br.com.lionani07.helpdesk.services.ChamadoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/chamados")
@AllArgsConstructor
public class ChamadoController {

    private final ChamadoService chamadoService;

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
        val chamado = this.chamadoService.findByIdAsDto(id);
        return ResponseEntity.ok(chamado);
    }

    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        val chamados = this.chamadoService.findAll();
        return ResponseEntity.ok(chamados);
    }

    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoCreateRequest request) {
        val chamado = this.chamadoService.create(request);
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(chamado.getId())
                .toUri();
        return ResponseEntity.created(uri).body(chamado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoDTO> update(@PathVariable Integer id, @Valid @RequestBody ChamadoCreateRequest request) {
        val chamado = this.chamadoService.update(id, request);
        return ResponseEntity.ok(chamado);
    }

}
