package br.com.centroweg.escola.domain.curso;

import br.com.centroweg.escola.domain.turma.Turma;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "curso")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String codigo;

    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas;
}
