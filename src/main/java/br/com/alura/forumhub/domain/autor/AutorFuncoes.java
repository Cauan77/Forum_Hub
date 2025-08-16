package br.com.alura.forumhub.domain.autor;

import br.com.alura.forumhub.domain.autor.validacoes.atualizarAutor.ValidadorAtualizacaoDeAutor;
import br.com.alura.forumhub.domain.autor.validacoes.cadastrar.ValidadorCadastroDeAutor;
import br.com.alura.forumhub.domain.autor.validacoes.detalharAutor.ValidadorDetalhamentoDeAutor;
import br.com.alura.forumhub.domain.autor.validacoes.excluirAutor.ValidadorExclusaoDeAutor;
import br.com.alura.forumhub.domain.curso.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class AutorFuncoes {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private List<ValidadorCadastroDeAutor> validadorCadastro;

    @Autowired
    private List<ValidadorDetalhamentoDeAutor> validadorDetalhamento;

    @Autowired
    private List<ValidadorAtualizacaoDeAutor> validadorAtualizacao;

    @Autowired
    private List<ValidadorExclusaoDeAutor> validadorExclusao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<DadosDetalhamentoAutor> cadastrarAutor(@Valid DadosCadastroAutor dados, UriComponentsBuilder uriBuilder) {
        validadorCadastro.forEach(v -> v.validar(dados));

        var senhaCriptografada = passwordEncoder.encode(dados.senha());
        var autor = new Autor(null, dados.nome(), dados.email(), senhaCriptografada, true);
        autorRepository.save(autor);

        var uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAutor(autor));
    }


    public ResponseEntity<Page<DadosListagemAutor>> listarAutores(Pageable paginacao) {
        var page = autorRepository.findAllByAtivoTrueOrderByIdAsc(paginacao).map(DadosListagemAutor::new);

        return ResponseEntity.ok(page);
    }

    public ResponseEntity<DadosDetalhamentoAutor> detalharAutor(Long id) {
        validadorDetalhamento.forEach(v -> v.validar(id));

        var autor = autorRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoAutor(autor));
    }

    public ResponseEntity<DadosDetalhamentoAutor> atualizarAutor(@Valid DadosAtualizacaoAutor dados) {
        validadorAtualizacao.forEach(v -> v.validar(dados));

        var autor = autorRepository.getReferenceById(dados.id());

        if (dados.senha() != null) {
            var senhaCriptografada = passwordEncoder.encode(dados.senha());
            autor.atualizarInformacoes(new DadosAtualizacaoAutor(dados.id(), dados.nome(), dados.email(), senhaCriptografada));
        } else {
            autor.atualizarInformacoes(dados);
        }

        return ResponseEntity.ok(new DadosDetalhamentoAutor(autor));
    }

    public ResponseEntity<Void> excluirAutor(Long id) {
        validadorExclusao.forEach(v -> v.validar(id));

        var autor = autorRepository.getReferenceById(id);
        autor.excluir();

        return ResponseEntity.noContent().build();
    }
}
