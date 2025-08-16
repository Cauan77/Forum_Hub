package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(

        @NotBlank(message = "A mensagem não pode estar vazia")
        String mensagem,

        @NotNull(message = "Coloque o id do curso para continuar")
        Long idCurso,

        @NotNull(message = "Coloque o id do autor para continuar")
        Long idAutor,

        @NotBlank(message = "O título não pode estar vazio")
        String titulo
) { }
