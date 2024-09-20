package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.Transaccionmediopago;
import com.backpushup.backpushupapp.infrastructure.out.TransaccionmediopagoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransaccionmediopagoService {

    private final TransaccionmediopagoRepository transaccionmediopagoRepository;

    public List<Transaccionmediopago> findAll() {
        return transaccionmediopagoRepository.findAll();
    }

    public Optional<Transaccionmediopago> findById(Long id) {
        return transaccionmediopagoRepository.findById(id);
    }

    public Transaccionmediopago save(Transaccionmediopago entity) {
        return transaccionmediopagoRepository.save(entity);
    }

    public void deleteById(Long id) {
        transaccionmediopagoRepository.deleteById(id);
    }
}
