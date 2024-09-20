package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.Transacciones;

public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {

}
