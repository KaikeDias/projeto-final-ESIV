package com.educa.projeto_engenharia_software.presentation.controllers;

import com.educa.projeto_engenharia_software.application.DTOs.ProfessorDTO;
import com.educa.projeto_engenharia_software.application.services.ProfessorService;
import com.educa.projeto_engenharia_software.domain.entities.Professor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProfessorDTO professorDTO) {
        professorService.create(professorDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        List<Professor> professores = professorService.findAll();

        return ResponseEntity.ok(professores);
    }

    @GetMapping("{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        Professor professor = professorService.findById(id);

        return ResponseEntity.ok(professor);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
