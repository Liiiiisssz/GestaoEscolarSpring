package br.com.centroweg.escola.application.professor.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ProfessorRequisicaoDTO(
        @NotBlank(message = "O nome não pode estar vazio")
        String nome,
        @Email(message = "Formato de email inválido")
        String email,
        @NotBlank(message = "A disciplina não pode estar vazia")
        String disciplina
) {
}
