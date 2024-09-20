package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Regiones;
import com.backpushup.backpushupapp.infrastructure.out.RegionesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegionesService {

    private final RegionesRepository regionesRepository;

    public List<Regiones> findAll() {
        return regionesRepository.findAll();
    }

    public Optional<Regiones> findById(Long id) {
        return regionesRepository.findById(id);
    }

    public Regiones save(Regiones entity) {
        return regionesRepository.save(entity);
    }

    public void deleteById(Long id) {
        regionesRepository.deleteById(id);
    }
}
