package com.correacaio.selecoes.casosdeuso;

import com.correacaio.selecoes.repositorio.SelecaoRepositorio;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeletarSelecao {

    private final SelecaoRepositorio selecaoRepositorio;

    public DeletarSelecao(SelecaoRepositorio selecaoRepositorio) {
        this.selecaoRepositorio = selecaoRepositorio;
    }

    public void executa(UUID id) {
        selecaoRepositorio.deleteById(id);
    }
}
