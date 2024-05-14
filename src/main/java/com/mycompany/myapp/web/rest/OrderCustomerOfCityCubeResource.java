package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.OrderCustomerOfCityCube;
import com.mycompany.myapp.repository.OrderCustomerOfCityCubeRepository;
import com.mycompany.myapp.service.impl.OrderCustomerOfCityCubeService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.OrderCustomerOfCityCube}.
 */
@RestController
@RequestMapping("/api")
public class OrderCustomerOfCityCubeResource {

    private final Logger log = LoggerFactory.getLogger(OrderCustomerOfCityCubeResource.class);

    private static final String ENTITY_NAME = "orderCustomerOfCityCube";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OrderCustomerOfCityCubeService orderCustomerOfCityCubeService;

    private final OrderCustomerOfCityCubeRepository orderCustomerOfCityCubeRepository;

    public OrderCustomerOfCityCubeResource(
        OrderCustomerOfCityCubeService orderCustomerOfCityCubeService,
        OrderCustomerOfCityCubeRepository orderCustomerOfCityCubeRepository
    ) {
        this.orderCustomerOfCityCubeService = orderCustomerOfCityCubeService;
        this.orderCustomerOfCityCubeRepository = orderCustomerOfCityCubeRepository;
    }

    /**
     * {@code POST  /order-customer-of-city-cubes} : Create a new orderCustomerOfCityCube.
     *
     * @param orderCustomerOfCityCube the orderCustomerOfCityCube to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new orderCustomerOfCityCube, or with status {@code 400 (Bad Request)} if the orderCustomerOfCityCube has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/order-customer-of-city-cubes")
    public ResponseEntity<OrderCustomerOfCityCube> createOrderCustomerOfCityCube(
        @RequestBody OrderCustomerOfCityCube orderCustomerOfCityCube
    ) throws URISyntaxException {
        log.debug("REST request to save OrderCustomerOfCityCube : {}", orderCustomerOfCityCube);
        if (orderCustomerOfCityCube.getCityName() != null) {
            throw new BadRequestAlertException("A new orderCustomerOfCityCube cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OrderCustomerOfCityCube result = orderCustomerOfCityCubeService.save(orderCustomerOfCityCube);
        return ResponseEntity
            .created(new URI("/api/order-customer-of-city-cubes/" + result.getCityName()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getCityName()))
            .body(result);
    }

    /**
     * {@code PUT  /order-customer-of-city-cubes/:cityName} : Updates an existing orderCustomerOfCityCube.
     *
     * @param cityName the id of the orderCustomerOfCityCube to save.
     * @param orderCustomerOfCityCube the orderCustomerOfCityCube to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated orderCustomerOfCityCube,
     * or with status {@code 400 (Bad Request)} if the orderCustomerOfCityCube is not valid,
     * or with status {@code 500 (Internal Server Error)} if the orderCustomerOfCityCube couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/order-customer-of-city-cubes/{cityName}")
    public ResponseEntity<OrderCustomerOfCityCube> updateOrderCustomerOfCityCube(
        @PathVariable(value = "cityName", required = false) final String cityName,
        @RequestBody OrderCustomerOfCityCube orderCustomerOfCityCube
    ) throws URISyntaxException {
        log.debug("REST request to update OrderCustomerOfCityCube : {}, {}", cityName, orderCustomerOfCityCube);
        if (orderCustomerOfCityCube.getCityName() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(cityName, orderCustomerOfCityCube.getCityName())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!orderCustomerOfCityCubeRepository.existsById(cityName)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        OrderCustomerOfCityCube result = orderCustomerOfCityCubeService.update(orderCustomerOfCityCube);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, orderCustomerOfCityCube.getCityName()))
            .body(result);
    }

    /**
     * {@code PATCH  /order-customer-of-city-cubes/:cityName} : Partial updates given fields of an existing orderCustomerOfCityCube, field will ignore if it is null
     *
     * @param cityName the id of the orderCustomerOfCityCube to save.
     * @param orderCustomerOfCityCube the orderCustomerOfCityCube to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated orderCustomerOfCityCube,
     * or with status {@code 400 (Bad Request)} if the orderCustomerOfCityCube is not valid,
     * or with status {@code 404 (Not Found)} if the orderCustomerOfCityCube is not found,
     * or with status {@code 500 (Internal Server Error)} if the orderCustomerOfCityCube couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/order-customer-of-city-cubes/{cityName}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<OrderCustomerOfCityCube> partialUpdateOrderCustomerOfCityCube(
        @PathVariable(value = "cityName", required = false) final String cityName,
        @RequestBody OrderCustomerOfCityCube orderCustomerOfCityCube
    ) throws URISyntaxException {
        log.debug("REST request to partial update OrderCustomerOfCityCube partially : {}, {}", cityName, orderCustomerOfCityCube);
        if (orderCustomerOfCityCube.getCityName() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(cityName, orderCustomerOfCityCube.getCityName())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!orderCustomerOfCityCubeRepository.existsById(cityName)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<OrderCustomerOfCityCube> result = orderCustomerOfCityCubeService.partialUpdate(orderCustomerOfCityCube);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, orderCustomerOfCityCube.getCityName())
        );
    }

    /**
     * {@code GET  /order-customer-of-city-cubes} : get all the orderCustomerOfCityCubes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of orderCustomerOfCityCubes in body.
     */
    @GetMapping("/order-customer-of-city-cubes")
    public ResponseEntity<List<OrderCustomerOfCityCube>> getAllOrderCustomerOfCityCubes(

    ) {
        log.debug("REST request to get a page of OrderCustomerOfCityCubes");
        List<OrderCustomerOfCityCube> page = orderCustomerOfCityCubeService.findAll();
        return ResponseEntity.ok().body(page);
    }

    /**
     * {@code GET  /order-customer-of-city-cubes/:id} : get the "id" orderCustomerOfCityCube.
     *
     * @param id the id of the orderCustomerOfCityCube to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the orderCustomerOfCityCube, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/order-customer-of-city-cubes/{id}")
    public ResponseEntity<OrderCustomerOfCityCube> getOrderCustomerOfCityCube(@PathVariable String id) {
        log.debug("REST request to get OrderCustomerOfCityCube : {}", id);
        Optional<OrderCustomerOfCityCube> orderCustomerOfCityCube = orderCustomerOfCityCubeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(orderCustomerOfCityCube);
    }

    /**
     * {@code DELETE  /order-customer-of-city-cubes/:id} : delete the "id" orderCustomerOfCityCube.
     *
     * @param id the id of the orderCustomerOfCityCube to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/order-customer-of-city-cubes/{id}")
    public ResponseEntity<Void> deleteOrderCustomerOfCityCube(@PathVariable String id) {
        log.debug("REST request to delete OrderCustomerOfCityCube : {}", id);
        orderCustomerOfCityCubeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id)).build();
    }
}
