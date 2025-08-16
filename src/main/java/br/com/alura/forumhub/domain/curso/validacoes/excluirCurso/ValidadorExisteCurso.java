package br.com.alura.forumhub.domain.curso.validacoes.excluirCurso;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidadorExisteCursoParaExcluir")
public class ValidadorExisteCurso implements ValidadorExclusaoDeCurso{

    @Autowired
    private CursoRepository repository;

    @Override
    public void validar(Long id) {
        if(!repository.existsById(id)) {
            throw new ValidacaoException("O id do curso não existe!");
        }
    }
}
