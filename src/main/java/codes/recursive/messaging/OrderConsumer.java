package codes.recursive.messaging;

import codes.recursive.domain.Order;
import codes.recursive.domain.Shipment;
import codes.recursive.service.ShippingService;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RabbitListener
public class OrderConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(OrderConsumer.class);
    private final ShippingService shippingService;

    public OrderConsumer(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @Queue("order-queue")
    public Shipment receive(
            Order order) throws InterruptedException {
        LOG.info("Order received!");
        LOG.info("Creating shipment...");
        /* shipping is slow! */
        Thread.sleep(15*1000);
        return shippingService.newShipment(order);
    }
}