package br.com.centroweg.escola.application.turma;

import br.com.centroweg.escola.application.turma.dto.TurmaRequisicaoDTO;
import br.com.centroweg.escola.application.turma.dto.TurmaRespostaDTO;

import java.util.List;

public interface TurmaService {
    List<TurmaRespostaDTO> findAll();
    TurmaRespostaDTO findById(Integer id);
    TurmaRespostaDTO save(TurmaRequisicaoDTO requisicaoDTO);
    TurmaRespostaDTO update(TurmaRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
