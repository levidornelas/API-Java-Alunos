package spring_web.API_alunos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import spring_web.API_alunos.exceptions.AlunoNotFoundException;
import spring_web.API_alunos.exceptions.AlunoNullException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AlunosControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AlunoNullException.class)
    public ResponseEntity<Object> capturaErroNull(){

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("Message", "Algum campo está nulo. Verifique os campos de Aluno.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(AlunoNotFoundException.class)
    public ResponseEntity<String> handleAlunoNotFound(AlunoNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
