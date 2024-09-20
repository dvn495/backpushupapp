package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backpushup.backpushupapp.domain.Coleccionistas;
import com.backpushup.backpushupapp.infrastructure.out.ColeccionistasRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ColeccionistasService {

    private final ColeccionistasRepository coleccionistasRepository;

    public List<Coleccionistas> findAll(){
        return coleccionistasRepository.findAll();
    }

    public Optional<Coleccionistas> findById(Long id){
        return coleccionistasRepository.findById(id);
    }

    public Coleccionistas save(Coleccionistas coleccionistas){
        return coleccionistasRepository.save(coleccionistas);
    }

    public void deleteById(Long id){
        coleccionistasRepository.deleteById(id);
    }
}
