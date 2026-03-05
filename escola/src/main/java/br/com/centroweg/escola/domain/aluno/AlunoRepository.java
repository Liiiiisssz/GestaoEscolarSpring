package br.com.centroweg.escola.domain.aluno;

import br.com.centroweg.escola.domain.aluno.Aluno;
import br.com.centroweg.escola.domain.nota.Nota;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository {
    List<Aluno> findAll();
    Optional<Aluno> findById(Integer id);
    Aluno save(Aluno aluno);
    void update(Aluno aluno);
    void delete(Integer id);
    boolean exists(Integer id);
    boolean vefifyEmail(String email);
    boolean verifyEmailUpdate(String email, Integer id);
    List<Nota> listNotas(Integer id);
}
