package br.com.centroweg.escola.infrastructure.turma;

import br.com.centroweg.escola.application.turma.dto.TurmaRequisicaoDTO;
import br.com.centroweg.escola.application.turma.dto.TurmaRespostaDTO;
import br.com.centroweg.escola.application.turma.TurmaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/turma")
public class TurmaController {
    private final TurmaService service;
    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TurmaRespostaDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TurmaRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public TurmaRespostaDTO save(@Valid @RequestBody TurmaRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @PutMapping("/{id}")
    public TurmaRespostaDTO update(@Valid @RequestBody TurmaRequisicaoDTO requisicaoDTO, @PathVariable Integer id) {
        return service.update(requisicaoDTO, id);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
