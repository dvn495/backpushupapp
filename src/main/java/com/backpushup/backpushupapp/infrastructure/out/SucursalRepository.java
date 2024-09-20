package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

}
