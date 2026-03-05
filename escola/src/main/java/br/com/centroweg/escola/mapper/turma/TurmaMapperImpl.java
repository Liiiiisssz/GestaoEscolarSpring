package br.com.centroweg.escola.mapper.turma;

import br.com.centroweg.escola.dto.turma.TurmaRequisicaoDTO;
import br.com.centroweg.escola.dto.turma.TurmaRespostaDTO;
import br.com.centroweg.escola.model.Turma;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurmaMapperImpl implements TurmaMapper{
    @Override
    public Turma toEntity(TurmaRequisicaoDTO requisicaoDTO) {
        return new Turma(
                requisicaoDTO.nome(),
                requisicaoDTO.cursoId(),
                requisicaoDTO.professorId()
        );
    }

    @Override
    public TurmaRespostaDTO toDTO(Turma turma) {
        return new  TurmaRespostaDTO(
                turma.getId(),
                turma.getNome(),
                turma.getNomeCurso(),
                turma.getNomeProfessor(),
                turma.getNomeAlunos()
        );
    }

    @Override
    public List<TurmaRespostaDTO> toDTOList(List<Turma> turmas) {
        return turmas.stream()
                .map(this::toDTO)
                .toList();
    }
}
