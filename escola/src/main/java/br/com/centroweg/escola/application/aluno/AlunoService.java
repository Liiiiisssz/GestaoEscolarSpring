package br.com.centroweg.escola.application.aluno;

import br.com.centroweg.escola.application.aluno.dto.AlunoNotasRespostaDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRequisicaoDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRespostaDTO;

import java.util.List;

public interface AlunoService {
    List<AlunoRespostaDTO> findAll();
    AlunoRespostaDTO findById(Integer id);
    AlunoRespostaDTO save(AlunoRequisicaoDTO requisicaoDTO);
    AlunoRespostaDTO update(AlunoRequisicaoDTO requisicaoDTO, Integer id);
    void delete(Integer id);
    List<AlunoNotasRespostaDTO> listNotas(Integer id);
}
