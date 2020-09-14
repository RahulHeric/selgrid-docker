FROM maven:3.5-jdk-8
WORKDIR /docker
COPY . .
CMD mvn clean install