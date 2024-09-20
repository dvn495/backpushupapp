package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {

}
