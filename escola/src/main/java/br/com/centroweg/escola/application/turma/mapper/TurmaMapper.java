package br.com.centroweg.escola.application.turma.mapper;

import br.com.centroweg.escola.application.turma.dto.TurmaRequisicaoDTO;
import br.com.centroweg.escola.application.turma.dto.TurmaRespostaDTO;
import br.com.centroweg.escola.domain.turma.Turma;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurmaMapper {
    public Turma toEntity(TurmaRequisicaoDTO requisicaoDTO) {
        return new Turma(
                requisicaoDTO.nome(),
                requisicaoDTO.cursoId(),
                requisicaoDTO.professorId()
        );
    }

    public TurmaRespostaDTO toDTO(Turma turma) {
        return new  TurmaRespostaDTO(
                turma.getId(),
                turma.getNome(),
                turma.getNomeCurso(),
                turma.getNomeProfessor(),
                turma.getNomeAlunos()
        );
    }

    public List<TurmaRespostaDTO> toDTOList(List<Turma> turmas) {
        return turmas.stream()
                .map(this::toDTO)
                .toList();
    }
}
