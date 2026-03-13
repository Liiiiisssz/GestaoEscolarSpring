package br.com.centroweg.escola.application.nota;

import br.com.centroweg.escola.application.nota.dto.NotaRequisicaoDTO;
import br.com.centroweg.escola.application.nota.dto.NotaRespostaDTO;
import br.com.centroweg.escola.application.nota.mapper.NotaMapper;
import br.com.centroweg.escola.domain.nota.Nota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {
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
        if(requisicaoDTO.valor() > 10 || requisicaoDTO.valor() < 0){
            throw new RuntimeException("Nota com valores incompatíveis");
        }
        Nota nota = mapper.toEntity(requisicaoDTO);
        return mapper.toDTO(repository.save(nota));
    }

    @Override
    public NotaRespostaDTO update(NotaRequisicaoDTO requisicaoDTO, Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Nota não existe");
        }
        if(requisicaoDTO.valor() > 10 || requisicaoDTO.valor() < 0){
            throw new RuntimeException("Nota com valores incompatíveis");
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
