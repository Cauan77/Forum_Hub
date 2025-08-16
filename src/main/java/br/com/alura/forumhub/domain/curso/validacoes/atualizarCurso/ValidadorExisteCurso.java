package br.com.alura.forumhub.domain.curso.validacoes.atualizarCurso;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.curso.DadosAtualizacaoCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidadorExisteCursoParaAtualizar")
public class ValidadorExisteCurso implements ValidadorAtualizacaoDeCurso{

    @Autowired
    private CursoRepository repository;

    public void validar(DadosAtualizacaoCurso dados) {
        if(!repository.existsById(dados.id())) {
            throw new ValidacaoException("Id do curso não existe");
        }
    }
}
