# Usar una imagen base de Java 17 (eclipse-temurin es la oficial)
FROM eclipse-temurin:17-jdk

# Directorio de trabajo
WORKDIR /app

COPY target/pruebatecnica9-0.0.1-SNAPSHOT.jar app.jar

# Copiar la base de datos (opcional si quieres persistencia interna inicial)
COPY clientes.db clientes.db 

# Exponer el puerto
EXPOSE 8081

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
