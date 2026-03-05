package br.com.centroweg.escola.service.nota;

import br.com.centroweg.escola.dto.nota.NotaRequisicaoDTO;
import br.com.centroweg.escola.dto.nota.NotaRespostaDTO;
import br.com.centroweg.escola.mapper.nota.NotaMapper;
import br.com.centroweg.escola.model.Nota;
import br.com.centroweg.escola.repository.nota.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService{
    private final NotaMapper mapper;
    private final NotaRepository repository;
    public NotaServiceImpl(NotaMapper mapper, NotaRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<NotaRespostaDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public NotaRespostaDTO findById(Integer id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada")));
    }

    @Override
    public NotaRespostaDTO save(NotaRequisicaoDTO requisicaoDTO) {
        Nota nota = mapper.toEntity(requisicaoDTO);
        return mapper.toDTO(repository.save(nota));
    }

    @Override
    public NotaRespostaDTO update(NotaRequisicaoDTO requisicaoDTO, Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Nota não existe");
        }
        Nota nota = mapper.toEntity(requisicaoDTO);
        nota.setId(id);
        repository.update(nota);
        return mapper.toDTO(nota);
    }

    @Override
    public void delete(Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Nota não existe");
        }
        repository.delete(id);
    }
}
