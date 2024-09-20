package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Paises;
import com.backpushup.backpushupapp.infrastructure.out.PaisesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaisesService {

    private final PaisesRepository paisesRepository;

    public List<Paises> findAll() {
        return paisesRepository.findAll();
    }

    public Optional<Paises> findById(Long id) {
        return paisesRepository.findById(id);
    }

    public Paises save(Paises entity) {
        return paisesRepository.save(entity);
    }

    public void deleteById(Long id) {
        paisesRepository.deleteById(id);
    }
}
