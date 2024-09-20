package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Movcaja;
import com.backpushup.backpushupapp.infrastructure.out.MovcajaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovcajaService {

    private final MovcajaRepository movcajaRepository;

    public List<Movcaja> findAll() {
        return movcajaRepository.findAll();
    }

    public Optional<Movcaja> findById(Long id) {
        return movcajaRepository.findById(id);
    }

    public Movcaja save(Movcaja entity) {
        return movcajaRepository.save(entity);
    }

    public void deleteById(Long id) {
        movcajaRepository.deleteById(id);
    }
}
