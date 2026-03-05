package br.com.centroweg.escola.domain.turma;

import br.com.centroweg.escola.domain.turma.Turma;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface TurmaRepository {
    List<Turma> findAll();
    Optional<Turma> findById(Integer id);
    Turma save(Turma turma);
    void update(Turma turma);
    void delete(Integer id);
    boolean exists(Integer id);
    List<String> findAlunosByTurmaId(Integer id, Connection conn) throws SQLException;
}
