package br.com.centroweg.escola.mapper.professor;

import br.com.centroweg.escola.dto.professor.ProfessorRequisicaoDTO;
import br.com.centroweg.escola.dto.professor.ProfessorRespostaDTO;
import br.com.centroweg.escola.model.Professor;

import java.util.List;

public interface ProfessorMapper {
    Professor toEntity(ProfessorRequisicaoDTO requisicaoDTO);
    ProfessorRespostaDTO toDTO(Professor professor);
    List<ProfessorRespostaDTO> toDTOList(List<Professor> professors);
}
