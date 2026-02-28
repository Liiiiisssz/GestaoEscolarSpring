package br.com.centroweg.escola.controller.aluno;

import br.com.centroweg.escola.dto.aluno.AlunoRequisicaoDTO;
import br.com.centroweg.escola.dto.aluno.AlunoRespostaDTO;

import java.util.List;

public interface AlunoController {
    List<AlunoRespostaDTO> findAll();
    AlunoRespostaDTO findById(Integer id);
    AlunoRespostaDTO save(AlunoRequisicaoDTO requisicaoDTO);

    AlunoRespostaDTO update(Integer id, AlunoRequisicaoDTO requisicaoDTO);

    void delete(Integer id);
}
