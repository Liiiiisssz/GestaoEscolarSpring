package br.com.centroweg.escola.application.aula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AulaRequisicaoDTO(
        @NotNull(message = "O id da turma não pode ser nulo")
        Integer turmaId,
        @NotNull(message = "A data e horário da aula não pode ser nula")
        LocalDateTime dataHora,
        @NotBlank(message = "O assunto da aula não pode estar vazio")
        String assunto
) {
}
