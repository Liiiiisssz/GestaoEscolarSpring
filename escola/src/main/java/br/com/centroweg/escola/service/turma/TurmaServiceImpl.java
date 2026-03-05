package br.com.centroweg.escola.service.turma;

import br.com.centroweg.escola.dto.turma.TurmaRequisicaoDTO;
import br.com.centroweg.escola.dto.turma.TurmaRespostaDTO;
import br.com.centroweg.escola.mapper.turma.TurmaMapper;
import br.com.centroweg.escola.model.Turma;
import br.com.centroweg.escola.repository.turma.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService{
    private final TurmaMapper mapper;
    private final TurmaRepository repository;
    public TurmaServiceImpl(TurmaMapper mapper, TurmaRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<TurmaRespostaDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public TurmaRespostaDTO findById(Integer id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada")));
    }

    @Override
    public TurmaRespostaDTO save(TurmaRequisicaoDTO requisicaoDTO) {
        Turma turma = mapper.toEntity(requisicaoDTO);
        return mapper.toDTO(repository.save(turma));
    }

    @Override
    public TurmaRespostaDTO update(TurmaRequisicaoDTO requisicaoDTO, Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Turma não existe");
        }
        Turma turma = mapper.toEntity(requisicaoDTO);
        turma.setId(id);
        repository.update(turma);
        return mapper.toDTO(turma);
    }

    @Override
    public void delete(Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Turma não existe");
        }
        repository.delete(id);
    }
}
