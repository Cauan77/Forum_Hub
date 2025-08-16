package br.com.alura.forumhub.domain.topico.validacoes.excluirTopico;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidadorExisteTopicoParaExcluir")
public class ValidadorExisteTopico implements ValidadorExclusaoDeTopico{

    @Autowired
    private TopicoRepository repository;

    public void validar(Long id) {
        if (!repository.existsById(id)) {
            throw new ValidacaoException("O id informado não existe!");
        }
    }
}
