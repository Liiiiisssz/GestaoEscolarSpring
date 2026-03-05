package br.com.centroweg.escola.application.nota.dto;

public record NotaRequisicaoDTO(
        Integer alunoId,
        Integer aulaId,
        Double valor
) {
}
