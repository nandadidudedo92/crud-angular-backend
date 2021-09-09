package com.example.latihan.crud.service.report;

import com.example.latihan.crud.entities.transaction.TransactionDetailEntity;
import com.example.latihan.crud.util.wrapper.ReportStockOutWrapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ReportService {

    List<ReportStockOutWrapper> getOutStockReport(int startCode, int endCode, Date startDate, Date endDate) throws Exception;
}
