package br.com.centroweg.escola.controller.curso;

import br.com.centroweg.escola.dto.curso.CursoRequisicaoDTO;
import br.com.centroweg.escola.dto.curso.CursoRespostaDTO;

import java.util.List;

public interface CursoController {
    List<CursoRespostaDTO> findAll();
    CursoRespostaDTO findById(Integer id);
    CursoRespostaDTO save(CursoRequisicaoDTO requisicaoDTO);
    CursoRespostaDTO update(CursoRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
