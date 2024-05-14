package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Statistical.StatisticalOrderCustomerOfCity;
import com.mycompany.myapp.service.AbstractStatistical;

import io.undertow.util.BadRequestException;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


@Service
public class StatisticalOrderCustomerOfCityService extends AbstractStatistical {
    private final TemplateEngine templateEngine;
    private final OrderCustomerOfCityCubeService orderCustomerOfCityCubeService;

    public StatisticalOrderCustomerOfCityService(TemplateEngine templateEngine, OrderCustomerOfCityCubeService orderCustomerOfCityCubeService) {
        this.templateEngine = templateEngine;
        this.orderCustomerOfCityCubeService = orderCustomerOfCityCubeService;
    }

    public StatisticalOrderCustomerOfCity createStatisticalOrderCustomerOfCity() {
        StatisticalOrderCustomerOfCity statisticalOrderCustomerOfCity = new StatisticalOrderCustomerOfCity();
        statisticalOrderCustomerOfCity.setNameCompany("Nhóm 11");
        statisticalOrderCustomerOfCity.setNameStatistical("BÁO CÁO THỐNG KÊ THEO THÀNH PHỐ");
        statisticalOrderCustomerOfCity.setMonth("10");
        statisticalOrderCustomerOfCity.setYear("2023");
        statisticalOrderCustomerOfCity.setOrderCustomerOfCityCubeList(orderCustomerOfCityCubeService.findAll());
        return statisticalOrderCustomerOfCity;
    }

    public void downloadPDFOrderCustomerOfCity(HttpServletResponse response, Integer month) throws BadRequestException {
        final Context ctx = new Context(Locale.getDefault());
        ctx.setVariable("orderCustomerOfCity", createStatisticalOrderCustomerOfCity());
        ctx.setVariable("month", month);
        String xmlTemplate = templateEngine.process("Statistical/OrderCustomerOfCity.xml", ctx);
        generateDocument(response, xmlTemplate);
    }
}
