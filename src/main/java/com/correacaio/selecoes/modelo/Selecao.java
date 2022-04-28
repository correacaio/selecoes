package com.correacaio.selecoes.modelo;

import java.util.UUID;

public class Selecao {

    private final UUID id;
    private String pais;
    private String escudo;
    private int qtdeVezesCampea;

    public Selecao(
        UUID id,
        String nome,
        String escudo,
        int qtdeVezesCampea
    ) {
        this.id = id;
        this.pais = nome;
        this.escudo = escudo;
        this.qtdeVezesCampea = qtdeVezesCampea;
    }

    public UUID getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public String getEscudo() {
        return escudo;
    }

    public int getQtdeVezesCampea() {
        return qtdeVezesCampea;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public void setQtdeVezesCampea(int qtdeVezesCampea) {
        this.qtdeVezesCampea = qtdeVezesCampea;
    }

    public static Selecao cria(
        String nome,
        String escudo,
        int qtdeVezesCampea
    ) {
        return new Selecao(
            UUID.randomUUID(),
            nome,
            escudo,
            qtdeVezesCampea
        );
    }
}
