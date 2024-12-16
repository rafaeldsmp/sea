package br.com.xpto.csb.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoTelefone {
    CELULAR,
    RESIDENCIAL,
    COMERCIAL;

    @JsonCreator
    public static TipoTelefone fromString(String value) {
        for (TipoTelefone tipo : TipoTelefone.values()) {
            if (tipo.name().equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor inválido para TipoTelefone: " + value);
    }

    @JsonValue
    public String toJson() {
        return this.name();
    }
}