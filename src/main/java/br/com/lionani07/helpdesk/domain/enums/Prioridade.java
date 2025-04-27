package br.com.lionani07.helpdesk.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum Prioridade {
    BAIXA(1, "BAIXA"),
    MEDIA(2, "MEDIA"),
    ALTA(3, "C");
    private final Integer codigo;
    private final String descricao;

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Prioridade toEnum(Integer codigo) {
        return Arrays.stream(Prioridade.values())
                .filter(perfil -> Objects.equals(perfil.codigo, codigo))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Prioridade inválida"));
    }
}
