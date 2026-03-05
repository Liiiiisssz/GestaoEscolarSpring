package br.com.centroweg.escola.application.professor;

import br.com.centroweg.escola.application.professor.dto.ProfessorRequisicaoDTO;
import br.com.centroweg.escola.application.professor.dto.ProfessorRespostaDTO;

import java.util.List;

public interface ProfessorService {
    List<ProfessorRespostaDTO> findAll();
    ProfessorRespostaDTO findById(Integer id);
    ProfessorRespostaDTO save(ProfessorRequisicaoDTO requisicaoDTO);
    ProfessorRespostaDTO update(ProfessorRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
