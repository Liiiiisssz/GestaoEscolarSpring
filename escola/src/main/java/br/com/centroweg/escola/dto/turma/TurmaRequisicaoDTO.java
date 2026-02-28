package br.com.centroweg.escola.dto.turma;

import java.time.LocalDateTime;
import java.util.List;

public record TurmaRequisicaoDTO(
        String nome,
        Integer cursoId,
        Integer professorId,
        List<Integer> alunoIds
) {
}
