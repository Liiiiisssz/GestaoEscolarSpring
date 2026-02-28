package br.com.centroweg.escola.dto.aula;

import java.time.LocalDateTime;

public record AulaRequisicaoDTO(
        Integer turmaId,
        LocalDateTime dataHora,
        String assunto
) {
}
