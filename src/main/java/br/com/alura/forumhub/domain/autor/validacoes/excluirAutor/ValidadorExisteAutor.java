package br.com.alura.forumhub.domain.autor.validacoes.excluirAutor;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.autor.AutorRepository;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidadorExisteAutorParaExcluir")
public class ValidadorExisteAutor implements ValidadorExclusaoDeAutor {

    @Autowired
    private AutorRepository repository;

    @Override
    public void validar(Long id) {
        if(!repository.existsById(id)) {
            throw new ValidacaoException("O id do autor não existe!");
        }
    }
}
