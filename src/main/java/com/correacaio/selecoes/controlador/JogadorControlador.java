package com.correacaio.selecoes.controlador;

import com.correacaio.selecoes.casosdeuso.CadastrarJogador;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.UUID;

@Controller
@RequestMapping("/jogadores")
public class JogadorControlador {

    private final CadastrarJogador cadastrarJogador;

    public JogadorControlador(CadastrarJogador cadastrarJogador) {
        this.cadastrarJogador = cadastrarJogador;
    }

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<Void> alterar(@RequestBody JogadorCorpoRequisicao corpoRequisicao) {
        UUID id = cadastrarJogador.executa(
            corpoRequisicao.getNome(),
            corpoRequisicao.getDataNascimento(),
            corpoRequisicao.getSelecaoId()
        );

        return ResponseEntity.created(URI.create("/" + id.toString())).build();
    }
}
