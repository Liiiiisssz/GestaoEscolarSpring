package br.com.centroweg.escola.application.aluno;

import br.com.centroweg.escola.application.aluno.dto.AlunoNotasRespostaDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRequisicaoDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRespostaDTO;
import br.com.centroweg.escola.application.aluno.mapper.AlunoMapper;
import br.com.centroweg.escola.domain.aluno.Aluno;
import br.com.centroweg.escola.domain.aluno.AlunoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {
    private final AlunoJpaRepository repository;
    private final AlunoMapper mapper;

    @Override
    public List<AlunoRespostaDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public AlunoRespostaDTO findById(Integer id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"))
        );
    }

    @Override
    public AlunoRespostaDTO save(AlunoRequisicaoDTO requisicaoDTO) {
        if(repository.existsByEmail(requisicaoDTO.email())){
            throw new RuntimeException("Email já cadastrado");
        }
        Aluno aluno = mapper.toEntity(requisicaoDTO);
        return mapper.toDTO(repository.save(aluno));
    }

    @Override
    public AlunoRespostaDTO update(AlunoRequisicaoDTO requisicaoDTO, Integer id) {
        if(repository.existsByEmailAndIdNot(requisicaoDTO.email(), id)){
            throw new RuntimeException("Email já cadastrado");
        }
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não existe"));
        aluno.setNome(requisicaoDTO.nome());
        aluno.setEmail(requisicaoDTO.email());
        aluno.setMatricula(requisicaoDTO.matricula());
        aluno.setDataNascimento(requisicaoDTO.dataNascimento());
        return mapper.toDTO(repository.save(aluno));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("Aluno não existe");
        }
        repository.deleteById(id);
    }

    @Override
    public List<AlunoNotasRespostaDTO> listNotas(Integer id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("Aluno não existe");
        }
        return repository.listNotas(id);
    }
}
