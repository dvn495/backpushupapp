package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.TipoPersona;

public interface Tipo_personaRepository extends JpaRepository<TipoPersona, Long> {

}
