package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backpushup.backpushupapp.domain.Epocaantiguedad;
import com.backpushup.backpushupapp.infrastructure.out.EpocaantiguedadRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EpocaantiguedadService {

    private final EpocaantiguedadRepository epocaAntiguedadRepository;

    public List<Epocaantiguedad> findAll(){
        return epocaAntiguedadRepository.findAll();
    }

    public Optional<Epocaantiguedad> findById(Long id){
        return epocaAntiguedadRepository.findById(id);
    }

    public Epocaantiguedad save(Epocaantiguedad epocaAntiguedad){
        return epocaAntiguedadRepository.save(epocaAntiguedad);
    }

    public void deleteById(Long id){
        epocaAntiguedadRepository.deleteById(id);
    }
}
