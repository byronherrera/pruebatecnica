package com.example.pruebatecnica9.dto;

import java.math.BigDecimal;
import java.util.List;

public class ClienteReporteDTO {

    private Long clienteId;
    private String nombre;
    private String apellido;
    private String email;
    private BigDecimal saldoTotal;
    private List<CuentaResumenDTO> cuentas;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(BigDecimal saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public List<CuentaResumenDTO> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaResumenDTO> cuentas) {
        this.cuentas = cuentas;
    }
}

