package br.com.alura.forumhub.domain.topico.validacoes.atualizarTopico;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.topico.DadosAtualizacaoTopico;
import br.com.alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadosMensagemOuTituloDuplicado implements ValidadorAtualizacaoDeTopico{

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DadosAtualizacaoTopico dados) {
        var tituloDuplicado = repository.existsByTitulo(dados.titulo());

        var mensagemDuplicada = repository.existsByMensagem(dados.mensagem());

        if (tituloDuplicado) {
            throw new ValidacaoException("Já existe um título igual a esse, por favor, digite um título diferente");
        }

        if (mensagemDuplicada) {
            throw new ValidacaoException("Já existe uma mensagem igual a essa, por favor, digite uma mensagem diferente");
        }
    }
}
