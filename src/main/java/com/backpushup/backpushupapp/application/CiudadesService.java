package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backpushup.backpushupapp.domain.Ciudades;
import com.backpushup.backpushupapp.infrastructure.out.CiudadesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CiudadesService {

    private final CiudadesRepository ciudadesRepository;

    public List<Ciudades> findAll(){
        return ciudadesRepository.findAll();
    }

    public Optional<Ciudades> findById(Long id){
        return ciudadesRepository.findById(id);
    }

    public Ciudades save(Ciudades ciudades){
        return ciudadesRepository.save(ciudades);
    }

    public void deleteById(Long id){
        ciudadesRepository.deleteById(id);
    }
}
