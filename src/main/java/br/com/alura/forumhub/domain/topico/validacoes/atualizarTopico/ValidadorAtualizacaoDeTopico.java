package br.com.alura.forumhub.domain.topico.validacoes.atualizarTopico;

import br.com.alura.forumhub.domain.topico.DadosAtualizacaoTopico;

public interface ValidadorAtualizacaoDeTopico {
    void validar (DadosAtualizacaoTopico dados);
}
