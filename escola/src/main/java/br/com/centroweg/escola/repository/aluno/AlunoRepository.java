package br.com.centroweg.escola.repository.aluno;

import br.com.centroweg.escola.model.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository {
    List<Aluno> findAll();
    Optional<Aluno> findById(Integer id);
    Aluno save(Aluno aluno);
    void update(Aluno aluno);
    void delete(Integer id);
    boolean exists(Integer id);
}
