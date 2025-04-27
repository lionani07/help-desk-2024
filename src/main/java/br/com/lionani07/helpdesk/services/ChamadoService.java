package br.com.lionani07.helpdesk.services;

import br.com.lionani07.helpdesk.domain.Chamado;
import br.com.lionani07.helpdesk.domain.dto.ChamadoDTO;
import br.com.lionani07.helpdesk.domain.enums.Prioridade;
import br.com.lionani07.helpdesk.domain.enums.Status;
import br.com.lionani07.helpdesk.domain.request.ChamadoCreateRequest;
import br.com.lionani07.helpdesk.exceptions.ResourceNotFoundException;
import br.com.lionani07.helpdesk.repositories.ChamadoRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ChamadoService {

    private final ClienteService clienteService;
    private final TecnicoService tecnicoService;

    private final ChamadoRepository chamadoRepository;

    public ChamadoDTO findByIdAsDto(Integer id) {
        return this.chamadoRepository.findById(id)
                .map(Chamado::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Chamado não enecontrado!"));
    }

    public Chamado findById(Integer id) {
        return this.chamadoRepository.findById(id)
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
                Prioridade.valueOf(request.getPrioridade()),
                Status.valueOf(request.getStatus()),
                request.getTitulo(),
                request.getObservacoes(),
                tecnico, cliente
                );
        return this.chamadoRepository.save(chamado).toDTO();
    }

    public ChamadoDTO update(Integer id, ChamadoCreateRequest request) {
        val chamado = this.findById(id);
        val tecnico = this.tecnicoService.findById(request.getTecnicoId());
        val cliente = this.clienteService.findById(request.getClienteId());

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);

        BeanUtils.copyProperties(request, chamado, "id", "cliente", "tecnico");

        if (Status.ENCERRADO.equals(request.getStatus())) {
            chamado.setDataFechamento(LocalDate.now());
        } else {
            chamado.setDataFechamento(null);
        }

        return this.chamadoRepository.save(chamado).toDTO();
    }
}
