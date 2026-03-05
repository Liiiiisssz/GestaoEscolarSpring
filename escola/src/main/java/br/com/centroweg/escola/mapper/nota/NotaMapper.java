package br.com.centroweg.escola.mapper.nota;

import br.com.centroweg.escola.dto.nota.NotaRequisicaoDTO;
import br.com.centroweg.escola.dto.nota.NotaRespostaDTO;
import br.com.centroweg.escola.model.Nota;

import java.util.List;

public interface NotaMapper {
    Nota toEntity(NotaRequisicaoDTO requisicaoDTO);
    NotaRespostaDTO toDTO(Nota nota);
    List<NotaRespostaDTO> toDTOList(List<Nota> notas);
}
