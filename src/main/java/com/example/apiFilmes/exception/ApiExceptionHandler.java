package com.example.apiFilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensagemErro> methodArgumentNotValidException (MethodArgumentNotValidException e, HttpServletRequest request){
        BindingResult result = e.getBindingResult();

        MensagemErro erro = MensagemErro.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.CONFLICT.value())
                .type("Argumento Inválido")
                .message(this.construirMensagemErro(result))
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MensagemErro> entityNotFoundException (EntityNotFoundException e, HttpServletRequest request){
        List<String> mensagem = new ArrayList<String>();
        mensagem.add(e.getMessage());

        MensagemErro erro = MensagemErro.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .type("Entidade Não Foi Encontrada!")
                .message(mensagem)
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    private List<String> construirMensagemErro(BindingResult result){
        List<String> mensagens = result.getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return mensagens;
    }
}
