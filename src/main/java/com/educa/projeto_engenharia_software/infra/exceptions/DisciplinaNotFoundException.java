package com.educa.projeto_engenharia_software.infra.exceptions;

public class DisciplinaNotFoundException extends RuntimeException{
    public DisciplinaNotFoundException(){super("Disciplina não encontrada");}

    public DisciplinaNotFoundException(String message){super(message);}
}
