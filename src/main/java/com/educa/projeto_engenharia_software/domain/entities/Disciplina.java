package com.educa.projeto_engenharia_software.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonIgnore
    private Professor professor;

    @ManyToMany(mappedBy = "disciplinas")
    @JsonIgnore
    private List<Aluno> alunos;

    // Getters e Setters
}

