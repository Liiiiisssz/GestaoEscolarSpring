package br.com.centroweg.escola.controller.nota;

import br.com.centroweg.escola.dto.nota.NotaRequisicaoDTO;
import br.com.centroweg.escola.dto.nota.NotaRespostaDTO;
import br.com.centroweg.escola.service.nota.NotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola/nota")
public class NotaControllerImpl implements NotaController{
    private final NotaService service;
    public NotaControllerImpl(NotaService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<NotaRespostaDTO> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public NotaRespostaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @Override
    @PostMapping
    public NotaRespostaDTO save(@RequestBody NotaRequisicaoDTO requisicaoDTO) {
        return service.save(requisicaoDTO);
    }

    @Override
    @PutMapping("/{id}")
    public NotaRespostaDTO update(@RequestBody NotaRequisicaoDTO requisicaoDTO, @PathVariable Integer id) {
        return service.update(requisicaoDTO, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
