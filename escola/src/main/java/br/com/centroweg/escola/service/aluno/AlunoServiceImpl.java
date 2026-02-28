package br.com.centroweg.escola.service.aluno;

import br.com.centroweg.escola.dto.aluno.AlunoRequisicaoDTO;
import br.com.centroweg.escola.dto.aluno.AlunoRespostaDTO;
import br.com.centroweg.escola.mapper.aluno.AlunoMapper;
import br.com.centroweg.escola.model.Aluno;
import br.com.centroweg.escola.repository.aluno.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService{
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
        Aluno aluno = mapper.toEntity(requisicaoDTO);
        return mapper.toDTO(repository.save(aluno));
    }

    @Override
    public AlunoRespostaDTO update(AlunoRequisicaoDTO requisicaoDTO, Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Aluno não existe");
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
}
