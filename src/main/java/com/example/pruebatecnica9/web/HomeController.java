package com.example.pruebatecnica9.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> info = new HashMap<>();
        info.put("message", "Bienvenido a la API de Prueba Tecnica");
        info.put("clientes_url", "/api/clientes");
        info.put("cuentas_url", "/api/cuentas");
        info.put("reporte_ejemplo", "/api/clientes/1/reporte");
        return info;
    }
}
