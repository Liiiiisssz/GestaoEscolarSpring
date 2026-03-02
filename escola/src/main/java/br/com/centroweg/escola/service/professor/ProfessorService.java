package br.com.centroweg.escola.service.professor;

import br.com.centroweg.escola.dto.professor.ProfessorRequisicaoDTO;
import br.com.centroweg.escola.dto.professor.ProfessorRespostaDTO;
import br.com.centroweg.escola.model.Professor;

import java.util.List;

public interface ProfessorService {
    List<ProfessorRespostaDTO> findAll();
    ProfessorRespostaDTO findById(Integer id);
    ProfessorRespostaDTO save(ProfessorRequisicaoDTO requisicaoDTO);
    ProfessorRespostaDTO update(ProfessorRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
