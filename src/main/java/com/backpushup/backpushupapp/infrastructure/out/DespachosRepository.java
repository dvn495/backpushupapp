package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.Despachos;

public interface DespachosRepository extends JpaRepository<Despachos, Long> {

}
