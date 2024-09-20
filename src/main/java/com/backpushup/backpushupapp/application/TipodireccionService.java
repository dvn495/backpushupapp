package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Tipodireccion;
import com.backpushup.backpushupapp.infrastructure.out.TipodireccionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipodireccionService {

    private final TipodireccionRepository tipodireccionRepository;

    public List<Tipodireccion> findAll() {
        return tipodireccionRepository.findAll();
    }

    public Optional<Tipodireccion> findById(Long id) {
        return tipodireccionRepository.findById(id);
    }

    public Tipodireccion save(Tipodireccion entity) {
        return tipodireccionRepository.save(entity);
    }

    public void deleteById(Long id) {
        tipodireccionRepository.deleteById(id);
    }
}
