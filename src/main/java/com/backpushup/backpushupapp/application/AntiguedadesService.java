package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Antiguedades;
import com.backpushup.backpushupapp.infrastructure.out.AntiguedadesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AntiguedadesService {

    private final AntiguedadesRepository antiguedadesRepository;

    public List<Antiguedades> findAll() {
        return antiguedadesRepository.findAll();
    }

    public Optional<Antiguedades> findById(Long id) {
        return antiguedadesRepository.findById(id);
    }

    public Antiguedades save(Antiguedades entity) {
        return antiguedadesRepository.save(entity);
    }

    public void deleteById(Long id) {
        antiguedadesRepository.deleteById(id);
    }
}
