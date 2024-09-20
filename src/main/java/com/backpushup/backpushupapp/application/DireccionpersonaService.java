package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.DireccionPersona;
import com.backpushup.backpushupapp.infrastructure.out.DireccionpersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DireccionPersonaService {

    private final DireccionpersonaRepository direccionpersonaRepository;

    public List<DireccionPersona> findAll() {
        return direccionpersonaRepository.findAll();
    }

    public Optional<DireccionPersona> findById(Long id) {
        return direccionpersonaRepository.findById(id);
    }

    public DireccionPersona save(DireccionPersona entity) {
        return direccionpersonaRepository.save(entity);
    }

    public void deleteById(Long id) {
        direccionpersonaRepository.deleteById(id);
    }
}
