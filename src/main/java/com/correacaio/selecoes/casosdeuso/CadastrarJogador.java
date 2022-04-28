package com.correacaio.selecoes.casosdeuso;

import com.correacaio.selecoes.modelo.Jogador;
import com.correacaio.selecoes.repositorio.JogadorRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class CadastrarJogador {

    private final JogadorRepositorio jogadorRepositorio;

    public CadastrarJogador(JogadorRepositorio jogadorRepositorio) {
        this.jogadorRepositorio = jogadorRepositorio;
    }

    public UUID executa(String nome, LocalDate dataNascimento, UUID selecaoId) {
        Jogador jogador = Jogador.cria(nome, dataNascimento, selecaoId);
        jogadorRepositorio.save(jogador);
        return jogador.getId();
    }
}
