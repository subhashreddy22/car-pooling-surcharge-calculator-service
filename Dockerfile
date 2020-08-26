FROM openjdk:8
ADD target/surcharge-calculator-service.jar surcharge-calculator-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "surcharge-calculator-service.jar"]