package br.com.centroweg.escola.repository.professor;

import br.com.centroweg.escola.model.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository {
    List<Professor> findAll();
    Optional<Professor> findById(Integer id);
    Professor save(Professor professor);
    void update(Professor professor);
    void delete(Integer id);
    boolean exists(Integer id);
}
