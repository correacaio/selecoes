package com.correacaio.selecoes.repositorio;

import com.correacaio.selecoes.modelo.Jogador;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JogadorRepositorio {

    private final ObjectMapper objectMapper;
    private static final String PATH = "jogadores/";

    public JogadorRepositorio(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void save(Jogador jogador) {
        Path path = Path.of(PATH + jogador.getId().toString());

        try {
            Files.createDirectories(Path.of(PATH));
            Files.writeString(path, objectMapper.writeValueAsString(jogador));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public List<Jogador> findAllBySelecaoId(UUID selecaoId) {
        try {
            Files.createDirectories(Path.of(PATH));

            return Files.walk(Path.of(PATH))
                .skip(1)
                .map(path -> {
                    try {
                        return objectMapper.readValue(Files.readString(path), Jogador.class);
                    } catch (IOException ioException) {
                        throw new IllegalArgumentException(ioException);
                    }
                })
                .filter(jogador -> jogador.getSelecaoId().equals(selecaoId))
                .collect(Collectors.toList());

        } catch (IOException ioException) {
            throw new IllegalArgumentException(ioException);
        }
    }


}
