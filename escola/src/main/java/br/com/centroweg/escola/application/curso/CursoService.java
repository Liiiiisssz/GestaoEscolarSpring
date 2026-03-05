package br.com.centroweg.escola.application.curso;

import br.com.centroweg.escola.application.curso.dto.CursoRequisicaoDTO;
import br.com.centroweg.escola.application.curso.dto.CursoRespostaDTO;

import java.util.List;

public interface CursoService {
    List<CursoRespostaDTO> findAll();
    CursoRespostaDTO findById(Integer id);
    CursoRespostaDTO save(CursoRequisicaoDTO requisicaoDTO);
    CursoRespostaDTO update(CursoRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
