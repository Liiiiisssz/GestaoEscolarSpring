package br.com.centroweg.escola.infrastructure.web.professor;

import br.com.centroweg.escola.application.professor.dto.ProfessorRequisicaoDTO;
import br.com.centroweg.escola.application.professor.dto.ProfessorRespostaDTO;
import br.com.centroweg.escola.application.professor.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/professor")
public class ProfessorController{
    private final ProfessorService service;
    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProfessorRespostaDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProfessorRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ProfessorRespostaDTO save(@RequestBody ProfessorRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @PutMapping("/{id}")
    public ProfessorRespostaDTO update(@RequestBody ProfessorRequisicaoDTO requisicaoDTO, @PathVariable Integer id) {
        return service.update(requisicaoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
