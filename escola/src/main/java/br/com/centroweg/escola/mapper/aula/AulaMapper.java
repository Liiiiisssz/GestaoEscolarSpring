package br.com.centroweg.escola.mapper.aula;

import br.com.centroweg.escola.dto.aula.AulaRequisicaoDTO;
import br.com.centroweg.escola.dto.aula.AulaRespostaDTO;
import br.com.centroweg.escola.model.Aula;

import java.util.List;

public interface AulaMapper {
    Aula toEntity(AulaRequisicaoDTO requisicaoDTO);
    AulaRespostaDTO toDTO(Aula aula);
    List<AulaRespostaDTO> toDTOList(List<Aula> aulas);
}
