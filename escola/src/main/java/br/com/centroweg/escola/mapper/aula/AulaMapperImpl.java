package br.com.centroweg.escola.mapper.aula;

import br.com.centroweg.escola.dto.aula.AulaRequisicaoDTO;
import br.com.centroweg.escola.dto.aula.AulaRespostaDTO;
import br.com.centroweg.escola.model.Aula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AulaMapperImpl implements AulaMapper{
    @Override
    public Aula toEntity(AulaRequisicaoDTO requisicaoDTO) {
        return new Aula(
                requisicaoDTO.turmaId(),
                requisicaoDTO.dataHora(),
                requisicaoDTO.assunto()
        );
    }

    @Override
    public AulaRespostaDTO toDTO(Aula aula) {
        return new AulaRespostaDTO(
                aula.getId(),
                aula.getTurmaNome(),
                aula.getDataHora(),
                aula.getAssunto()
        );
    }

    @Override
    public List<AulaRespostaDTO> toDTOList(List<Aula> aulas) {
        return aulas.stream()
                .map(this::toDTO)
                .toList();
    }
}
