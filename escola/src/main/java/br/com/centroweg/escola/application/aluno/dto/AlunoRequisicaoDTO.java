package br.com.centroweg.escola.application.aluno.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record AlunoRequisicaoDTO(
        @NotBlank(message = "O nome não deve ser vazio")
        String nome,
        @Email(message = "Formato de email inválido")
        String email,
        @NotBlank(message = "A matrícula não deve ser vazia")
        String matricula,
        @Past(message = "A data de nascimento não pode ser atual ou futura")
        LocalDate dataNascimento
) {
}
