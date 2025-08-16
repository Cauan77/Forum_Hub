package br.com.alura.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCurso(
        @NotBlank(message = "O nome não pode estar vazio")
        String nome,

        @NotNull (message = "Coloque uma categoria")
        Categoria categoria) {
}
