package com.educa.projeto_engenharia_software.infra.database.repositories;

import com.educa.projeto_engenharia_software.domain.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
