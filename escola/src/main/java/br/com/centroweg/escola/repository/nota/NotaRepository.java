package br.com.centroweg.escola.repository.nota;

import br.com.centroweg.escola.model.Nota;

import java.util.List;
import java.util.Optional;

public interface NotaRepository {
    List<Nota> findAll();
    Optional<Nota> findById(Integer id);
    Nota save();
    void update(Nota nota);
    void delete(Integer id);
    boolean exists(Integer id);
}
