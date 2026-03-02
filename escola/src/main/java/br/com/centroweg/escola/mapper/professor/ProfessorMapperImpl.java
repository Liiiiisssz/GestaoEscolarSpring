package br.com.centroweg.escola.mapper.professor;

import br.com.centroweg.escola.dto.professor.ProfessorRequisicaoDTO;
import br.com.centroweg.escola.dto.professor.ProfessorRespostaDTO;
import br.com.centroweg.escola.model.Professor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessorMapperImpl implements ProfessorMapper {
    @Override
    public Professor toEntity(ProfessorRequisicaoDTO requisicaoDTO) {
        return new Professor(
                requisicaoDTO.nome(),
                requisicaoDTO.email(),
                requisicaoDTO.disciplina()
        );
    }

    @Override
    public ProfessorRespostaDTO toDTO(Professor professor) {
        return new ProfessorRespostaDTO(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina()
        );
    }

    @Override
    public List<ProfessorRespostaDTO> toDTOList(List<Professor> professors) {
        return professors.stream()
                .map(this::toDTO)
                .toList();
    }
}
