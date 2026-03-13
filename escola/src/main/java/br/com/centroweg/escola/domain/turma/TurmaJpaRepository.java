package br.com.centroweg.escola.domain.turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaJpaRepository extends JpaRepository<Turma, Integer> {
}
