package br.com.centroweg.escola.mapper.nota;

import br.com.centroweg.escola.dto.nota.NotaRequisicaoDTO;
import br.com.centroweg.escola.dto.nota.NotaRespostaDTO;
import br.com.centroweg.escola.model.Nota;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotaMapperImpl implements NotaMapper{
    @Override
    public Nota toEntity(NotaRequisicaoDTO requisicaoDTO) {
        return new Nota(
                requisicaoDTO.alunoId(),
                requisicaoDTO.aulaId(),
                requisicaoDTO.valor()
        );
    }

    @Override
    public NotaRespostaDTO toDTO(Nota nota) {
        return new NotaRespostaDTO(
                nota.getId(),
                nota.getAlunoNome(),
                nota.getAulaAssunto(),
                nota.getValor()
        );
    }

    @Override
    public List<NotaRespostaDTO> toDTOList(List<Nota> notas) {
        return notas.stream()
                .map(this::toDTO)
                .toList();
    }
}
