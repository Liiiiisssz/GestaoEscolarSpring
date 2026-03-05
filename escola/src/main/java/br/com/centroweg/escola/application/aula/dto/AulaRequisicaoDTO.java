package br.com.centroweg.escola.application.aula.dto;

import java.time.LocalDateTime;

public record AulaRequisicaoDTO(
        Integer turmaId,
        LocalDateTime dataHora,
        String assunto
) {
}
