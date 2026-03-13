package br.com.centroweg.escola.domain.nota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaJdbcRepository extends JpaRepository<Nota, Integer> {
}
