package br.com.centroweg.escola.mapper.aluno;

import br.com.centroweg.escola.dto.aluno.AlunoRequisicaoDTO;
import br.com.centroweg.escola.dto.aluno.AlunoRespostaDTO;
import br.com.centroweg.escola.model.Aluno;

import java.util.List;

public interface AlunoMapper {
    Aluno toEntity(AlunoRequisicaoDTO requisicaoDTO);
    AlunoRespostaDTO toDTO(Aluno aluno);
    List<AlunoRespostaDTO> toDTOList(List<Aluno> alunos);
}
