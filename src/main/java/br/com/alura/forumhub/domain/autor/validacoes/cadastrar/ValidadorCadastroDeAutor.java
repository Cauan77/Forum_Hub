package br.com.alura.forumhub.domain.autor.validacoes.cadastrar;

import br.com.alura.forumhub.domain.autor.DadosCadastroAutor;

public interface ValidadorCadastroDeAutor {
    void validar(DadosCadastroAutor dados);
}
