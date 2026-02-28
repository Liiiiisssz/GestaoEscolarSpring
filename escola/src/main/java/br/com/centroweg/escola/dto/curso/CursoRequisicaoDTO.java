package br.com.centroweg.escola.dto.curso;

import java.util.List;

public record CursoRequisicaoDTO(
        String nome,
        String codigo,
        List<Integer> professorIds
) {
}
