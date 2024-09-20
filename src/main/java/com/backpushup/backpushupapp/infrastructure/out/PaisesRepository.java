package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.Paises;

public interface PaisesRepository extends JpaRepository<Paises, Long> {

}
