package br.com.centroweg.escola.application.nota.mapper;

import br.com.centroweg.escola.application.nota.dto.NotaRequisicaoDTO;
import br.com.centroweg.escola.application.nota.dto.NotaRespostaDTO;
import br.com.centroweg.escola.domain.nota.Nota;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaMapper {
    public Nota toEntity(NotaRequisicaoDTO requisicaoDTO) {
        return new Nota(
                requisicaoDTO.alunoId(),
                requisicaoDTO.aulaId(),
                requisicaoDTO.valor()
        );
    }

    public NotaRespostaDTO toDTO(Nota nota) {
        return new NotaRespostaDTO(
                nota.getId(),
                nota.getAlunoNome(),
                nota.getAulaAssunto(),
                nota.getValor()
        );
    }

    public List<NotaRespostaDTO> toDTOList(List<Nota> notas) {
        return notas.stream()
                .map(this::toDTO)
                .toList();
    }
}
