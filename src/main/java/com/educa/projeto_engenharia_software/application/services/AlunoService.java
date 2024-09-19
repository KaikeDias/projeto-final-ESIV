package com.educa.projeto_engenharia_software.application.services;

import com.educa.projeto_engenharia_software.application.DTOs.AlunoDTO;
import com.educa.projeto_engenharia_software.domain.entities.Aluno;
import com.educa.projeto_engenharia_software.infra.database.repositories.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
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
}
