# Prueba técnica – Clientes y Cuentas bancarias (Spring Boot + SQLite)

Aplicación REST con:
- CRUD de clientes
- CRUD de cuentas bancarias
- Relación 1‑N (un cliente tiene muchas cuentas)
- Endpoint de reporte por cliente

1. Clientes
Base URL: http://localhost:8081/api/clientes

Método  |  Endpoint | Descripción. 
- GET /api/clientes Lista todos los clientes. 
- GET /api/clientes/{id} Obtiene un cliente por ID. 
- POST /api/clientes Crea un nuevo cliente.
- PUT /api/clientes/{id} Actualiza datos de un cliente.
- DELETE /api/clientes/{id} Elimina un cliente N/A .
- GET /api/clientes/{id}/reporte Reporte : Cliente + Cuentas + Saldo Total N/A.

2. Cuentas Bancarias
Base URL: http://localhost:8081/api/cuentas.

Método  |  Endpoint | Descripción 
- GET /api/cuentas Lista todas las cuentas.
- GET /api/cuentas/{id} Obtiene una cuenta por ID. 
- POST /api/cuentas?clienteId={id} Crea una cuenta para un cliente. 
- PUT /api/cuentas/{id} Actualiza una cuenta.
- DELETE /api/cuentas/{id} Elimina una cuenta. 
- GET /api/cuentas/por-cliente/{id} Lista solo las cuentas de un cliente.

3. Instalación

1. git clone https://github.com/byronherrera/pruebatecnica.git
2. cd pruebatecnica
3. mvn -DskipTests=true package
4. docker-compose up --build

- La aplicación queda en http://localhost:8081 

