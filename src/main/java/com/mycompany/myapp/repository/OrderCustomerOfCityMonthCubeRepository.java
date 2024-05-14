package com.mycompany.myapp.repository;


import com.mycompany.myapp.domain.OrderCustomerOfCityMonthCube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderCustomerOfCityMonthCubeRepository extends JpaRepository<OrderCustomerOfCityMonthCube, String> {
    @Query(value = "select Month as month, Year as year, CityKey as city_key,CityName as city_name, State as state, OrderedQuantity as ordered_quantity,OrderedCost as ordered_cost, Profit as profit from OrderCustomerOfCityMonthCube where month = ?1 and year = ?2",nativeQuery = true)
    List<OrderCustomerOfCityMonthCube> findAllOrderCustomerOfCityMonthCuber(Integer mt, Integer yr);
}
