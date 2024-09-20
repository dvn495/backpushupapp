package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

}
