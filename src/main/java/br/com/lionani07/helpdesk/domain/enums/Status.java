package br.com.lionani07.helpdesk.domain.enums;

import java.util.Arrays;

public enum Status {
    ABERTO(0, "ABERTO"),
    ANDAMENTO(2, "ANDAMENTO"),
    ENCERRADO(3, "ENCERRADO");

    private Integer codigo;

    private String descricao;

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer codigo) {
        return Arrays.stream(Status.values())
                .filter(perfil -> perfil.codigo == codigo)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Status inválido"));
    }
}
