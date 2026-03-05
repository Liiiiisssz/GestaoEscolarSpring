package br.com.centroweg.escola.controller.aula;

import br.com.centroweg.escola.dto.aula.AulaRequisicaoDTO;
import br.com.centroweg.escola.dto.aula.AulaRespostaDTO;
import br.com.centroweg.escola.service.aula.AulaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/aula")
public class AulaControllerImpl implements AulaController{
    private final AulaService service;
    public AulaControllerImpl(AulaService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<AulaRespostaDTO> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public AulaRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @Override
    @PostMapping
    public AulaRespostaDTO save(@RequestBody AulaRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @Override
    @PutMapping("/{id}")
    public AulaRespostaDTO update(@RequestBody AulaRequisicaoDTO requisicaoDTO, @PathVariable Integer id) {
        return service.update(requisicaoDTO, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
