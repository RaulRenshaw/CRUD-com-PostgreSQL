package com.example.Spring_Boot.service;

import com.example.Spring_Boot.repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository){
        this.mensagemRepository = mensagemRepository;
    }
    public String obterMensagem(){
        return mensagemRepository.obterMensagem();
    }
}
