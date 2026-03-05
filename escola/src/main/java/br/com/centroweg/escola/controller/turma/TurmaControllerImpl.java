package br.com.centroweg.escola.controller.turma;

import br.com.centroweg.escola.dto.turma.TurmaRequisicaoDTO;
import br.com.centroweg.escola.dto.turma.TurmaRespostaDTO;
import br.com.centroweg.escola.service.turma.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/turma")
public class TurmaControllerImpl implements TurmaController {
    private final TurmaService service;
    public TurmaControllerImpl(TurmaService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<TurmaRespostaDTO> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public TurmaRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @Override
    @PostMapping
    public TurmaRespostaDTO save(@RequestBody TurmaRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @Override
    @PutMapping("/{id}")
    public TurmaRespostaDTO update(@RequestBody TurmaRequisicaoDTO requisicaoDTO, @PathVariable Integer id) {
        return service.update(requisicaoDTO, id);
    }

    @Override
    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
