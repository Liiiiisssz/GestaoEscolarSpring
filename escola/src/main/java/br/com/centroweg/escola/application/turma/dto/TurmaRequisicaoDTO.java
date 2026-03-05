package br.com.centroweg.escola.application.turma.dto;

import java.time.LocalDateTime;
import java.util.List;

public record TurmaRequisicaoDTO(
        String nome,
        Integer cursoId,
        Integer professorId,
        List<Integer> alunoIds
) {
}
