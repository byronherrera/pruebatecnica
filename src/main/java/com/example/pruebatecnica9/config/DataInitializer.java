package com.example.pruebatecnica9.config;

import com.example.pruebatecnica9.model.Cliente;
import com.example.pruebatecnica9.model.CuentaBancaria;
import com.example.pruebatecnica9.repository.ClienteRepository;
import com.example.pruebatecnica9.repository.CuentaBancariaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
    private final CuentaBancariaRepository cuentaBancariaRepository;

    public DataInitializer(ClienteRepository clienteRepository,
                           CuentaBancariaRepository cuentaBancariaRepository) {
        this.clienteRepository = clienteRepository;
        this.cuentaBancariaRepository = cuentaBancariaRepository;
    }

    @Override
    public void run(String... args) {
        if (clienteRepository.count() > 0) {
            return;
        }

        Cliente c1 = new Cliente();
        c1.setNombre("Herrera");
        c1.setApellido("Byron ");
        c1.setEmail("bh@gmail.com");
        clienteRepository.save(c1);

        CuentaBancaria c1a = new CuentaBancaria();
        c1a.setNumeroCuenta("123");
        c1a.setTipoCuenta("ahorro");
        c1a.setSaldo(new BigDecimal("1000"));
        c1a.setCliente(c1);

        CuentaBancaria c1b = new CuentaBancaria();
        c1b.setNumeroCuenta("1233");
        c1b.setTipoCuenta("ahorro");
        c1b.setSaldo(new BigDecimal("2000"));
        c1b.setCliente(c1);

        cuentaBancariaRepository.saveAll(List.of(c1a, c1b));

        Cliente c2 = new Cliente();
        c2.setNombre("Perez");
        c2.setApellido("Juan ");
        c2.setEmail("jp@gmail.com");
        clienteRepository.save(c2);

        CuentaBancaria c2a = new CuentaBancaria();
        c2a.setNumeroCuenta("124");
        c2a.setTipoCuenta("ahorro");
        c2a.setSaldo(new BigDecimal("100"));
        c2a.setCliente(c2);

        CuentaBancaria c2b = new CuentaBancaria();
        c2b.setNumeroCuenta("125");
        c2b.setTipoCuenta("ahorro");
        c2b.setSaldo(new BigDecimal("200"));
        c2b.setCliente(c2);

        cuentaBancariaRepository.saveAll(List.of(c2a, c2b));
    }
}

