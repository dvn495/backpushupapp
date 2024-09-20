package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Tipotransaccion;
import com.backpushup.backpushupapp.infrastructure.out.TipotransaccionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipotransaccionService {

    private final TipotransaccionRepository tipotransaccionRepository;

    public List<Tipotransaccion> findAll() {
        return tipotransaccionRepository.findAll();
    }

    public Optional<Tipotransaccion> findById(Long id) {
        return tipotransaccionRepository.findById(id);
    }

    public Tipotransaccion save(Tipotransaccion entity) {
        return tipotransaccionRepository.save(entity);
    }

    public void deleteById(Long id) {
        tipotransaccionRepository.deleteById(id);
    }
}
