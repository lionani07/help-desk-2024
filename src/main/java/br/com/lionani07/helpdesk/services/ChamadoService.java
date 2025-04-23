package br.com.lionani07.helpdesk.services;

import br.com.lionani07.helpdesk.domain.Chamado;
import br.com.lionani07.helpdesk.domain.dto.ChamadoDTO;
import br.com.lionani07.helpdesk.exceptions.ResourceNotFoundException;
import br.com.lionani07.helpdesk.repositories.ChamadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public ChamadoDTO findById(Integer id) {
        return this.chamadoRepository.findById(id)
                .map(Chamado::toFullDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Chamado não enecontrado!"));
    }
}
