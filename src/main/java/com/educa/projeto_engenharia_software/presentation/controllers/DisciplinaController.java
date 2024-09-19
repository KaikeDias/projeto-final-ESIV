package com.educa.projeto_engenharia_software.presentation.controllers;

import com.educa.projeto_engenharia_software.application.DTOs.DisciplinaDTO;
import com.educa.projeto_engenharia_software.application.services.DisciplinaService;
import com.educa.projeto_engenharia_software.domain.entities.Disciplina;
import com.educa.projeto_engenharia_software.domain.entities.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    @Autowired
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public ResponseEntity<Void> createDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        disciplinaService.create(disciplinaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> getDisciplinas() {
        List<Disciplina> disciplinas = disciplinaService.findAll();

        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable long id) {
        Disciplina disciplina = disciplinaService.findById(id);

        return ResponseEntity.ok(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplina(@PathVariable long id) {
        disciplinaService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/professor")
    public ResponseEntity<Professor> buscaProfessorResponsavel(@PathVariable long id) {
        Professor professor = disciplinaService.buscaProfessor(id);

        return ResponseEntity.ok(professor);
    }
}
