package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.DetalleTransaccion;

public interface Detalle_transaccionRepository extends JpaRepository<DetalleTransaccion, Long> {

}
