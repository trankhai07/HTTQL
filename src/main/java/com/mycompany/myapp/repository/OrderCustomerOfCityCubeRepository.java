package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.OrderCustomerOfCityCube;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the OrderCustomerOfCityCube entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderCustomerOfCityCubeRepository extends JpaRepository<OrderCustomerOfCityCube, String> {
    @Query(value = "select CityName as city_name, OfficeAddress as office_address, OrderedQuantity as ordered_quantity, OrderedCost as ordered_cost,\n" +
        "       Profit as profit from OrderCustomerOfCityCube ",nativeQuery = true)
    List<OrderCustomerOfCityCube> findAllOrderCustomerOfCityCube();
}
