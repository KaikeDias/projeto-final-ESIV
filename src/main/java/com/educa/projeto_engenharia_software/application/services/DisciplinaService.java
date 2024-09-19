package com.educa.projeto_engenharia_software.application.services;

import com.educa.projeto_engenharia_software.application.DTOs.DisciplinaDTO;
import com.educa.projeto_engenharia_software.domain.entities.Disciplina;
import com.educa.projeto_engenharia_software.domain.entities.Professor;
import com.educa.projeto_engenharia_software.infra.database.repositories.DisciplinaRepository;
import com.educa.projeto_engenharia_software.infra.exceptions.DisciplinaNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorService professorService;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository, ProfessorService professorService) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorService = professorService;
    }

    public void create(DisciplinaDTO disciplinaDTO) {
        System.out.println("DTO: " + disciplinaDTO);
        Professor professor = professorService.findById(disciplinaDTO.professorId());

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(disciplinaDTO.nome());
        disciplina.setProfessor(professor);

        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Disciplina findById(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        if(disciplina.isEmpty()) {
            throw new DisciplinaNotFoundException();
        }

        return disciplina.get();
    }

    public void delete(long id) {
        findById(id);

        disciplinaRepository.deleteById(id);
    }

    public Professor buscaProfessor(long id) {
        Disciplina disciplina = findById(id);

        Professor professor = disciplina.getProfessor();

        return professor;
    }

}
