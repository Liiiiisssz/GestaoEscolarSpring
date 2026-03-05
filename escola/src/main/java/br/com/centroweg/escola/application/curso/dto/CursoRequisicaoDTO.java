package br.com.centroweg.escola.application.curso.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CursoRequisicaoDTO(
        @NotBlank(message = "O nome do curso não pode estar vazio")
        String nome,
        @NotBlank(message = "O código do curso não pode estar vazio")
        String codigo,
        List<Integer> professorIds
) {
}
