FROM maven:3.5-jdk-8
WORKDIR /docker
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
CMD mvn clean install