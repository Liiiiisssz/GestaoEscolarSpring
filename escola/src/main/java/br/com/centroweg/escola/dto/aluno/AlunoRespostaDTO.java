package br.com.centroweg.escola.dto.aluno;

import java.time.LocalDate;

public record AlunoRespostaDTO(
        Integer id,
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento
) {
}
