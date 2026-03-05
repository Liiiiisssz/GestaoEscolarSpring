package br.com.centroweg.escola.controller.aula;

import br.com.centroweg.escola.dto.aula.AulaRequisicaoDTO;
import br.com.centroweg.escola.dto.aula.AulaRespostaDTO;

import java.util.List;

public interface AulaController {
    List<AulaRespostaDTO> findAll();
    AulaRespostaDTO findById(Integer id);
    AulaRespostaDTO save(AulaRequisicaoDTO requisicaoDTO);
    AulaRespostaDTO update(AulaRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
