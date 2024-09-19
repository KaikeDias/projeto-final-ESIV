package com.educa.projeto_engenharia_software.infra.exceptions;

public class LimiteDisciplinasExcedidoException extends RuntimeException {
    public LimiteDisciplinasExcedidoException(String message) {super(message);}

    public LimiteDisciplinasExcedidoException(){super("Este aluno não pode se matricular em mais disciplinas pois atingiu o limite maximo");}
}
