package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Empleados;
import com.backpushup.backpushupapp.infrastructure.out.EmpleadosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpleadosService {

    private final EmpleadosRepository empleadosRepository;

    public List<Empleados> findAll() {
        return empleadosRepository.findAll();
    }

    public Optional<Empleados> findById(Long id) {
        return empleadosRepository.findById(id);
    }

    public Empleados save(Empleados entity) {
        return empleadosRepository.save(entity);
    }

    public void deleteById(Long id) {
        empleadosRepository.deleteById(id);
    }
}
