package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Clasecontacto;
import com.backpushup.backpushupapp.infrastructure.out.ClasecontactoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClasecontactoService {

    private final ClasecontactoRepository clasecontactoRepository;

    public List<Clasecontacto> findAll() {
        return clasecontactoRepository.findAll();
    }

    public Optional<Clasecontacto> findById(Long id) {
        return clasecontactoRepository.findById(id);
    }

    public Clasecontacto save(Clasecontacto entity) {
        return clasecontactoRepository.save(entity);
    }

    public void deleteById(Long id) {
        clasecontactoRepository.deleteById(id);
    }
}
