package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Historialpropiedad;
import com.backpushup.backpushupapp.infrastructure.out.HistorialpropiedadRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HistorialpropiedadService {

    private final HistorialpropiedadRepository historialpropiedadRepository;

    public List<Historialpropiedad> findAll() {
        return historialpropiedadRepository.findAll();
    }

    public Optional<Historialpropiedad> findById(Long id) {
        return historialpropiedadRepository.findById(id);
    }

    public Historialpropiedad save(Historialpropiedad entity) {
        return historialpropiedadRepository.save(entity);
    }

    public void deleteById(Long id) {
        historialpropiedadRepository.deleteById(id);
    }
}
