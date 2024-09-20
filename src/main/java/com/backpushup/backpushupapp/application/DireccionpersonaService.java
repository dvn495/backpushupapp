package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Direccionpersona;
import com.backpushup.backpushupapp.infrastructure.out.DireccionpersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DireccionpersonaService {

    private final DireccionpersonaRepository direccionpersonaRepository;

    public List<Direccionpersona> findAll() {
        return direccionpersonaRepository.findAll();
    }

    public Optional<Direccionpersona> findById(Long id) {
        return direccionpersonaRepository.findById(id);
    }

    public Direccionpersona save(Direccionpersona entity) {
        return direccionpersonaRepository.save(entity);
    }

    public void deleteById(Long id) {
        direccionpersonaRepository.deleteById(id);
    }
}
