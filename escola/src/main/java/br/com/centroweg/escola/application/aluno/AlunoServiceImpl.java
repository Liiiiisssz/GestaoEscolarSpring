package br.com.centroweg.escola.application.aluno;

import br.com.centroweg.escola.application.aluno.dto.AlunoNotasRespostaDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRequisicaoDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRespostaDTO;
import br.com.centroweg.escola.application.aluno.mapper.AlunoMapper;
import br.com.centroweg.escola.domain.aluno.Aluno;
import br.com.centroweg.escola.domain.aluno.AlunoRepository;
import br.com.centroweg.escola.domain.nota.Nota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {
    private final AlunoRepository repository;
    private final AlunoMapper mapper;
    public AlunoServiceImpl(AlunoRepository repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

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
        if(repository.vefifyEmail(requisicaoDTO.email())){
            throw new RuntimeException("Email já cadastrado");
        }
        Aluno aluno = mapper.toEntity(requisicaoDTO);
        return mapper.toDTO(repository.save(aluno));
    }

    @Override
    public AlunoRespostaDTO update(AlunoRequisicaoDTO requisicaoDTO, Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Aluno não existe");
        }
        if(repository.verifyEmailUpdate(requisicaoDTO.email(), id)){
            throw new RuntimeException("Email já cadastrado");
        }
        Aluno aluno = mapper.toEntity(requisicaoDTO);
        aluno.setId(id);
        repository.update(aluno);
        return mapper.toDTO(aluno);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.exists(id)){
            throw new RuntimeException("Aluno não existe");
        }
        repository.delete(id);
    }

    @Override
    public List<AlunoNotasRespostaDTO> listNotas(Integer id) {
        if (!repository.exists(id)){
            throw new RuntimeException("Aluno não existe");
        }
        return mapper.toDTOListNota(repository.listNotas(id));
    }
}
