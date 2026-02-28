package br.com.centroweg.escola.mapper.aluno;

import br.com.centroweg.escola.dto.aluno.AlunoRequisicaoDTO;
import br.com.centroweg.escola.dto.aluno.AlunoRespostaDTO;
import br.com.centroweg.escola.model.Aluno;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AlunoMapperImpl implements AlunoMapper {
    @Override
    public Aluno toEntity(AlunoRequisicaoDTO requisicaoDTO) {
        return new Aluno(
                requisicaoDTO.nome(),
                requisicaoDTO.email(),
                requisicaoDTO.matricula(),
                requisicaoDTO.dataNascimento()
        );
    }

    @Override
    public AlunoRespostaDTO toDTO(Aluno aluno) {
        return new AlunoRespostaDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getDataNascimento()
        );
    }

    @Override
    public List<AlunoRespostaDTO> toDTOList(List<Aluno> alunos) {
        return alunos.stream()
                .map(this::toDTO)
                .toList();
    }
}
