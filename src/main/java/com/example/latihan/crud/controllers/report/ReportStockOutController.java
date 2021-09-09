package com.example.latihan.crud.controllers.report;

import com.example.latihan.crud.controllers.master.CustomerController;
import com.example.latihan.crud.entities.transaction.TransactionDetailEntity;
import com.example.latihan.crud.service.report.ReportService;
import com.example.latihan.crud.util.response.CommonResponse;
import com.example.latihan.crud.util.response.CommonResponseGenerator;
import com.example.latihan.crud.util.wrapper.ReportStockOutParamWrapper;
import com.example.latihan.crud.util.wrapper.ReportStockOutWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "stock-report")
public class ReportStockOutController {


    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CommonResponseGenerator comGen;

    @Autowired
    ReportService reportService;

    @PostMapping("out")
    CommonResponse<List<ReportStockOutWrapper>> getReportStockOut(@RequestBody ReportStockOutParamWrapper reportStockOutParamWrapper) {
        try {
            List<ReportStockOutWrapper> transactionDetailEntityList = reportService.getOutStockReport(reportStockOutParamWrapper.getStartCode(), reportStockOutParamWrapper.getEndCode(), reportStockOutParamWrapper.getStartDate(), reportStockOutParamWrapper.getEndDate());
            return comGen.successResponse(transactionDetailEntityList,"Success Get Data Report");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return comGen.failedResponse(e.getMessage());
        }
    }


}
