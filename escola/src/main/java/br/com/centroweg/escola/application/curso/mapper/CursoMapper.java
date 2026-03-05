package br.com.centroweg.escola.application.curso.mapper;

import br.com.centroweg.escola.application.curso.dto.CursoRequisicaoDTO;
import br.com.centroweg.escola.application.curso.dto.CursoRespostaDTO;
import br.com.centroweg.escola.domain.curso.Curso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CursoMapper {
    public Curso toEntity(CursoRequisicaoDTO requisicaoDTO) {
        return new Curso(
                requisicaoDTO.nome(),
                requisicaoDTO.codigo()
        );
    }

    public CursoRespostaDTO toDTO(Curso curso) {
        return new CursoRespostaDTO(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo(),
                curso.getNomesProfessores()
        );
    }

    public List<CursoRespostaDTO> toDTOList(List<Curso> cursos) {
        return cursos.stream()
                .map(this::toDTO)
                .toList();
    }
}
