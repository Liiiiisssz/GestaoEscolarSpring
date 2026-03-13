package br.com.centroweg.escola.domain.aula;

import br.com.centroweg.escola.domain.turma.Turma;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "aula")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    private LocalDateTime dataHora;
    private String assunto;
}
