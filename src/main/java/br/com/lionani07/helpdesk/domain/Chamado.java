package br.com.lionani07.helpdesk.domain;

import br.com.lionani07.helpdesk.domain.dto.ChamadoDTO;
import br.com.lionani07.helpdesk.domain.enums.Prioridade;
import br.com.lionani07.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "CHAMADO")
@NoArgsConstructor
@Getter
@Setter
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String observacoes;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public ChamadoDTO toDTO() {
        return ChamadoDTO.builder()
                .id(this.id)
                .titulo(this.titulo)
                .observacoes(this.observacoes)
                .dataAbertura(this.dataAbertura)
                .dataFechamento(this.dataFechamento)
                .prioridade(this.prioridade)
                .status(this.status)
                .clienteId(this.cliente.id)
                .clienteNome(this.cliente.nome)
                .tecnicoId(this.tecnico.id)
                .tecnicoNome(this.tecnico.nome)
                .build();
    }

}
