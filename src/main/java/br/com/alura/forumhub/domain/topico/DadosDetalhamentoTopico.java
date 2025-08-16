package br.com.alura.forumhub.domain.topico;

public record DadosDetalhamentoTopico (
        Long idTopico,
        Long idAutor,
        Long idCurso,
        String titulo,
        String mensagem
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this (
                topico.getId(),
                topico.getAutor().getId(),
                topico.getCurso().getId(),
                topico.getTitulo(),
                topico.getMensagem()
        );
    }
}
