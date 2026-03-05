package br.com.centroweg.escola.application.nota.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NotaRequisicaoDTO(
        @NotNull(message = "O id do aluno não pode ser nulo")
        Integer alunoId,
        @NotNull(message = "O id da aula não pode ser nulo")
        Integer aulaId,
        @Size(min = 0, max = 10, message = "Nota inválida")
        Double valor
) {
}
