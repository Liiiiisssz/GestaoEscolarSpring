package br.com.centroweg.escola.service.aluno;

import br.com.centroweg.escola.dto.aluno.AlunoRequisicaoDTO;
import br.com.centroweg.escola.dto.aluno.AlunoRespostaDTO;

import java.util.List;

public interface AlunoService {
    List<AlunoRespostaDTO> findAll();
    AlunoRespostaDTO findById(Integer id);
    AlunoRespostaDTO save(AlunoRequisicaoDTO requisicaoDTO);
    AlunoRespostaDTO update(AlunoRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
}
