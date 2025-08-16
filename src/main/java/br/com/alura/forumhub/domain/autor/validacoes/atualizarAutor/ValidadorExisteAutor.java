package br.com.alura.forumhub.domain.autor.validacoes.atualizarAutor;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.autor.AutorRepository;
import br.com.alura.forumhub.domain.autor.DadosAtualizacaoAutor;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.curso.DadosAtualizacaoCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidadorExisteAutorParaAtualizar")
public class ValidadorExisteAutor implements ValidadorAtualizacaoDeAutor {

    @Autowired
    private AutorRepository repository;

    public void validar(DadosAtualizacaoAutor dados) {
        if(!repository.existsById(dados.id())) {
            throw new ValidacaoException("Id do autor não existe");
        }
    }
}
