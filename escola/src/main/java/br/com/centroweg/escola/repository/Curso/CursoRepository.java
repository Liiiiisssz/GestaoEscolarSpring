package br.com.centroweg.escola.repository.Curso;

import br.com.centroweg.escola.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository {
    List<Curso> findAll();
    Optional<Curso> findById(Integer id);
    Curso save(Curso curso);
    void update(Curso curso);
    void delete(Integer id);
    boolean exists(Integer id);
}
