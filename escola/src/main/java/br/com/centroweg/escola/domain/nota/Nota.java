package br.com.centroweg.escola.domain.nota;

import br.com.centroweg.escola.domain.aluno.Aluno;
import br.com.centroweg.escola.domain.aula.Aula;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nota")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    private Double valor;
}
