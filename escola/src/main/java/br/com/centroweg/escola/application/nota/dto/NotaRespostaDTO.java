package br.com.centroweg.escola.application.nota.dto;

public record NotaRespostaDTO(
        Integer id,
        String alunoNome,
        String aulaAssunto,
        Double valor
) {
}
