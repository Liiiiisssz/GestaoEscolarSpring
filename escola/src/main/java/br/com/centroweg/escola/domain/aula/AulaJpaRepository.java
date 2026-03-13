package br.com.centroweg.escola.domain.aula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaJpaRepository extends JpaRepository<Aula, Integer> {
}
