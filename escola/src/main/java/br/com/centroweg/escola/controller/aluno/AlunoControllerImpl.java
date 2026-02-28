package br.com.centroweg.escola.controller.aluno;

import br.com.centroweg.escola.dto.aluno.AlunoRequisicaoDTO;
import br.com.centroweg.escola.dto.aluno.AlunoRespostaDTO;
import br.com.centroweg.escola.service.aluno.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/aluno")
public class AlunoControllerImpl implements AlunoController{
    private final AlunoService service;
    public AlunoControllerImpl(AlunoService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<AlunoRespostaDTO> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public AlunoRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @Override
    @PostMapping
    public AlunoRespostaDTO save(@RequestBody AlunoRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @Override
    @PutMapping("/{id}")
    public AlunoRespostaDTO update(@PathVariable Integer id, @RequestBody AlunoRequisicaoDTO requisicaoDTO) {
        return service.update(requisicaoDTO, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
