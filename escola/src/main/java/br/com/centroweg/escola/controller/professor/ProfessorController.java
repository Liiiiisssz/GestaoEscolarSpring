package br.com.centroweg.escola.controller.professor;

import br.com.centroweg.escola.dto.professor.ProfessorRequisicaoDTO;
import br.com.centroweg.escola.dto.professor.ProfessorRespostaDTO;

import java.util.List;

public interface ProfessorController {
    List<ProfessorRespostaDTO> findAll();
    ProfessorRespostaDTO findById(Integer id);
    ProfessorRespostaDTO save(ProfessorRequisicaoDTO requisicaoDTO);
    ProfessorRespostaDTO update(ProfessorRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
