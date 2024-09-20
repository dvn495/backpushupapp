package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backpushup.backpushupapp.domain.Empresa;
import com.backpushup.backpushupapp.infrastructure.out.EmpresaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }

    public Optional<Empresa> findById(Long id){
        return empresaRepository.findById(id);
    }

    public Empresa save(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public void deleteById(Long id){
        empresaRepository.deleteById(id);
    }
}
