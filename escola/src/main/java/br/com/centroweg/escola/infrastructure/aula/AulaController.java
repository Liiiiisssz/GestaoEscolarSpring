package br.com.centroweg.escola.infrastructure.aula;

import br.com.centroweg.escola.application.aula.dto.AulaRequisicaoDTO;
import br.com.centroweg.escola.application.aula.dto.AulaRespostaDTO;
import br.com.centroweg.escola.application.aula.AulaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/aula")
public class AulaController{
    private final AulaService service;
    public AulaController(AulaService service) {
        this.service = service;
    }

    @GetMapping
    public List<AulaRespostaDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AulaRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public AulaRespostaDTO save(@Valid @RequestBody AulaRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @PutMapping("/{id}")
    public AulaRespostaDTO update(@Valid @RequestBody AulaRequisicaoDTO requisicaoDTO, @PathVariable Integer id) {
        return service.update(requisicaoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
