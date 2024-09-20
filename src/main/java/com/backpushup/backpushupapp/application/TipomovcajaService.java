package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Tipomovcaja;
import com.backpushup.backpushupapp.infrastructure.out.TipomovcajaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipomovcajaService {

    private final TipomovcajaRepository tipomovcajaRepository;

    public List<Tipomovcaja> findAll() {
        return tipomovcajaRepository.findAll();
    }

    public Optional<Tipomovcaja> findById(Long id) {
        return tipomovcajaRepository.findById(id);
    }

    public Tipomovcaja save(Tipomovcaja entity) {
        return tipomovcajaRepository.save(entity);
    }

    public void deleteById(Long id) {
        tipomovcajaRepository.deleteById(id);
    }
}
