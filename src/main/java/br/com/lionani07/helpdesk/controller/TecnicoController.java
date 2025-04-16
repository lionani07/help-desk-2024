package br.com.lionani07.helpdesk.controller;

import br.com.lionani07.helpdesk.domain.dto.TecnicoDTO;
import br.com.lionani07.helpdesk.services.TecnicoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
@AllArgsConstructor
// TODO: ESTAMOS usando o mesmo Dto para todo, nao acho legal!, mas só tamos brincando um pouco, entao tudo bem
public class TecnicoController {

    private final TecnicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        val tecnico = this.service.findByIdAsDto(id);
        return ResponseEntity.ok().body(tecnico);
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        val tecnicos = this.service.findAll();
        return ResponseEntity.ok(tecnicos);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO tecnicoDTO) {
        val tecnicoCreated = this.service.create(tecnicoDTO);
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(tecnicoCreated.getId())
                .toUri();

        return ResponseEntity.created(uri).body(tecnicoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoDTO> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO tecnicoDTO) {
        val tecnicoUpdated = this.service.update(id, tecnicoDTO);
        return ResponseEntity.ok(tecnicoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
