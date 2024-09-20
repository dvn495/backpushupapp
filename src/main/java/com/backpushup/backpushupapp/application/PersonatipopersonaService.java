package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Personatipopersona;
import com.backpushup.backpushupapp.infrastructure.out.PersonatipopersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonatipopersonaService {

    private final PersonatipopersonaRepository personatipopersonaRepository;

    public List<Personatipopersona> findAll() {
        return personatipopersonaRepository.findAll();
    }

    public Optional<Personatipopersona> findById(Long id) {
        return personatipopersonaRepository.findById(id);
    }

    public Personatipopersona save(Personatipopersona entity) {
        return personatipopersonaRepository.save(entity);
    }

    public void deleteById(Long id) {
        personatipopersonaRepository.deleteById(id);
    }
}
