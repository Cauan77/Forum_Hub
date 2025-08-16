package br.com.alura.forumhub.domain.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAutor(

        @NotBlank(message = "O nome não pode estar vazio")
        String nome,

        @NotBlank(message = "O email não pode estar vazio")
        @Email (message = "Precisa estar no formato de email")
        String email,

        @NotBlank(message = "O senha não pode estar vazia")
        String senha
) {
}
