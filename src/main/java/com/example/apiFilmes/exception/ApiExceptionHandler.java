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

        MensagemErro erro = this.construirMensagemErro(HttpStatus.CONFLICT.value(),
                "Argumento Inválido",
                this.construirListaErros(result),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MensagemErro> entityNotFoundException (EntityNotFoundException e, HttpServletRequest request){
        List<String> mensagem = new ArrayList<String>();
        mensagem.add(e.getMessage());

        MensagemErro erro = this.construirMensagemErro(
                HttpStatus.NOT_FOUND.value(),
                "Entidade Não Foi Encontrada!",
                mensagem,
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    private MensagemErro construirMensagemErro(int httpStatus, String type, List<String> mensagem, String path) {
        return MensagemErro.builder()
                .timestamp(Instant.now())
                .status(httpStatus)
                .type(type)
                .message(mensagem)
                .path(path)
                .build();
    }

    private List<String> construirListaErros(BindingResult result){
        List<String> mensagens = result.getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return mensagens;
    }
}
