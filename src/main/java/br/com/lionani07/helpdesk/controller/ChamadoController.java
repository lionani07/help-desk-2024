package br.com.lionani07.helpdesk.controller;

import br.com.lionani07.helpdesk.domain.dto.ChamadoDTO;
import br.com.lionani07.helpdesk.domain.request.ChamadoCreateRequest;
import br.com.lionani07.helpdesk.services.ChamadoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
@AllArgsConstructor
public class ChamadoController {

    private final ChamadoService chamadoService;

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
        val chamado = this.chamadoService.findById(id);
        return ResponseEntity.ok(chamado);
    }

    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        val chamados = this.chamadoService.findAll();
        return ResponseEntity.ok(chamados);
    }

    //TODO: MAKING --WIP
    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoCreateRequest request) {
        return ResponseEntity.ok().build();
    }

}
