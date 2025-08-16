package br.com.alura.forumhub.domain.autor.validacoes.cadastrar;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.autor.AutorRepository;
import br.com.alura.forumhub.domain.autor.DadosCadastroAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAutorDuplicado implements ValidadorCadastroDeAutor{
    @Autowired
    private AutorRepository repository;

    public void validar(DadosCadastroAutor dados) {
        var nomeDuplicado = repository.existsByNome(dados.nome());

        var emailDuplicado = repository.existsByEmail(dados.email());

        var senhaDuplicada = repository.existsBySenha(dados.senha());

        if (nomeDuplicado) {
            throw new ValidacaoException("Já existe um nome igual a esse, por favor, digite um nome diferente");
        }

        if (emailDuplicado) {
            throw new ValidacaoException("Já existe um email igual a essa, por favor, digite um email diferente");
        }

        if (senhaDuplicada) {
            throw new ValidacaoException("Já existe uma senha igual a essa, por favor, digite um senha diferente");
        }
    }
}
