package com.example.pruebatecnica9.service;

import com.example.pruebatecnica9.dto.ClienteReporteDTO;
import com.example.pruebatecnica9.dto.CuentaResumenDTO;
import com.example.pruebatecnica9.model.Cliente;
import com.example.pruebatecnica9.model.CuentaBancaria;
import com.example.pruebatecnica9.repository.ClienteRepository;
import com.example.pruebatecnica9.repository.CuentaBancariaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final CuentaBancariaRepository cuentaBancariaRepository;

    public ClienteService(ClienteRepository clienteRepository,
                          CuentaBancariaRepository cuentaBancariaRepository) {
        this.clienteRepository = clienteRepository;
        this.cuentaBancariaRepository = cuentaBancariaRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }
        clienteRepository.deleteById(id);
    }

    public ClienteReporteDTO obtenerReportePorCliente(Long clienteId) {
        Cliente cliente = findById(clienteId);
        List<CuentaBancaria> cuentas = cuentaBancariaRepository.findByClienteId(clienteId);

        List<CuentaResumenDTO> cuentasResumen = cuentas.stream()
                .map(c -> {
                    CuentaResumenDTO dto = new CuentaResumenDTO();
                    dto.setId(c.getId());
                    dto.setNumeroCuenta(c.getNumeroCuenta());
                    dto.setTipoCuenta(c.getTipoCuenta());
                    dto.setSaldo(c.getSaldo());
                    return dto;
                })
                .collect(Collectors.toList());

        BigDecimal total = cuentas.stream()
                .map(CuentaBancaria::getSaldo)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        ClienteReporteDTO reporte = new ClienteReporteDTO();
        reporte.setClienteId(cliente.getId());
        reporte.setNombre(cliente.getNombre());
        reporte.setApellido(cliente.getApellido());
        reporte.setEmail(cliente.getEmail());
        reporte.setSaldoTotal(total);
        reporte.setCuentas(cuentasResumen);

        return reporte;
    }
}

