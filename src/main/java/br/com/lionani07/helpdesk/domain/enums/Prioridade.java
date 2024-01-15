package br.com.lionani07.helpdesk.domain.enums;

import java.util.Arrays;

public enum Prioridade {
    BAIXA(0, "BAIXA"),
    MEDIA(2, "MEDIA"),
    ALTA(3, "C");

    private Integer codigo;

    private String descricao;

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer codigo) {
        return Arrays.stream(Prioridade.values())
                .filter(perfil -> perfil.codigo == codigo)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Prioridade inválida"));
    }
}
