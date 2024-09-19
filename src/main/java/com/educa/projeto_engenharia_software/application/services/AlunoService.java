package com.educa.projeto_engenharia_software.application.services;

import com.educa.projeto_engenharia_software.application.DTOs.AlunoDTO;
import com.educa.projeto_engenharia_software.application.DTOs.MatricularAlunoDTO;
import com.educa.projeto_engenharia_software.domain.entities.Aluno;
import com.educa.projeto_engenharia_software.domain.entities.Disciplina;
import com.educa.projeto_engenharia_software.infra.database.repositories.AlunoRepository;
import com.educa.projeto_engenharia_software.infra.database.repositories.DisciplinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final DisciplinaService disciplinaService;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository, DisciplinaService disciplinaService) {
        this.alunoRepository = alunoRepository;
        this.disciplinaService = disciplinaService;
    }

    public void create(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.nome());
        aluno.setEmail(alunoDTO.email());

        alunoRepository.save(aluno);
    }

    public List<Aluno> fingAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if(aluno.isEmpty()) {
            throw new EntityNotFoundException("Aluno não encontrado");
        }

        return aluno.get();
    }

    public void delete(long id) {
        alunoRepository.deleteById(id);
    }

    public void matricularAluno(MatricularAlunoDTO matricularAlunoDTO) {
        Aluno aluno = findById(matricularAlunoDTO.alunoId());

        if(aluno.getDisciplinas().size() == 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Aluno alcançou o limite maximo de disciplinas!");
        }

        for(Disciplina disciplina : aluno.getDisciplinas()) {
            if(disciplina.getId() == matricularAlunoDTO.disciplinaId()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Aluno já está matriculado nessa disciplina!");
            }
        }

        Disciplina disciplina = disciplinaService.findById(matricularAlunoDTO.disciplinaId());

        List<Disciplina> disciplinas = aluno.getDisciplinas();
        disciplinas.add(disciplina);
        aluno.setDisciplinas(disciplinas);

        alunoRepository.save(aluno);
    }

    public List<Disciplina> buscarDisciplinasMatriculadas(long id) {
        Aluno aluno = findById(id);

        return aluno.getDisciplinas();
    }
}
