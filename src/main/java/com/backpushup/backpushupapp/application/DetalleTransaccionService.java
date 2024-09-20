package com.backpushup.backpushupapp.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backpushup.backpushupapp.domain.DetalleTransaccion;
import com.backpushup.backpushupapp.infrastructure.out.Detalle_transaccionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DetalleTransaccionService {

    private final Detalle_transaccionRepository detalletransaccionRepository;

    public List<DetalleTransaccion> findAll() {
        return detalletransaccionRepository.findAll();
    }

    public Optional<DetalleTransaccion> findById(Long id) {
        return detalletransaccionRepository.findById(id);
    }

    public DetalleTransaccion save(DetalleTransaccion entity) {
        return detalletransaccionRepository.save(entity);
    }

    public void deleteById(Long id) {
        detalletransaccionRepository.deleteById(id);
    }
}
