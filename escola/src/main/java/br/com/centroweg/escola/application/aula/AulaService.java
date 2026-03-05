package br.com.centroweg.escola.application.aula;

import br.com.centroweg.escola.application.aula.dto.AulaRequisicaoDTO;
import br.com.centroweg.escola.application.aula.dto.AulaRespostaDTO;

import java.util.List;

public interface AulaService {
    List<AulaRespostaDTO> findAll();
    AulaRespostaDTO findById(Integer id);
    AulaRespostaDTO save(AulaRequisicaoDTO requisicaoDTO);
    AulaRespostaDTO update(AulaRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
