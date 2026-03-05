package br.com.centroweg.escola.application.aula.mapper;

import br.com.centroweg.escola.application.aula.dto.AulaRequisicaoDTO;
import br.com.centroweg.escola.application.aula.dto.AulaRespostaDTO;
import br.com.centroweg.escola.domain.aula.Aula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AulaMapper {
    public Aula toEntity(AulaRequisicaoDTO requisicaoDTO) {
        return new Aula(
                requisicaoDTO.turmaId(),
                requisicaoDTO.dataHora(),
                requisicaoDTO.assunto()
        );
    }

    public AulaRespostaDTO toDTO(Aula aula) {
        return new AulaRespostaDTO(
                aula.getId(),
                aula.getTurmaNome(),
                aula.getDataHora(),
                aula.getAssunto()
        );
    }

    public List<AulaRespostaDTO> toDTOList(List<Aula> aulas) {
        return aulas.stream()
                .map(this::toDTO)
                .toList();
    }
}
