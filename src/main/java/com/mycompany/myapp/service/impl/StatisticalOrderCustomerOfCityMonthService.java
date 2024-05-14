package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.OrderCustomerOfCityMonthCube;
import com.mycompany.myapp.domain.Statistical.StatisticalOrderCustomerOfCity;
import com.mycompany.myapp.domain.Statistical.StatisticalOrderCustomerOfCityMonth;
import com.mycompany.myapp.repository.OrderCustomerOfCityMonthCubeRepository;
import com.mycompany.myapp.service.AbstractStatistical;
import io.undertow.util.BadRequestException;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

@Service
public class StatisticalOrderCustomerOfCityMonthService extends AbstractStatistical {
    private final TemplateEngine templateEngine;
    private final OrderCustomerOfCityMonthCubeService orderCustomerOfCityMonthCubeService;

    public StatisticalOrderCustomerOfCityMonthService(TemplateEngine templateEngine, OrderCustomerOfCityMonthCubeService orderCustomerOfCityMonthCubeService) {
        this.templateEngine = templateEngine;
        this.orderCustomerOfCityMonthCubeService = orderCustomerOfCityMonthCubeService;
    }

    public StatisticalOrderCustomerOfCityMonth createStatisticalOrderCustomerOfCityMonth(Integer month, Integer year) {
        StatisticalOrderCustomerOfCityMonth statisticalOrderCustomerOfCityMonth = new StatisticalOrderCustomerOfCityMonth();
        statisticalOrderCustomerOfCityMonth.setNameCompany("CÔNG TY FOUR-MEMBERS VIỆT NAM (NHÓM 11)");
        statisticalOrderCustomerOfCityMonth.setNameStatistical("BÁO CÁO DOANH THU CÁC THÀNH PHỐ");
        statisticalOrderCustomerOfCityMonth.setMonth(month.toString());
        statisticalOrderCustomerOfCityMonth.setYear(year.toString());
        List<OrderCustomerOfCityMonthCube> orderCustomerOfCityMonthCubeList = orderCustomerOfCityMonthCubeService.findAll(month, year);
        long sumOrderedQuantity = 0, sumOrderCost = 0, sumProfit = 0;
        for (OrderCustomerOfCityMonthCube orderCustomerOfCityMonthCube : orderCustomerOfCityMonthCubeList) {
            sumOrderedQuantity += orderCustomerOfCityMonthCube.getOrderedQuantity();
            sumOrderCost += orderCustomerOfCityMonthCube.getOrderedCost();
            sumProfit += orderCustomerOfCityMonthCube.getProfit();
        }
        statisticalOrderCustomerOfCityMonth.setSumOrderedQuantity(sumOrderedQuantity);
        statisticalOrderCustomerOfCityMonth.setSumOrderedCost(sumOrderCost);
        statisticalOrderCustomerOfCityMonth.setSumProfit(sumProfit);
        statisticalOrderCustomerOfCityMonth.setOrderCustomerOfCityMonthCubeList(orderCustomerOfCityMonthCubeList);
        return statisticalOrderCustomerOfCityMonth;
    }

    public void downloadPDFOrderCustomerOfCityMonth(HttpServletResponse response, Integer month, Integer year) throws BadRequestException {
        if (month == null) month = 10;
        if (year == null) year = 2023;
        final Context ctx = new Context(Locale.getDefault());
        ctx.setVariable("orderCustomerOfCityMonth", createStatisticalOrderCustomerOfCityMonth(month, year));
        String xmlTemplate = templateEngine.process("Statistical/OrderCustomerOfCity.xml", ctx);
        generateDocument(response, xmlTemplate);
    }


}
