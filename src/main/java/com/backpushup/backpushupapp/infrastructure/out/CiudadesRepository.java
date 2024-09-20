package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.Ciudades;

public interface CiudadesRepository extends JpaRepository<Ciudades, Long> {

}
