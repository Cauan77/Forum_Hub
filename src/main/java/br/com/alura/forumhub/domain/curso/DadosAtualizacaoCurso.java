package br.com.alura.forumhub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCurso(
        @NotNull (message = "Coloque o id do curso que você quer atualizar")
        Long id,

        String nome,

        Categoria categoria
) { }
