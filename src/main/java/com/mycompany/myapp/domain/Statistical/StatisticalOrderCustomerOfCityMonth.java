package com.mycompany.myapp.domain.Statistical;

import com.mycompany.myapp.domain.OrderCustomerOfCityMonthCube;

import java.util.List;

public class StatisticalOrderCustomerOfCityMonth extends StatisticalOrder {
    private List<OrderCustomerOfCityMonthCube> orderCustomerOfCityMonthCubeList;

    public List<OrderCustomerOfCityMonthCube> getOrderCustomerOfCityMonthCubeList() {
        return orderCustomerOfCityMonthCubeList;
    }

    public void setOrderCustomerOfCityMonthCubeList(List<OrderCustomerOfCityMonthCube> orderCustomerOfCityMonthCubeList) {
        this.orderCustomerOfCityMonthCubeList = orderCustomerOfCityMonthCubeList;
    }
}
