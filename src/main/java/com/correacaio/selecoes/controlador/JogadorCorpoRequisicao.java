package com.correacaio.selecoes.controlador;

import java.time.LocalDate;
import java.util.UUID;

public class JogadorCorpoRequisicao {

    private final String nome;
    private final LocalDate dataNascimento;

    private final UUID selecaoId;

    public JogadorCorpoRequisicao(String nome, LocalDate dataNascimento, UUID selecaoId) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.selecaoId = selecaoId;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public UUID getSelecaoId() { return selecaoId; }
}
