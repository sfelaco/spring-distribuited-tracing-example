# Usa un'immagine di base di OpenJDK 21
FROM eclipse-temurin:21-jre

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file JAR dell'applicazione nella directory di lavoro
COPY target/spring-app-0.0.1-SNAPSHOT.jar app.jar

# Esponi la porta su cui l'applicazione sarà in ascolto
EXPOSE 9090

# Comando per eseguire l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]