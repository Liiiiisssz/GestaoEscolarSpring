package br.com.centroweg.escola.application.aluno.dto;

import java.time.LocalDate;

public record AlunoRequisicaoDTO(
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento
) {
}
