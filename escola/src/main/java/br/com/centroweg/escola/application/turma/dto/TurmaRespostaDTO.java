package br.com.centroweg.escola.application.turma.dto;

import java.util.List;

public record TurmaRespostaDTO(
        Integer id,
        String nome,
        String nomeCurso,
        String nomeProfessor,
        List<String> nomeAlunos
) {
}
