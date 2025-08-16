package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.autor.*;
import br.com.alura.forumhub.domain.curso.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("autores")
@SecurityRequirement(name = "bearer-key")
public class AutorController {
    @Autowired
    private AutorRepository repository;

    @Autowired
    private AutorFuncoes funcao;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAutor> cadastrar(@RequestBody @Valid DadosCadastroAutor dados, UriComponentsBuilder uriBuilder) {
        return funcao.cadastrarAutor(dados, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAutor>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return funcao.listarAutores(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAutor> detalhar(@PathVariable Long id) {
        return funcao.detalharAutor(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAutor> atualizar(@RequestBody @Valid DadosAtualizacaoAutor dados) {
        return funcao.atualizarAutor(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return funcao.excluirAutor(id);
    }
}
