package com.educa.projeto_engenharia_software.infra.handlers;

import com.educa.projeto_engenharia_software.infra.exceptions.AlunoNotFoundException;
import com.educa.projeto_engenharia_software.infra.exceptions.DisciplinaNotFoundException;
import com.educa.projeto_engenharia_software.infra.exceptions.LimiteDisciplinasExcedidoException;
import com.educa.projeto_engenharia_software.infra.exceptions.ProfessorNotFoundException;
import com.educa.projeto_engenharia_software.infra.messages.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ProfessorNotFoundException.class})
    private ResponseEntity<RestErrorMessage> professorNotFoundHandler(ProfessorNotFoundException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler({AlunoNotFoundException.class})
    private ResponseEntity<RestErrorMessage> alunoNotFoundHandler(AlunoNotFoundException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler({DisciplinaNotFoundException.class})
    private ResponseEntity<RestErrorMessage> disciplinaNotFoundHandler(DisciplinaNotFoundException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler({LimiteDisciplinasExcedidoException.class})
    private ResponseEntity<RestErrorMessage> limiteDisciplinasExcedidoHandler(LimiteDisciplinasExcedidoException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
}
