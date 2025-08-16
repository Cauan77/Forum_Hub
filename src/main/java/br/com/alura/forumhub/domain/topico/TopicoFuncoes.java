package br.com.alura.forumhub.domain.topico;

import br.com.alura.forumhub.domain.autor.AutorRepository;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.topico.validacoes.atualizarTopico.ValidadorAtualizacaoDeTopico;
import br.com.alura.forumhub.domain.topico.validacoes.cadastro.ValidadorCadastroDeTopico;
import br.com.alura.forumhub.domain.topico.validacoes.detalharTopico.ValidadorDetalhamentoDeTopico;
import br.com.alura.forumhub.domain.topico.validacoes.excluirTopico.ValidadorExclusaoDeTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoFuncoes {
    @Autowired
    private List<ValidadorCadastroDeTopico> validadores;

    @Autowired
    private List<ValidadorDetalhamentoDeTopico> validadoresDetalhamento;

    @Autowired
    private List<ValidadorAtualizacaoDeTopico> validadoresAtualizacao;

    @Autowired
    private List<ValidadorExclusaoDeTopico> validadoresExclusao;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public ResponseEntity<DadosDetalhamentoTopico> cadastrar(@Valid DadosCadastroTopico dados) {
        validadores.forEach(v -> v.validar(dados));

        var data = LocalDateTime.now();

        var statusTopico = Estado.NAO_RESPONDIDO;

        var autor = autorRepository.getReferenceById(dados.idAutor());

        var curso = cursoRepository.getReferenceById(dados.idCurso());

        var topico = new Topico(null, dados.titulo(), dados.mensagem(), data, statusTopico, autor, curso);
        topicoRepository.save(topico);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    public ResponseEntity<Page<DadosListagemTopico>> listarTopicos(Pageable paginacao) {
        var page = topicoRepository.findAllByOrderByIdAsc(paginacao).map(DadosListagemTopico::new);

        return ResponseEntity.ok(page);
    }

    public ResponseEntity<DadosDetalhamentoTopico> detalharTopico(Long id) {
        validadoresDetalhamento.forEach(v -> v.validar(id));

        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    public ResponseEntity<DadosDetalhamentoTopico> atualizar(@Valid DadosAtualizacaoTopico dados) {
        validadoresAtualizacao.forEach(v -> v.validar(dados));

        var topico = topicoRepository.getReferenceById(dados.id());

        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    public ResponseEntity<Void> cancelar(@Valid Long id) {
        validadoresExclusao.forEach(v -> v.validar(id));

        topicoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
