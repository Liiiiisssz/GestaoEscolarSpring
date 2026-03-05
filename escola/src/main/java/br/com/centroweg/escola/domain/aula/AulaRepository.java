package br.com.centroweg.escola.domain.aula;

import br.com.centroweg.escola.domain.aula.Aula;

import java.util.List;
import java.util.Optional;

public interface AulaRepository {
    List<Aula> findAll();
    Optional<Aula> findById(Integer id);
    Aula save(Aula aula);
    void update(Aula aula);
    void delete(Integer id);
    boolean exists(Integer id);
}
