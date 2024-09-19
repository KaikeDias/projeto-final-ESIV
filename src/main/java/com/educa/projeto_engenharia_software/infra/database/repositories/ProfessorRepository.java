package com.educa.projeto_engenharia_software.infra.database.repositories;

import com.educa.projeto_engenharia_software.domain.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
