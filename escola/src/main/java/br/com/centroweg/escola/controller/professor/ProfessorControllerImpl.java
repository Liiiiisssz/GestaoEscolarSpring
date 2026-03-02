package br.com.centroweg.escola.controller.professor;

import br.com.centroweg.escola.dto.professor.ProfessorRequisicaoDTO;
import br.com.centroweg.escola.dto.professor.ProfessorRespostaDTO;
import br.com.centroweg.escola.service.professor.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/professor")
public class ProfessorControllerImpl implements ProfessorController{
    private final ProfessorService service;
    public ProfessorControllerImpl(ProfessorService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<ProfessorRespostaDTO> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ProfessorRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @Override
    @PostMapping
    public ProfessorRespostaDTO save(@RequestBody ProfessorRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @Override
    @PutMapping("/{id}")
    public ProfessorRespostaDTO update(@RequestBody ProfessorRequisicaoDTO requisicaoDTO, @PathVariable Integer id) {
        return service.update(requisicaoDTO, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
