package br.com.centroweg.escola.application.professor.mapper;

import br.com.centroweg.escola.application.professor.dto.ProfessorRequisicaoDTO;
import br.com.centroweg.escola.application.professor.dto.ProfessorRespostaDTO;
import br.com.centroweg.escola.domain.professor.Professor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessorMapper {
    public Professor toEntity(ProfessorRequisicaoDTO requisicaoDTO) {
        return new Professor(
                requisicaoDTO.nome(),
                requisicaoDTO.email(),
                requisicaoDTO.disciplina()
        );
    }

    public ProfessorRespostaDTO toDTO(Professor professor) {
        return new ProfessorRespostaDTO(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina()
        );
    }

    public List<ProfessorRespostaDTO> toDTOList(List<Professor> professors) {
        return professors.stream()
                .map(this::toDTO)
                .toList();
    }
}
