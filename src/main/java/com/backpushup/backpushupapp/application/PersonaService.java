package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backpushup.backpushupapp.domain.Persona;
import com.backpushup.backpushupapp.infrastructure.out.PersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public List<Persona> findAll(){
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(Long id){
        return personaRepository.findById(id);
    }

    public Persona save(Persona persona){
        return personaRepository.save(persona);
    }

    public void deleteById(Long id){
        personaRepository.deleteById(id);
    }
}
