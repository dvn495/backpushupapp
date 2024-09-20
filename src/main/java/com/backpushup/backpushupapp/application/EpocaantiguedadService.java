package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Epocaantiguedad;
import com.backpushup.backpushupapp.infrastructure.out.EpocaantiguedadRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EpocaantiguedadService {

    private final EpocaantiguedadRepository epocaantiguedadRepository;

    public List<Epocaantiguedad> findAll() {
        return epocaantiguedadRepository.findAll();
    }

    public Optional<Epocaantiguedad> findById(Long id) {
        return epocaantiguedadRepository.findById(id);
    }

    public Epocaantiguedad save(Epocaantiguedad entity) {
        return epocaantiguedadRepository.save(entity);
    }

    public void deleteById(Long id) {
        epocaantiguedadRepository.deleteById(id);
    }
}
