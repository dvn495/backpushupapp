package com.backpushup.backpushupapp.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backpushup.backpushupapp.domain.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
