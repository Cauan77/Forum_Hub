package br.com.alura.forumhub.domain.autor;

import jakarta.validation.constraints.Email;

public record DadosAtualizacaoAutor(
        Long id,
        String nome,

        @Email(message = "Precisa estar no formato de email")
        String email,
        String senha
) { }
