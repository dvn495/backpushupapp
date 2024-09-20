package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Estacionpago;
import com.backpushup.backpushupapp.infrastructure.out.EstacionpagoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstacionpagoService {

    private final EstacionpagoRepository estacionpagoRepository;

    public List<Estacionpago> findAll() {
        return estacionpagoRepository.findAll();
    }

    public Optional<Estacionpago> findById(Long id) {
        return estacionpagoRepository.findById(id);
    }

    public Estacionpago save(Estacionpago entity) {
        return estacionpagoRepository.save(entity);
    }

    public void deleteById(Long id) {
        estacionpagoRepository.deleteById(id);
    }
}
