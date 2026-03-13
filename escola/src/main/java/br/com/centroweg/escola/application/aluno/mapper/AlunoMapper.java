package br.com.centroweg.escola.application.aluno.mapper;

import br.com.centroweg.escola.application.aluno.dto.AlunoNotasRespostaDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRequisicaoDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRespostaDTO;
import br.com.centroweg.escola.domain.aluno.Aluno;
import br.com.centroweg.escola.domain.nota.Nota;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AlunoMapper {
    public Aluno toEntity(AlunoRequisicaoDTO requisicaoDTO) {
        return  Aluno.builder()
                .nome(requisicaoDTO.nome())
                .email(requisicaoDTO.email())
                .matricula(requisicaoDTO.matricula())
                .dataNascimento(requisicaoDTO.dataNascimento()).build();
    }

    public AlunoRespostaDTO toDTO(Aluno aluno) {
        return new AlunoRespostaDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getDataNascimento()
        );
    }

    public List<AlunoRespostaDTO> toDTOList(List<Aluno> alunos) {
        return alunos.stream()
                .map(this::toDTO)
                .toList();
    }
}
