package br.com.lionani07.helpdesk.controller;

import br.com.lionani07.helpdesk.domain.dto.ChamadoDTO;
import br.com.lionani07.helpdesk.services.ChamadoService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
