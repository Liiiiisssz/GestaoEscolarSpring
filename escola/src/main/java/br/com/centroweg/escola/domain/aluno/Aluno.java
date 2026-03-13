package br.com.centroweg.escola.domain.aluno;

import br.com.centroweg.escola.domain.turma.Turma;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "aluno")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @Column(unique = true)
    private String email;
    private String matricula;
    private LocalDate dataNascimento;

    @ManyToMany(mappedBy = "alunos")
    private List<Turma> turmas;
}
