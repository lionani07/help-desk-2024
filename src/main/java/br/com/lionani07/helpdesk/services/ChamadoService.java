package br.com.lionani07.helpdesk.services;

import br.com.lionani07.helpdesk.domain.Chamado;
import br.com.lionani07.helpdesk.domain.dto.ChamadoDTO;
import br.com.lionani07.helpdesk.domain.request.ChamadoCreateRequest;
import br.com.lionani07.helpdesk.exceptions.ResourceNotFoundException;
import br.com.lionani07.helpdesk.repositories.ChamadoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChamadoService {

    private final ClienteService clienteService;
    private final TecnicoService tecnicoService;

    private final ChamadoRepository chamadoRepository;

    public ChamadoDTO findById(Integer id) {
        return this.chamadoRepository.findById(id)
                .map(Chamado::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Chamado não enecontrado!"));
    }

    public List<ChamadoDTO> findAll() {
        return this.chamadoRepository.findAll().stream().map(Chamado::toDTO).toList();
    }

    public ChamadoDTO create(ChamadoCreateRequest request) {
        val tecnico = this.tecnicoService.findById(request.getTecnicoId());
        val cliente = this.clienteService.findById(request.getClienteId());
        val chamado = new Chamado(
                null,
                request.getPrioridade(),
                request.getStatus(),
                request.getTitulo(),
                request.getObservacoes(),
                tecnico, cliente
                );
        return this.chamadoRepository.save(chamado).toDTO();
    }
}
