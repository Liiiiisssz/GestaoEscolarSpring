package br.com.centroweg.escola.domain.turma;

import br.com.centroweg.escola.domain.aluno.Aluno;
import br.com.centroweg.escola.domain.curso.Curso;
import br.com.centroweg.escola.domain.professor.Professor;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "turma")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany
    @JoinTable(
            name = "turma_aluno",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Aluno> alunos;
}
