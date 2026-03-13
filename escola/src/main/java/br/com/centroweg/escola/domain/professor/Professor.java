package br.com.centroweg.escola.domain.professor;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "professor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String email;
    private String disciplina;
}
