package com.example.Spring_Boot.controller;

import com.example.Spring_Boot.repository.MensagemRepository;
import com.example.Spring_Boot.service.MensagemService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService){
        this.mensagemService = mensagemService;
    }

    @GetMapping("/mensagem")
    public String obterMensagem(){
        return mensagemService.obterMensagem();
    }
}
