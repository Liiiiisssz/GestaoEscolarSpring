package br.com.centroweg.escola.service.professor;

import br.com.centroweg.escola.dto.professor.ProfessorRequisicaoDTO;
import br.com.centroweg.escola.dto.professor.ProfessorRespostaDTO;
import br.com.centroweg.escola.mapper.professor.ProfessorMapper;
import br.com.centroweg.escola.model.Professor;
import br.com.centroweg.escola.repository.professor.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService{
    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;
    public ProfessorServiceImpl(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProfessorRespostaDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public ProfessorRespostaDTO findById(Integer id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"))
        );
    }

    @Override
    public ProfessorRespostaDTO save(ProfessorRequisicaoDTO requisicaoDTO) {
        Professor professor = mapper.toEntity(requisicaoDTO);
        return mapper.toDTO(repository.save(professor));
    }

    @Override
    public ProfessorRespostaDTO update(ProfessorRequisicaoDTO requisicaoDTO, Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Professor não existe");
        }
        Professor professor = mapper.toEntity(requisicaoDTO);
        professor.setId(id);
        repository.update(professor);
        return mapper.toDTO(professor);
    }

    @Override
    public void delete(Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Professor não existe");
        }
        repository.delete(id);
    }
}
