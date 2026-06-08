package com.senac.cadastro_cliente.repositories;

import com.senac.cadastro_cliente.model.contaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContaRepository extends JpaRepository<contaBancaria, Integer> {
}
