package br.com.alura.forumhub.domain.topico.validacoes.atualizarTopico;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.topico.DadosAtualizacaoTopico;
import br.com.alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorExisteTopico implements ValidadorAtualizacaoDeTopico{

    @Autowired
    private TopicoRepository repository;

    public void validar(DadosAtualizacaoTopico dados) {
        if (!repository.existsById(dados.id())) {
            throw new ValidacaoException("O id informado não existe!");
        }

    }
}
