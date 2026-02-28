package br.com.centroweg.escola.dto.aula;

import java.time.LocalDateTime;

public record AulaRespostaDTO(
        Integer id,
        String nomeTurma,
        LocalDateTime dataHora,
        String assunto
) {
}
