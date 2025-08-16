package br.com.alura.forumhub.domain.curso;

import br.com.alura.forumhub.domain.curso.validacoes.atualizarCurso.ValidadorAtualizacaoDeCurso;
import br.com.alura.forumhub.domain.curso.validacoes.cadastrar.ValidadorCadastroDeCurso;
import br.com.alura.forumhub.domain.curso.validacoes.detalharCurso.ValidadorDetalhamentoDeCurso;
import br.com.alura.forumhub.domain.curso.validacoes.excluirCurso.ValidadorExclusaoDeCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class CursoFuncoes {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorDetalhamentoDeCurso> validadorDetalhamento;

    @Autowired
    private List<ValidadorAtualizacaoDeCurso> validadorAtualizacao;

    @Autowired
    private List<ValidadorExclusaoDeCurso> validadorExclusao;

    @Autowired
    private List<ValidadorCadastroDeCurso> validadorCadastro;

    public ResponseEntity<DadosDetalhamentoCurso> cadastrarCurso(@Valid DadosCadastroCurso dados, UriComponentsBuilder uriBuilder) {
        validadorCadastro.forEach(v -> v.validar(dados));

        var curso = new Curso(dados);
        cursoRepository.save(curso);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));
    }


    public ResponseEntity<Page<DadosListagemCurso>> listarCursos(Pageable paginacao) {
        var page = cursoRepository.findAllByAtivoTrueOrderByIdAsc(paginacao).map(DadosListagemCurso::new);

        return ResponseEntity.ok(page);
    }

    public ResponseEntity<DadosDetalhamentoCurso> detalharCurso(Long id) {
        validadorDetalhamento.forEach(v -> v.validar(id));

        var curso = cursoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }

    public ResponseEntity<DadosDetalhamentoCurso> atualizarCurso(@Valid DadosAtualizacaoCurso dados) {
        validadorAtualizacao.forEach(v -> v.validar(dados));

        var curso = cursoRepository.getReferenceById(dados.id());
        curso.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }

    public ResponseEntity<Void> excluirCurso(Long id) {
        validadorExclusao.forEach(v -> v.validar(id));

        var curso = cursoRepository.getReferenceById(id);
        curso.excluir();

        return ResponseEntity.noContent().build();
    }
}
