package br.com.centroweg.escola.service.nota;

import br.com.centroweg.escola.dto.nota.NotaRequisicaoDTO;
import br.com.centroweg.escola.dto.nota.NotaRespostaDTO;

import java.util.List;

public interface NotaService {
    List<NotaRespostaDTO> findAll();
    NotaRespostaDTO findById(Integer id);
    NotaRespostaDTO save(NotaRequisicaoDTO requisicaoDTO);
    NotaRespostaDTO update(NotaRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
