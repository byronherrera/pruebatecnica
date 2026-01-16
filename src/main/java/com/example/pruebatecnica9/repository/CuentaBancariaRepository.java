package com.example.pruebatecnica9.repository;

import com.example.pruebatecnica9.model.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long> {

    List<CuentaBancaria> findByClienteId(Long clienteId);
}

