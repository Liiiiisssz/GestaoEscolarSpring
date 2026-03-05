package br.com.centroweg.escola.application.aluno.dto;

import jakarta.validation.constraints.Size;

public record AlunoNotasRespostaDTO(
        String nome,
        String assunto,
        Double valor
) {
}
