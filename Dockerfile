FROM openjdk:14-alpine
COPY build/libs/shipping-svc-rabbitmq-*-all.jar shipping-svc-rabbitmq.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "shipping-svc-rabbitmq.jar"]