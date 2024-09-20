package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backpushup.backpushupapp.domain.Direccionpersona;
import com.backpushup.backpushupapp.infrastructure.out.DireccionpersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DireccionpersonaService {

    private final DireccionpersonaRepository direccionPersonaRepository;

    public List<Direccionpersona> findAll(){
        return direccionPersonaRepository.findAll();
    }

    public Optional<Direccionpersona> findById(Long id){
        return direccionPersonaRepository.findById(id);
    }

    public Direccionpersona save(Direccionpersona direccionPersona){
        return direccionPersonaRepository.save(direccionPersona);
    }

    public void deleteById(Long id){
        direccionPersonaRepository.deleteById(id);
    }
}
