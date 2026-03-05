package br.com.centroweg.escola.application.curso.dto;

import java.util.List;

public record CursoRequisicaoDTO(
        String nome,
        String codigo,
        List<Integer> professorIds
) {
}
