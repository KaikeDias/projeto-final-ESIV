package com.educa.projeto_engenharia_software.presentation.controllers;

import com.educa.projeto_engenharia_software.application.DTOs.AlunoDTO;
import com.educa.projeto_engenharia_software.application.services.AlunoService;
import com.educa.projeto_engenharia_software.domain.entities.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(final AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Void> createAluno(@RequestBody AlunoDTO alunoDTO) {
        alunoService.create(alunoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoService.fingAll();

        return ResponseEntity.ok(alunos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable long id) {
        Aluno aluno = alunoService.findById(id);

        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable long id) {
        alunoService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
