package com.correacaio.selecoes.casosdeuso;

import com.correacaio.selecoes.modelo.Selecao;
import com.correacaio.selecoes.repositorio.SelecaoRepositorio;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CadastrarSelecao {

    private final SelecaoRepositorio selecaoRepositorio;

    public CadastrarSelecao(SelecaoRepositorio selecaoRepositorio) {
        this.selecaoRepositorio = selecaoRepositorio;
    }

    public UUID executa(
        String nome,
        String escudo,
        int qtdeVezesCampea
    ) {
        Selecao selecao = Selecao.cria(nome, escudo, qtdeVezesCampea);
        selecaoRepositorio.save(selecao);
        return selecao.getId();
    }
}
