package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.OrderCustomerOfCityCube;
import com.mycompany.myapp.domain.OrderCustomerOfCityMonthCube;
import com.mycompany.myapp.service.impl.OrderCustomerOfCityMonthCubeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderCustomerOfCityMonthCubeResource {
    private final Logger log = LoggerFactory.getLogger(OrderCustomerOfCityCubeResource.class);

    private static final String ENTITY_NAME = "orderCustomerOfCityMonthCube";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OrderCustomerOfCityMonthCubeService orderCustomerOfCityCubeService;


    public OrderCustomerOfCityMonthCubeResource(OrderCustomerOfCityMonthCubeService orderCustomerOfCityCubeService) {
        this.orderCustomerOfCityCubeService = orderCustomerOfCityCubeService;
    }

    @GetMapping("/order-customer-of-city-month-cubes")
    public ResponseEntity<List<OrderCustomerOfCityMonthCube>> getAllOrderCustomerOfCityMonthCubes(
        @RequestParam(value = "month", defaultValue = "10") Integer month,
        @RequestParam(value = "year", defaultValue = "2023") Integer year
    ) {
        log.debug("REST request to get a page of OrderCustomerOfCityMonthCubes");
        List<OrderCustomerOfCityMonthCube> page = orderCustomerOfCityCubeService.findAll(month, year);
        return ResponseEntity.ok().body(page);
    }
}
