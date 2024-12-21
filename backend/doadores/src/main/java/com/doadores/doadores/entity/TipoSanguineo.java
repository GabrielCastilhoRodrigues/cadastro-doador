package com.doadores.doadores.entity;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = TipoSanguineoDeserializer.class)
@JsonSerialize(using = TipoSanguineoSerializer.class)
public enum TipoSanguineo {
    A_POSITIVO("A+", Arrays.asList("A+", "AB+"),
        Arrays.asList("A+", "A-", "O+", "O-")),
    A_NEGATIVO("A-", Arrays.asList("A+", "A-", "AB+", "AB-"),
        Arrays.asList("A-", "O-")),
    B_POSITIVO("B+", Arrays.asList("B+", "AB+"),
        Arrays.asList("B+", "B-", "O+", "O-")),
    B_NEGATIVO("B-", Arrays.asList("B+", "B-", "AB+", "AB-"),
        Arrays.asList("B-", "O-")),
    AB_POSITIVO("AB+", Arrays.asList("AB+"),
        Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")),
    AB_NEGATIVO("AB-", Arrays.asList("AB+", "AB-"),
        Arrays.asList("A-", "B-", "AB-", "O-")),
    O_POSITIVO("O+", Arrays.asList("A+", "B+", "AB+", "O+"),
        Arrays.asList("O+", "O-")),
    O_NEGATIVO("O-", Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"),
        Arrays.asList("O-"));

    private final String descricao;
    private final List<String> podeDoarPara;
    private final List<String> podeReceberDe;

    TipoSanguineo(String descricao, List<String> podeDoarPara, List<String> podeReceberDe) {
        this.descricao = descricao;
        this.podeDoarPara = podeDoarPara;
        this.podeReceberDe = podeReceberDe;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    public List<String> getPodeDoarPara() {
        return podeDoarPara;
    }

    public List<String> getPodeReceberDe() {
        return podeReceberDe;
    }

    @JsonCreator
    public static TipoSanguineo fromDescricao(String descricao) {
        return Arrays.stream(TipoSanguineo.values())
                .filter(tipo -> tipo.descricao.equalsIgnoreCase(descricao))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo sanguíneo inválido: "
                    + descricao));
    }

    public boolean podeDoarPara(TipoSanguineo receptor) {
        return this.podeDoarPara.contains(receptor.getDescricao());
    }

    public boolean podeReceberDe(TipoSanguineo doador) {
        return this.podeReceberDe.contains(doador.getDescricao());
    }
}
