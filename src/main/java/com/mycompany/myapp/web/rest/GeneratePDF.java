package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.enumeration.Type;
import com.mycompany.myapp.service.impl.StatisticalOrderCustomerOfCityMonthService;
import com.mycompany.myapp.service.impl.StatisticalOrderCustomerOfCityService;
import io.undertow.util.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api")
public class GeneratePDF {
    private final Logger log = LoggerFactory.getLogger(OrderCustomerOfCityCubeResource.class);
    private final StatisticalOrderCustomerOfCityService statisticalOrderCustomerOfCityService;
    private final StatisticalOrderCustomerOfCityMonthService statisticalOrderCustomerOfCityMonthService;

    public GeneratePDF(StatisticalOrderCustomerOfCityService statisticalOrderCustomerOfCityService, StatisticalOrderCustomerOfCityMonthService statisticalOrderCustomerOfCityMonthService) {
        this.statisticalOrderCustomerOfCityService = statisticalOrderCustomerOfCityService;
        this.statisticalOrderCustomerOfCityMonthService = statisticalOrderCustomerOfCityMonthService;
    }

    @GetMapping("/download-orderCustomerOfCity")
    public void createPdfOrderCustomerOfCity(
        HttpServletResponse response,
        @RequestParam("filename") String filename,
        @RequestParam(value = "type", required = false) String type,
        @RequestParam(value = "month", defaultValue = "1") Integer month,
        @RequestParam(value = "year", defaultValue = "2023") Integer year)
        throws BadRequestException {
        log.debug("REST request to create PDF OrderCustomerOfCity");
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".pdf");
        if (type.equals(Type.ALL.toString()))
            statisticalOrderCustomerOfCityService.downloadPDFOrderCustomerOfCity(response, 0);
        else if (type.equals(Type.MONTH.toString()))
            statisticalOrderCustomerOfCityMonthService.downloadPDFOrderCustomerOfCityMonth(response, month,year);
    }
}
