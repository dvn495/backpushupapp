package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backpushup.backpushupapp.domain.Genero;
import com.backpushup.backpushupapp.infrastructure.out.GeneroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GeneroService {

    private final GeneroRepository generoRepository;

    public List<Genero> findAll(){
        return generoRepository.findAll();
    }

    public Optional<Genero> findById(Long id){
        return generoRepository.findById(id);
    }

    public Genero save(Genero genero){
        return generoRepository.save(genero);
    }

    public void deleteById(Long id){
        generoRepository.deleteById(id);
    }
}
