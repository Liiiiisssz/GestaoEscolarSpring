package br.com.centroweg.escola.domain.curso;

import br.com.centroweg.escola.domain.curso.Curso;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CursoRepository {
    List<Curso> findAll();
    Optional<Curso> findById(Integer id);
    Curso save(Curso curso);
    void update(Curso curso);
    void delete(Integer id);
    boolean exists(Integer id);
    List<String> findProfessors(Integer id, Connection conn) throws SQLException;
}
