package com.gustavo.tirapedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gustavo.tirapedidos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
