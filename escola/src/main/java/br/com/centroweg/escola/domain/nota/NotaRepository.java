package br.com.centroweg.escola.domain.nota;

import br.com.centroweg.escola.domain.nota.Nota;

import java.util.List;
import java.util.Optional;

public interface NotaRepository {
    List<Nota> findAll();
    Optional<Nota> findById(Integer id);
    Nota save(Nota nota);
    void update(Nota nota);
    void delete(Integer id);
    boolean exists(Integer id);
}
