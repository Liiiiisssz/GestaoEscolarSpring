package br.com.centroweg.escola.mapper.curso;

import br.com.centroweg.escola.dto.curso.CursoRequisicaoDTO;
import br.com.centroweg.escola.dto.curso.CursoRespostaDTO;
import br.com.centroweg.escola.model.Curso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CursoMapperImpl implements CursoMapper{
    @Override
    public Curso toEntity(CursoRequisicaoDTO requisicaoDTO) {
        return new Curso(
                requisicaoDTO.nome(),
                requisicaoDTO.codigo()
        );
    }

    @Override
    public CursoRespostaDTO toDTO(Curso curso) {
        return new CursoRespostaDTO(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo()
        );
    }

    @Override
    public List<CursoRespostaDTO> toDTOList(List<Curso> cursos) {
        return List.of();
    }
}
