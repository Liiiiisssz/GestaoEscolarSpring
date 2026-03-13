package br.com.centroweg.escola.domain.aluno;

import br.com.centroweg.escola.application.aluno.dto.AlunoNotasRespostaDTO;
import br.com.centroweg.escola.domain.nota.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoJpaRepository extends JpaRepository<Aluno, Integer> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Integer id);
    @Query("""
        SELECT new br.com.centroweg.escola.application.aluno.dto.NotaAlunoDTO(
            a.nome,
            au.assunto,
            n.valor
        )
        FROM Nota n
        JOIN n.aluno a
        LEFT JOIN n.aula au
        WHERE a.id = :id
    """)
    List<AlunoNotasRespostaDTO> listNotas(@Param("id") Integer id);
}
