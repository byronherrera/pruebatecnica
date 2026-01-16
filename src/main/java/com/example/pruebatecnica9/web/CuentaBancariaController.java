package com.example.pruebatecnica9.web;

import com.example.pruebatecnica9.model.Cliente;
import com.example.pruebatecnica9.model.CuentaBancaria;
import com.example.pruebatecnica9.service.ClienteService;
import com.example.pruebatecnica9.service.CuentaBancariaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaBancariaController {

    private final CuentaBancariaService cuentaBancariaService;
    private final ClienteService clienteService;

    public CuentaBancariaController(CuentaBancariaService cuentaBancariaService,
                                    ClienteService clienteService) {
        this.cuentaBancariaService = cuentaBancariaService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<CuentaBancaria> listar() {
        return cuentaBancariaService.findAll();
    }

    @GetMapping("/{id}")
    public CuentaBancaria obtener(@PathVariable Long id) {
        return cuentaBancariaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CuentaBancaria crear(@RequestParam Long clienteId, @RequestBody CuentaBancaria cuenta) {
        Cliente cliente = clienteService.findById(clienteId);
        cuenta.setCliente(cliente);
        return cuentaBancariaService.save(cuenta);
    }

    @PutMapping("/{id}")
    public CuentaBancaria actualizar(@PathVariable Long id, @RequestBody CuentaBancaria cuenta) {
        CuentaBancaria existente = cuentaBancariaService.findById(id);
        existente.setNumeroCuenta(cuenta.getNumeroCuenta());
        existente.setTipoCuenta(cuenta.getTipoCuenta());
        existente.setSaldo(cuenta.getSaldo());
        return cuentaBancariaService.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        cuentaBancariaService.delete(id);
    }

    @GetMapping("/por-cliente/{clienteId}")
    public List<CuentaBancaria> porCliente(@PathVariable Long clienteId) {
        return cuentaBancariaService.findByClienteId(clienteId);
    }
}

