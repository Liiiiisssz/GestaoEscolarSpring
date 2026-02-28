package br.com.centroweg.escola.dto.turma;

import java.util.List;

public record TurmaRespostaDTO(
        Integer id,
        String nome,
        String nomeCurso,
        String nomeProfessor,
        List<String> nomeAlunos
) {
}
