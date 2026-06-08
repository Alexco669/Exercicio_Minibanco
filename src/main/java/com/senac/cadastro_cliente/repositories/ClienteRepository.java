package com.senac.cadastro_cliente.repositories;

import com.senac.cadastro_cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
