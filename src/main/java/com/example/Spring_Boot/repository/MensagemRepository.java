package com.example.Spring_Boot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

    public String obterMensagem(){
        return "Olá mundo";
    }
}
