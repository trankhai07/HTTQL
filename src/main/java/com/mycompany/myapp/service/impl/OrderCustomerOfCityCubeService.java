package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.OrderCustomerOfCityCube;
import com.mycompany.myapp.repository.OrderCustomerOfCityCubeRepository;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link OrderCustomerOfCityCube}.
 */
@Service
@Transactional
public class OrderCustomerOfCityCubeService {

    private final Logger log = LoggerFactory.getLogger(OrderCustomerOfCityCubeService.class);

    private final OrderCustomerOfCityCubeRepository orderCustomerOfCityCubeRepository;

    public OrderCustomerOfCityCubeService(OrderCustomerOfCityCubeRepository orderCustomerOfCityCubeRepository) {
        this.orderCustomerOfCityCubeRepository = orderCustomerOfCityCubeRepository;
    }

    /**
     * Save a orderCustomerOfCityCube.
     *
     * @param orderCustomerOfCityCube the entity to save.
     * @return the persisted entity.
     */
    public OrderCustomerOfCityCube save(OrderCustomerOfCityCube orderCustomerOfCityCube) {
        log.debug("Request to save OrderCustomerOfCityCube : {}", orderCustomerOfCityCube);
        return orderCustomerOfCityCubeRepository.save(orderCustomerOfCityCube);
    }

    /**
     * Update a orderCustomerOfCityCube.
     *
     * @param orderCustomerOfCityCube the entity to save.
     * @return the persisted entity.
     */
    public OrderCustomerOfCityCube update(OrderCustomerOfCityCube orderCustomerOfCityCube) {
        log.debug("Request to update OrderCustomerOfCityCube : {}", orderCustomerOfCityCube);
        orderCustomerOfCityCube.setIsPersisted();
        return orderCustomerOfCityCubeRepository.save(orderCustomerOfCityCube);
    }

    /**
     * Partially update a orderCustomerOfCityCube.
     *
     * @param orderCustomerOfCityCube the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<OrderCustomerOfCityCube> partialUpdate(OrderCustomerOfCityCube orderCustomerOfCityCube) {
        log.debug("Request to partially update OrderCustomerOfCityCube : {}", orderCustomerOfCityCube);

        return orderCustomerOfCityCubeRepository
            .findById(orderCustomerOfCityCube.getCityName())
            .map(existingOrderCustomerOfCityCube -> {
                if (orderCustomerOfCityCube.getOfficeAddress() != null) {
                    existingOrderCustomerOfCityCube.setOfficeAddress(orderCustomerOfCityCube.getOfficeAddress());
                }
                if (orderCustomerOfCityCube.getOrderedQuantity() != null) {
                    existingOrderCustomerOfCityCube.setOrderedQuantity(orderCustomerOfCityCube.getOrderedQuantity());
                }
                if (orderCustomerOfCityCube.getOrderedCost() != null) {
                    existingOrderCustomerOfCityCube.setOrderedCost(orderCustomerOfCityCube.getOrderedCost());
                }
                if (orderCustomerOfCityCube.getProfit() != null) {
                    existingOrderCustomerOfCityCube.setProfit(orderCustomerOfCityCube.getProfit());
                }

                return existingOrderCustomerOfCityCube;
            })
            .map(orderCustomerOfCityCubeRepository::save);
    }

    /**
     * Get all the orderCustomerOfCityCubes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<OrderCustomerOfCityCube> findAll() {
        log.debug("Request to get all OrderCustomerOfCityCubes");
        return orderCustomerOfCityCubeRepository.findAllOrderCustomerOfCityCube();
    }

    /**
     * Get one orderCustomerOfCityCube by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<OrderCustomerOfCityCube> findOne(String id) {
        log.debug("Request to get OrderCustomerOfCityCube : {}", id);
        return orderCustomerOfCityCubeRepository.findById(id);
    }

    /**
     * Delete the orderCustomerOfCityCube by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete OrderCustomerOfCityCube : {}", id);
        orderCustomerOfCityCubeRepository.deleteById(id);
    }
}
