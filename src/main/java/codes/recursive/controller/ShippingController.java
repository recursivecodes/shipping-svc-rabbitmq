package codes.recursive.controller;

import codes.recursive.domain.Shipment;
import codes.recursive.service.ShippingService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }

    @Get("/shipments/recent/{count}")
    public HttpResponse<List<Shipment>> getRecentShipments(Long count) {
        return HttpResponse.ok(
                shippingService.listShipments().stream().limit(count).collect(Collectors.toList())
        );
    }
}