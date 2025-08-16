package br.com.alura.forumhub.domain.topico;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Boolean existsByTitulo(String titulo);

    Boolean existsByMensagem(String mensagem);

    Page<Topico> findAllByOrderByIdAsc(Pageable paginacao);
}
