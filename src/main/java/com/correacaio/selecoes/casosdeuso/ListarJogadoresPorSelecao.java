package com.correacaio.selecoes.casosdeuso;

import com.correacaio.selecoes.modelo.Jogador;
import com.correacaio.selecoes.repositorio.JogadorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListarJogadoresPorSelecao {

    private final JogadorRepositorio jogadorRepositorio;

    public ListarJogadoresPorSelecao(JogadorRepositorio jogadorRepositorio) {
        this.jogadorRepositorio = jogadorRepositorio;
    }

    public List<Jogador> executa(UUID selecaoId) {
        return jogadorRepositorio.findAllBySelecaoId(selecaoId);
    }
}
