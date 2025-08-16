package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoTopico(
        @NotNull
        Long id
) {
}
