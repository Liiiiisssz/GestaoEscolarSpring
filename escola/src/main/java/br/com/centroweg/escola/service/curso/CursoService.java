package br.com.centroweg.escola.service.curso;

import br.com.centroweg.escola.dto.curso.CursoRequisicaoDTO;
import br.com.centroweg.escola.dto.curso.CursoRespostaDTO;

import java.util.List;

public interface CursoService {
    List<CursoRespostaDTO> findAll();
    CursoRespostaDTO findById(Integer id);
    CursoRespostaDTO save(CursoRequisicaoDTO requisicaoDTO);
    CursoRespostaDTO update(CursoRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
