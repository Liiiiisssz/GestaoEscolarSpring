package br.com.centroweg.escola.mapper.curso;

import br.com.centroweg.escola.dto.curso.CursoRequisicaoDTO;
import br.com.centroweg.escola.dto.curso.CursoRespostaDTO;
import br.com.centroweg.escola.model.Curso;

import java.util.List;

public interface CursoMapper {
    Curso toEntity(CursoRequisicaoDTO requisicaoDTO);
    CursoRespostaDTO toDTO(Curso curso);
    List<CursoRespostaDTO> toDTOList(List<Curso> cursos);
}
