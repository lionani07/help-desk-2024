package br.com.lionani07.helpdesk.domain.dto;

import br.com.lionani07.helpdesk.domain.enums.Perfil;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class TecnicoDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private LocalDate dataCriacao;
    private Set<Perfil> perfis = new HashSet<>();
    private List<ChamadoDTO> chamados = new ArrayList<>();

    public Set<Integer> perfisAsCode() {
        return this.perfis.stream().map(Perfil::getCodigo).collect(Collectors.toSet());
    }
}
