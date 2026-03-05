package br.com.centroweg.escola.application.turma.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record TurmaRequisicaoDTO(
        @NotBlank(message = "O nome não pode estar vazio")
        String nome,
        @NotNull(message = "O id do curso não pode ser nulo")
        Integer cursoId,
        @NotNull(message = "O id do professor não pode ser nulo")
        Integer professorId,
        List<Integer> alunoIds
) {
}
