package com.educa.projeto_engenharia_software.infra.exceptions;

public class ProfessorNotFoundException extends RuntimeException{
    public ProfessorNotFoundException(){super("Professor não encontrado");}

    public ProfessorNotFoundException(String message){super(message);}
}
