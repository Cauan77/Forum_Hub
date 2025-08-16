package br.com.alura.forumhub.domain.topico.validacoes.detalharTopico;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoExistente implements ValidadorDetalhamentoDeTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ValidacaoException("O id informado não existe!");
        }
    }
}
