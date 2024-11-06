# Usar a imagem do Maven para construir o projeto
FROM maven:3.9.9-ibm-semeru-23-jammy AS build
# Defina o diretório de trabalho dentro do container
WORKDIR /app
# Copie o pom.xml e baixe as dependências (para otimizar o cache)
COPY pom.xml .

RUN mvn dependency:go-offline
# Copie o código-fonte para dentro do container
COPY src ./src
# Compile o projeto e crie o arquivo JAR
RUN mvn clean package -DskipTests

RUN ls -l /app/target/

# Use a imagem do OpenJDK 23 para rodar a aplicação
FROM openjdk:23-jdk
# Defina o diretório de trabalho dentro do container
WORKDIR /app
# Copie o arquivo JAR gerado pela primeira etapa de build
COPY --from=build /app/target/viagem-app-0.0.1-SNAPSHOT.jar /app/viagem-app.jar
# Exponha a porta da aplicação (8080 por padrão)
EXPOSE 8080
# Comando para rodar a aplicação
CMD ["java", "-jar", "viagem-app.jar"]