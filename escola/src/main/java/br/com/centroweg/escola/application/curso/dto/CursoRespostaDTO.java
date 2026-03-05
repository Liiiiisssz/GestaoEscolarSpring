package br.com.centroweg.escola.application.curso.dto;

import java.util.List;

public record CursoRespostaDTO(
        Integer id,
        String nome,
        String codigo,
        List<String> professorNomes
) {
}
