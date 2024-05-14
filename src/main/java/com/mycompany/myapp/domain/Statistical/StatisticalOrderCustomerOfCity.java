package com.mycompany.myapp.domain.Statistical;

import com.mycompany.myapp.domain.OrderCustomerOfCityCube;

import java.util.List;


public class StatisticalOrderCustomerOfCity extends StatisticalOrder{

    private List<OrderCustomerOfCityCube> orderCustomerOfCityCubeList;

    public void setOrderCustomerOfCityCubeList(List<OrderCustomerOfCityCube> orderCustomerOfCityCubeList) {
        this.orderCustomerOfCityCubeList = orderCustomerOfCityCubeList;
    }

    public List<OrderCustomerOfCityCube> getOrderCustomerOfCityCubeList() {
        return orderCustomerOfCityCubeList;
    }


}
