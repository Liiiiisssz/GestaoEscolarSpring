package br.com.centroweg.escola.domain.professor;

import br.com.centroweg.escola.domain.professor.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository {
    List<Professor> findAll();
    Optional<Professor> findById(Integer id);
    Professor save(Professor professor);
    void update(Professor professor);
    void delete(Integer id);
    boolean exists(Integer id);
    boolean verifyEmail(String email);
    boolean verifyEmailUpdate(String email, Integer id);
}
