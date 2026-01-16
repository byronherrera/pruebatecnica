# Usar una imagen base de Java 17
FROM openjdk:17-jdk-slim

# Directorio de trabajo
WORKDIR /app

# Copiar el archivo jar generado (asegúrate de hacer mvn package antes)
COPY target/pruebatecnica9-0.0.1-SNAPSHOT.jar app.jar

# Copiar la base de datos (opcional si quieres persistencia interna inicial)
# COPY clientes.db clientes.db 
# (Mejor dejar que se cree o usar volumen, pero para este ejemplo simple dejamos que la app la cree)

# Exponer el puerto
EXPOSE 8081

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
