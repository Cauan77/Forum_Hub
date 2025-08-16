package br.com.alura.forumhub.domain.autor.validacoes.atualizarAutor;

import br.com.alura.forumhub.domain.autor.DadosAtualizacaoAutor;

public interface ValidadorAtualizacaoDeAutor {
    void validar(DadosAtualizacaoAutor dados);
}
