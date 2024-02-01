package br.com.lionani07.helpdesk.domain.enums;

import java.util.Arrays;
import java.util.Objects;

public enum Perfil {
    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE"),
    TECNICO(3, "ROLE_TECNICO");

    private Integer codigo;

    private String descricao;

    Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer codigo) {
        return Arrays.stream(Perfil.values())
                .filter(perfil -> Objects.equals(perfil.codigo, codigo))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Perfil inválido"));
    }
}
