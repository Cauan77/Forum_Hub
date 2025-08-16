package br.com.alura.forumhub.domain.autor;

public record DadosListagemAutor(
        Long id,
        String nome,
        String email
) {
    public DadosListagemAutor (Autor autor) {
        this(
                autor.getId(),
                autor.getNome(),
                autor.getEmail()
        );
    }
}
