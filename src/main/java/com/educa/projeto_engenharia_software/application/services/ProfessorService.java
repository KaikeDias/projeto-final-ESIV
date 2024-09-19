package com.educa.projeto_engenharia_software.application.services;

import com.educa.projeto_engenharia_software.application.DTOs.ProfessorDTO;
import com.educa.projeto_engenharia_software.domain.entities.Disciplina;
import com.educa.projeto_engenharia_software.domain.entities.Professor;
import com.educa.projeto_engenharia_software.infra.database.repositories.ProfessorRepository;
import com.educa.projeto_engenharia_software.infra.exceptions.ProfessorNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void create(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setNome(professorDTO.nome());
        professor.setEmail(professorDTO.email());

        professorRepository.save(professor);
    }

    public List<Professor> findAll() {
        List<Professor> professores = professorRepository.findAll();

        return professores;
    }

    public Professor findById(long id) {
        Optional<Professor> professor = professorRepository.findById(id);

        if(professor.isEmpty()) {
            throw new ProfessorNotFoundException();
        }

        return professor.get();
    }

    public void delete(long id) {
        Professor professor = findById(id);

        professorRepository.deleteById(id);
    }

    public List<Disciplina> buscaDisciplinas(long id) {
        Professor professor = findById(id);

        return professor.getDisciplinas();
    }
}
