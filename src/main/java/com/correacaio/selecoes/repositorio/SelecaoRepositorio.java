package com.correacaio.selecoes.repositorio;

import com.correacaio.selecoes.modelo.Selecao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class SelecaoRepositorio {

    private final ObjectMapper objectMapper;
    private static final String PATH = "selecoes/";

    public SelecaoRepositorio(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void save(Selecao selecao) {
        Path path = Path.of(PATH + selecao.getId().toString());

        try {
            Files.createDirectories(Path.of(PATH));
            Files.writeString(path, objectMapper.writeValueAsString(selecao));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public List<Selecao> findAll() {
        try {
            Files.createDirectories(Path.of(PATH));

            return Files.walk(Path.of(PATH))
                .skip(1)
                .map(path -> {
                    try {
                        return objectMapper.readValue(Files.readString(path), Selecao.class);
                    } catch (IOException ioException) {
                        throw new IllegalArgumentException(ioException);
                    }
                })
                .collect(Collectors.toList());

        } catch (IOException ioException) {
            throw new IllegalArgumentException(ioException);
        }
    }

    public List<Selecao> findAll(String pais) {
        return findAll()
            .stream()
            .filter(selecao -> selecao.getPais().toLowerCase().contains(pais.toLowerCase()))
            .collect(Collectors.toList());
    }

    public Optional<Selecao> findById(UUID jogadorId) {
        try {
            Path path = Path.of(PATH, jogadorId.toString());

            if (Files.exists(path)) {
                String conteudo = Files.readString(path);
                return Optional.of(objectMapper.readValue(conteudo, Selecao.class));
            }

            return Optional.empty();

        } catch (IOException ioException) {
            throw new IllegalArgumentException(ioException);
        }
    }

    public void deleteById(UUID selecaoId) {
        Path path = Path.of(PATH, selecaoId.toString());

        try {
            Files.deleteIfExists(path);
        } catch (IOException ioException) {
            throw new IllegalArgumentException(ioException);
        }
    }
}
