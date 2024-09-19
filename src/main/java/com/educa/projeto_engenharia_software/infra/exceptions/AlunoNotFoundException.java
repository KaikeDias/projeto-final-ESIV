package com.educa.projeto_engenharia_software.infra.exceptions;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(){super("Aluno não encontrado");}

    public AlunoNotFoundException(String message) {super(message);}
}
