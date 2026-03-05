package br.com.centroweg.escola.application.nota;

import br.com.centroweg.escola.application.nota.dto.NotaRequisicaoDTO;
import br.com.centroweg.escola.application.nota.dto.NotaRespostaDTO;

import java.util.List;

public interface NotaService {
    List<NotaRespostaDTO> findAll();
    NotaRespostaDTO findById(Integer id);
    NotaRespostaDTO save(NotaRequisicaoDTO requisicaoDTO);
    NotaRespostaDTO update(NotaRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
