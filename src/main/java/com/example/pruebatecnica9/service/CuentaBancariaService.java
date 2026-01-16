package com.example.pruebatecnica9.service;

import com.example.pruebatecnica9.model.CuentaBancaria;
import com.example.pruebatecnica9.repository.CuentaBancariaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class CuentaBancariaService {

    private final CuentaBancariaRepository cuentaBancariaRepository;

    public CuentaBancariaService(CuentaBancariaRepository cuentaBancariaRepository) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
    }

    public List<CuentaBancaria> findAll() {
        return cuentaBancariaRepository.findAll();
    }

    public CuentaBancaria findById(Long id) {
        return cuentaBancariaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta bancaria no encontrada"));
    }

    public CuentaBancaria save(CuentaBancaria cuentaBancaria) {
        return cuentaBancariaRepository.save(cuentaBancaria);
    }

    public void delete(Long id) {
        if (!cuentaBancariaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta bancaria no encontrada");
        }
        cuentaBancariaRepository.deleteById(id);
    }

    public List<CuentaBancaria> findByClienteId(Long clienteId) {
        return cuentaBancariaRepository.findByClienteId(clienteId);
    }
}

