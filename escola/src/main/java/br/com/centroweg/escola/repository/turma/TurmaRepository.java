package br.com.centroweg.escola.repository.turma;

import br.com.centroweg.escola.model.Aluno;
import br.com.centroweg.escola.model.Turma;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository {
    List<Turma> findAll();
    Optional<Turma> findById(Integer id);
    Turma save(Turma turma);
    void update(Turma turma);
    void delete(Integer id);
    boolean exists(Integer id);
}
