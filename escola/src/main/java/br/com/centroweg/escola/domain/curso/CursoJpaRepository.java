package br.com.centroweg.escola.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoJpaRepository extends JpaRepository<Curso, Integer> {
}
