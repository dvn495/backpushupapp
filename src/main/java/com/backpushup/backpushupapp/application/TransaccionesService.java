package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Transacciones;
import com.backpushup.backpushupapp.infrastructure.out.TransaccionesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransaccionesService {

    private final TransaccionesRepository transaccionesRepository;

    public List<Transacciones> findAll() {
        return transaccionesRepository.findAll();
    }

    public Optional<Transacciones> findById(Long id) {
        return transaccionesRepository.findById(id);
    }

    public Transacciones save(Transacciones entity) {
        return transaccionesRepository.save(entity);
    }

    public void deleteById(Long id) {
        transaccionesRepository.deleteById(id);
    }
}
