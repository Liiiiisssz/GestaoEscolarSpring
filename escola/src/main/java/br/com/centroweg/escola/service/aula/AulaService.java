package br.com.centroweg.escola.service.aula;

import br.com.centroweg.escola.dto.aula.AulaRequisicaoDTO;
import br.com.centroweg.escola.dto.aula.AulaRespostaDTO;

import java.util.List;

public interface AulaService {
    List<AulaRespostaDTO> findAll();
    AulaRespostaDTO findById(Integer id);
    AulaRespostaDTO save(AulaRequisicaoDTO requisicaoDTO);
    AulaRespostaDTO update(AulaRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
