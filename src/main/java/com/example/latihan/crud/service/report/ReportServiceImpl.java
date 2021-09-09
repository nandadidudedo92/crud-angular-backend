package com.example.latihan.crud.service.report;

import com.example.latihan.crud.entities.transaction.TransactionDetailEntity;
import com.example.latihan.crud.repositories.transaction.TransactionDetailRepository;
import com.example.latihan.crud.util.wrapper.ReportStockOutWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ReportServiceImpl implements ReportService{

    @Autowired
    TransactionDetailRepository transactionDetailRepository;

    @Override
    public List<ReportStockOutWrapper> getOutStockReport(int startCode, int endCode, Date startDate, Date endDate) throws Exception {
        List<ReportStockOutWrapper> reportStockOutWrapperList = transactionDetailRepository.getStockOutReport(startCode,endCode);
        List<ReportStockOutWrapper> reportStockOutWrappers = new ArrayList<>();
        for (ReportStockOutWrapper reportStockOutWrapper: reportStockOutWrapperList) {
            ReportStockOutWrapper reportStockOutWrapper1 = toWrapper(reportStockOutWrapper);
            reportStockOutWrappers.add(reportStockOutWrapper1);
        }
        return reportStockOutWrappers;
    }
//    int kodeBarang, String namaBarang, Long qty, ProductEntity productEntity
    private ReportStockOutWrapper toWrapper(ReportStockOutWrapper reportStockOutWrappers) {
        ReportStockOutWrapper reportStockOutWrapper = new ReportStockOutWrapper(reportStockOutWrappers.getKodeBarang(), reportStockOutWrappers.getNamaBarang(), reportStockOutWrappers.getQty(), reportStockOutWrappers.getProductEntity());
        reportStockOutWrapper.setTotalStock(reportStockOutWrappers.getProductEntity().getJumlah() + reportStockOutWrappers.getQty());
        reportStockOutWrapper.setRestStock((long) reportStockOutWrappers.getProductEntity().getJumlah());

        return reportStockOutWrapper;
    }
}
