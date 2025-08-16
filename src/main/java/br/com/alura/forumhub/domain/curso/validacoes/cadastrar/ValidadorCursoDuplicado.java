package br.com.alura.forumhub.domain.curso.validacoes.cadastrar;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.autor.AutorRepository;
import br.com.alura.forumhub.domain.autor.DadosCadastroAutor;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.curso.DadosCadastroCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCursoDuplicado implements ValidadorCadastroDeCurso {
    @Autowired
    private CursoRepository repository;

    public void validar(DadosCadastroCurso dados) {
        var nomeDuplicado = repository.existsByNome(dados.nome());

        if (nomeDuplicado) {
            throw new ValidacaoException("Já existe um nome igual a esse, por favor, digite um nome diferente");
        }
    }
}
