package br.com.centroweg.escola.dto.curso;

import java.util.List;

public record CursoRespostaDTO(
        Integer id,
        String nome,
        String codigo,
        List<String> professorNomes
) {
}
