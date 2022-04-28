package com.correacaio.selecoes.modelo;

import java.time.LocalDate;
import java.util.UUID;

public class Jogador {

    private UUID id;
    private String nome;
    private LocalDate dataNascimento;

    private UUID selecaoId;

    public Jogador(UUID id, String nome, LocalDate dataNascimento, UUID selecaoId) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.selecaoId = selecaoId;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public UUID getSelecaoId() { return selecaoId; }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSelecaoId(UUID selecaoId) {
        this.selecaoId = selecaoId;
    }

    public static Jogador cria(
        String nome,
        LocalDate dataNascimento,
        UUID selecaoId
    ) {
        return new Jogador(
            UUID.randomUUID(),
            nome,
            dataNascimento,
            selecaoId
        );
    }
}
