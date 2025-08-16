package br.com.alura.forumhub.domain.curso.validacoes.atualizarCurso;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.autor.AutorRepository;
import br.com.alura.forumhub.domain.autor.DadosAtualizacaoAutor;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.curso.DadosAtualizacaoCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCursoDuplicadoNaAtualizacao implements ValidadorAtualizacaoDeCurso{
    @Autowired
    private CursoRepository repository;

    public void validar(DadosAtualizacaoCurso dados) {
        var nomeDuplicado = repository.existsByNome(dados.nome());

        if (nomeDuplicado) {
            throw new ValidacaoException("Já existe um nome igual a esse, por favor, digite um nome diferente");
        }
    }
}
