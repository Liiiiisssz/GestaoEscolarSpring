package br.com.centroweg.escola.controller.turma;

import br.com.centroweg.escola.dto.turma.TurmaRequisicaoDTO;
import br.com.centroweg.escola.dto.turma.TurmaRespostaDTO;

import java.util.List;

public interface TurmaController {
    List<TurmaRespostaDTO> findAll();
    TurmaRespostaDTO findById(Integer id);
    TurmaRespostaDTO save(TurmaRequisicaoDTO requisicaoDTO);
    TurmaRespostaDTO update(TurmaRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
