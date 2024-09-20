package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Mediopago;
import com.backpushup.backpushupapp.infrastructure.out.MediopagoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MediopagoService {

    private final MediopagoRepository mediopagoRepository;

    public List<Mediopago> findAll() {
        return mediopagoRepository.findAll();
    }

    public Optional<Mediopago> findById(Long id) {
        return mediopagoRepository.findById(id);
    }

    public Mediopago save(Mediopago entity) {
        return mediopagoRepository.save(entity);
    }

    public void deleteById(Long id) {
        mediopagoRepository.deleteById(id);
    }
}
