package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Sucursal;
import com.backpushup.backpushupapp.infrastructure.out.SucursalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> findById(Long id) {
        return sucursalRepository.findById(id);
    }

    public Sucursal save(Sucursal entity) {
        return sucursalRepository.save(entity);
    }

    public void deleteById(Long id) {
        sucursalRepository.deleteById(id);
    }
}
