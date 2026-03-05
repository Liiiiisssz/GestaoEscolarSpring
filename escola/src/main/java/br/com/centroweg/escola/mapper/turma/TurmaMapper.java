package br.com.centroweg.escola.mapper.turma;

import br.com.centroweg.escola.dto.turma.TurmaRequisicaoDTO;
import br.com.centroweg.escola.dto.turma.TurmaRespostaDTO;
import br.com.centroweg.escola.model.Turma;

import java.util.List;

public interface TurmaMapper {
    Turma toEntity(TurmaRequisicaoDTO requisicaoDTO);
    TurmaRespostaDTO toDTO(Turma turma);
    List<TurmaRespostaDTO> toDTOList(List<Turma> turmas);
}
