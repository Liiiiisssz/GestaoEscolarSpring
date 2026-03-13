package br.com.centroweg.escola.infrastructure.nota;

import br.com.centroweg.escola.application.nota.dto.NotaRequisicaoDTO;
import br.com.centroweg.escola.application.nota.dto.NotaRespostaDTO;
import br.com.centroweg.escola.application.nota.NotaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/nota")
public class NotaController{
    private final NotaService service;
    public NotaController(NotaService service) {
        this.service = service;
    }

    @GetMapping
    public List<NotaRespostaDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public NotaRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public NotaRespostaDTO save(@Valid @RequestBody NotaRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @PutMapping("/{id}")
    public NotaRespostaDTO update(@Valid @RequestBody NotaRequisicaoDTO requisicaoDTO, @PathVariable Integer id) {
        return service.update(requisicaoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
