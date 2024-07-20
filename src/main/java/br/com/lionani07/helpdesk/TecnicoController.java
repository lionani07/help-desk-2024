package br.com.lionani07.helpdesk;

import br.com.lionani07.helpdesk.domain.Tecnico;
import br.com.lionani07.helpdesk.services.TecnicoService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tecnicos")
@AllArgsConstructor
public class TecnicoController {

    private final TecnicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {
        val tecnico = this.service.findById(id);
        return ResponseEntity.ok().body(tecnico);
    }
}
