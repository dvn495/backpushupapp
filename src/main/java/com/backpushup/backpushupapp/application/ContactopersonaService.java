package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Contactopersona;
import com.backpushup.backpushupapp.infrastructure.out.ContactopersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactopersonaService {

    private final ContactopersonaRepository contactopersonaRepository;

    public List<Contactopersona> findAll() {
        return contactopersonaRepository.findAll();
    }

    public Optional<Contactopersona> findById(Long id) {
        return contactopersonaRepository.findById(id);
    }

    public Contactopersona save(Contactopersona entity) {
        return contactopersonaRepository.save(entity);
    }

    public void deleteById(Long id) {
        contactopersonaRepository.deleteById(id);
    }
}
