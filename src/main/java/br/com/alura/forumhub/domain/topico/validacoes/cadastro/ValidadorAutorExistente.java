package br.com.alura.forumhub.domain.topico.validacoes.cadastro;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.autor.AutorRepository;
import br.com.alura.forumhub.domain.topico.DadosCadastroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAutorExistente implements ValidadorCadastroDeTopico{

    @Autowired
    private AutorRepository repository;

    public void validar(DadosCadastroTopico dados) {
        var autorExiste = repository.existsById(dados.idAutor());

        if (!autorExiste) {
            throw new ValidacaoException("O id do autor não existe!");
        }
    }
}
