package br.com.centroweg.escola.infrastructure.web.aluno;

import br.com.centroweg.escola.application.aluno.dto.AlunoNotasRespostaDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRequisicaoDTO;
import br.com.centroweg.escola.application.aluno.dto.AlunoRespostaDTO;
import br.com.centroweg.escola.application.aluno.AlunoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/aluno")
public class AlunoController {
    private final AlunoService service;
    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AlunoRespostaDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AlunoRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public AlunoRespostaDTO save(@Valid @RequestBody AlunoRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @PutMapping("/{id}")
    public AlunoRespostaDTO update(@PathVariable Integer id, @Valid @RequestBody AlunoRequisicaoDTO requisicaoDTO) {
        return service.update(requisicaoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/{id}/notas")
    public List<AlunoNotasRespostaDTO> listNotas(@PathVariable Integer id){
        return service.listNotas(id);
    }
}
