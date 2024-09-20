package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backpushup.backpushupapp.domain.Galeria;
import com.backpushup.backpushupapp.infrastructure.out.GaleriaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GaleriaService {

    private final GaleriaRepository galeriaRepository;

    public List<Galeria> findAll(){
        return galeriaRepository.findAll();
    }

    public Optional<Galeria> findById(Long id){
        return galeriaRepository.findById(id);
    }

    public Galeria save(Galeria galeria){
        return galeriaRepository.save(galeria);
    }

    public void deleteById(Long id){
        galeriaRepository.deleteById(id);
    }
}
