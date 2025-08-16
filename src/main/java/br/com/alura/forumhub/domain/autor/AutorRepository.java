package br.com.alura.forumhub.domain.autor;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Page<Autor> findAllByAtivoTrueOrderByIdAsc(Pageable paginacao);

    Boolean existsByNome(@NotBlank String nome);

    Boolean existsByEmail(@NotBlank @Email String email);

    Boolean existsBySenha(@NotBlank String senha);
}
