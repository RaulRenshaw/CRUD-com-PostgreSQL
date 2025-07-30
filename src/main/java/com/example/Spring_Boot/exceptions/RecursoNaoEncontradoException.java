package com.example.Spring_Boot.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{
    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
