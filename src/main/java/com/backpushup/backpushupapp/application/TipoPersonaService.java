package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.TipoPersona;
import com.backpushup.backpushupapp.infrastructure.out.Tipo_personaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoPersonaService {

    private final Tipo_personaRepository tipopersonaRepository;

    public List<TipoPersona> findAll() {
        return tipopersonaRepository.findAll();
    }

    public Optional<TipoPersona> findById(Long id) {
        return tipopersonaRepository.findById(id);
    }

    public TipoPersona save(TipoPersona entity) {
        return tipopersonaRepository.save(entity);
    }

    public void deleteById(Long id) {
        tipopersonaRepository.deleteById(id);
    }
}
