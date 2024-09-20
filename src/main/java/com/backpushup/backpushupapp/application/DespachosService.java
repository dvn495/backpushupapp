package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Despachos;
import com.backpushup.backpushupapp.infrastructure.out.DespachosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DespachosService {

    private final DespachosRepository despachosRepository;

    public List<Despachos> findAll() {
        return despachosRepository.findAll();
    }

    public Optional<Despachos> findById(Long id) {
        return despachosRepository.findById(id);
    }

    public Despachos save(Despachos entity) {
        return despachosRepository.save(entity);
    }

    public void deleteById(Long id) {
        despachosRepository.deleteById(id);
    }
}
