package br.com.centroweg.escola.application.aula.dto;

import java.time.LocalDateTime;

public record AulaRespostaDTO(
        Integer id,
        String nomeTurma,
        LocalDateTime dataHora,
        String assunto
) {
}
