package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backpushup.backpushupapp.domain.Categorias;
import com.backpushup.backpushupapp.infrastructure.out.CategoriasRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriasService {

    private final CategoriasRepository categoriasRepository;

    public List<Categorias> findAll(){
        return categoriasRepository.findAll();
    }

    public Optional<Categorias> findById(Long id){
        return categoriasRepository.findById(id);
    }

    public Categorias save(Categorias categorias){
        return categoriasRepository.save(categorias);
    }

    public void deleteById(Long id){
        categoriasRepository.deleteById(id);
    }
}
