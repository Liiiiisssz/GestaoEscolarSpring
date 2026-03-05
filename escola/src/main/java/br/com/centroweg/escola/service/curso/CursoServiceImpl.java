package br.com.centroweg.escola.service.curso;

import br.com.centroweg.escola.dto.curso.CursoRequisicaoDTO;
import br.com.centroweg.escola.dto.curso.CursoRespostaDTO;
import br.com.centroweg.escola.mapper.curso.CursoMapper;
import br.com.centroweg.escola.model.Curso;
import br.com.centroweg.escola.repository.curso.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoMapper mapper;
    private final CursoRepository repository;
    public CursoServiceImpl(CursoMapper mapper, CursoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<CursoRespostaDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public CursoRespostaDTO findById(Integer id) {
       return mapper.toDTO(repository.findById(id)
               .orElseThrow(() -> new RuntimeException("Curso não encontrado")));
    }

    @Override
    public CursoRespostaDTO save(CursoRequisicaoDTO requisicaoDTO) {
        Curso curso = mapper.toEntity(requisicaoDTO);
        return mapper.toDTO(repository.save(curso));
    }

    @Override
    public CursoRespostaDTO update(CursoRequisicaoDTO requisicaoDTO, Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Curso não existe");
        }
        Curso curso = mapper.toEntity(requisicaoDTO);
        curso.setId(id);
        repository.update(curso);
        return mapper.toDTO(curso);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.exists(id)){
            throw new RuntimeException("Curso não existe");
        }
        repository.delete(id);
    }
}
