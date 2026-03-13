package br.com.centroweg.escola.infrastructure.curso;

import br.com.centroweg.escola.application.curso.dto.CursoRequisicaoDTO;
import br.com.centroweg.escola.application.curso.dto.CursoRespostaDTO;
import br.com.centroweg.escola.application.curso.CursoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/curso")
public class CursoController{
    private final CursoService service;
    public CursoController(CursoService service) {
        this.service = service;

    }

    @GetMapping
    public List<CursoRespostaDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CursoRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public CursoRespostaDTO save(@Valid @RequestBody CursoRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @PutMapping("/{id}")
    public CursoRespostaDTO update(@Valid @RequestBody CursoRequisicaoDTO requisicaoDTO, @PathVariable Integer id) {
        return service.update(requisicaoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
