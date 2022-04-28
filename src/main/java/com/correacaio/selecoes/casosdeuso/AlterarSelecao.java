package com.correacaio.selecoes.casosdeuso;

import com.correacaio.selecoes.excecao.SelecaoNaoEncontradaExcecao;
import com.correacaio.selecoes.modelo.Selecao;
import com.correacaio.selecoes.repositorio.SelecaoRepositorio;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AlterarSelecao {

    private final SelecaoRepositorio selecaoRepositorio;

    public AlterarSelecao(SelecaoRepositorio selecaoRepositorio) {
        this.selecaoRepositorio = selecaoRepositorio;
    }

    public void executa(UUID id, String pais, String escudo, int qtdeVezesCampea) {
        Selecao selecao = selecaoRepositorio.findById(id)
            .orElseThrow(SelecaoNaoEncontradaExcecao::new);

        selecao.setPais(pais);
        selecao.setEscudo(escudo);
        selecao.setQtdeVezesCampea(qtdeVezesCampea);

        selecaoRepositorio.save(selecao);
    }
}
