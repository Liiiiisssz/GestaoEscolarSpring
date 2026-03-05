package br.com.centroweg.escola.application.aula;

import br.com.centroweg.escola.application.aula.dto.AulaRequisicaoDTO;
import br.com.centroweg.escola.application.aula.dto.AulaRespostaDTO;
import br.com.centroweg.escola.application.aula.mapper.AulaMapper;
import br.com.centroweg.escola.domain.aula.Aula;
import br.com.centroweg.escola.domain.aula.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {
    private final AulaRepository repository;
    private final AulaMapper mapper;
    public AulaServiceImpl(AulaRepository repository, AulaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<AulaRespostaDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public AulaRespostaDTO findById(Integer id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada")));
    }

    @Override
    public AulaRespostaDTO save(AulaRequisicaoDTO requisicaoDTO) {
        Aula aula = mapper.toEntity(requisicaoDTO);
        return mapper.toDTO(repository.save(aula));
    }

    @Override
    public AulaRespostaDTO update(AulaRequisicaoDTO requisicaoDTO, Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Aula não existe");
        }
        Aula aula = mapper.toEntity(requisicaoDTO);
        aula.setId(id);
        repository.update(aula);
        return mapper.toDTO(aula);
    }

    @Override
    public void delete(Integer id) {
        if(!repository.exists(id)){
            throw new RuntimeException("Aula não existe");
        }
        repository.delete(id);
    }
}
