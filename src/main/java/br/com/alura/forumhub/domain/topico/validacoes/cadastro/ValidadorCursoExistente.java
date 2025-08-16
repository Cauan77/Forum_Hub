package br.com.alura.forumhub.domain.topico.validacoes.cadastro;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.topico.DadosCadastroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCursoExistente implements ValidadorCadastroDeTopico{

    @Autowired
    private CursoRepository repository;

    public void validar(DadosCadastroTopico dados) {
        var cursoExiste = repository.existsById(dados.idCurso());

        if (!cursoExiste) {
            throw new ValidacaoException("O id do curso não existe!");
        }
    }
}
