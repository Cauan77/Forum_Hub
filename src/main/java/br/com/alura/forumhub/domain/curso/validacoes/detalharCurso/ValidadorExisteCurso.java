package br.com.alura.forumhub.domain.curso.validacoes.detalharCurso;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorExisteCurso implements ValidadorDetalhamentoDeCurso{

    @Autowired
    private CursoRepository repository;

    public void validar(Long id) {
        if(!repository.existsById(id)) {
            throw new ValidacaoException("O id do curso não existe!");
        }
    }
}
