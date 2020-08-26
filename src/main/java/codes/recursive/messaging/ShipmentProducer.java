package codes.recursive.messaging;

import codes.recursive.domain.Shipment;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient("micronaut.demo")
public interface ShipmentProducer {
    @Binding("shipment")
    void send(Shipment shipment);
}