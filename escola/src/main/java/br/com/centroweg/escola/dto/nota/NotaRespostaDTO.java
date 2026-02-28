package br.com.centroweg.escola.dto.nota;

public record NotaRespostaDTO(
        Integer id,
        String alunoNome,
        String aulaAssunto,
        Double valor
) {
}
