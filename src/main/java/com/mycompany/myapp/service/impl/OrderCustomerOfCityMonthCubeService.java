package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.OrderCustomerOfCityCube;
import com.mycompany.myapp.domain.OrderCustomerOfCityMonthCube;
import com.mycompany.myapp.repository.OrderCustomerOfCityMonthCubeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderCustomerOfCityMonthCubeService {
    private final OrderCustomerOfCityMonthCubeRepository orderCustomerOfCityMonthCubeRepository;
    private final Logger log = LoggerFactory.getLogger(OrderCustomerOfCityCubeService.class);

    public OrderCustomerOfCityMonthCubeService(OrderCustomerOfCityMonthCubeRepository orderCustomerOfCityMonthCubeRepository) {
        this.orderCustomerOfCityMonthCubeRepository = orderCustomerOfCityMonthCubeRepository;
    }

    @Transactional(readOnly = true)
    public List<OrderCustomerOfCityMonthCube> findAll(Integer month, Integer year) {
        log.debug("Request to get all OrderCustomerOfCityCubes");
        return orderCustomerOfCityMonthCubeRepository.findAllOrderCustomerOfCityMonthCuber(month, year);
    }
}
