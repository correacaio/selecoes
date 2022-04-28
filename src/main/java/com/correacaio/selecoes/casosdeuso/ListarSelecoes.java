package com.correacaio.selecoes.casosdeuso;

import com.correacaio.selecoes.modelo.Selecao;
import com.correacaio.selecoes.repositorio.SelecaoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarSelecoes {

    private final SelecaoRepositorio selecaoRepositorio;

    public ListarSelecoes(SelecaoRepositorio selecaoRepositorio) {
        this.selecaoRepositorio = selecaoRepositorio;
    }

    public List<Selecao> executa(String pais) {
        if (pais == null) {
            return selecaoRepositorio.findAll();
        } else {
            return selecaoRepositorio.findAll(pais);
        }
    }
}
