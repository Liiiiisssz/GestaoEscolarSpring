package br.com.centroweg.escola.service.turma;

import br.com.centroweg.escola.dto.turma.TurmaRequisicaoDTO;
import br.com.centroweg.escola.dto.turma.TurmaRespostaDTO;

import java.util.List;

public interface TurmaService {
    List<TurmaRespostaDTO> findAll();
    TurmaRespostaDTO findById(Integer id);
    TurmaRespostaDTO save(TurmaRequisicaoDTO requisicaoDTO);
    TurmaRespostaDTO update(TurmaRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
