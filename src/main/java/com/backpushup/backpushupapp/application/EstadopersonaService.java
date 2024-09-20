package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Estadopersona;
import com.backpushup.backpushupapp.infrastructure.out.EstadopersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstadopersonaService {

    private final EstadopersonaRepository estadopersonaRepository;

    public List<Estadopersona> findAll() {
        return estadopersonaRepository.findAll();
    }

    public Optional<Estadopersona> findById(Long id) {
        return estadopersonaRepository.findById(id);
    }

    public Estadopersona save(Estadopersona entity) {
        return estadopersonaRepository.save(entity);
    }

    public void deleteById(Long id) {
        estadopersonaRepository.deleteById(id);
    }
}
