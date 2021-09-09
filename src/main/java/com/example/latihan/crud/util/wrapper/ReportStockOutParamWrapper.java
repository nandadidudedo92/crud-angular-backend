package com.example.latihan.crud.util.wrapper;

import java.util.Date;

public class ReportStockOutParamWrapper {

    private int startCode;
    private int endCode;
    private Date startDate;
    private Date endDate;

    public int getStartCode() {
        return startCode;
    }

    public void setStartCode(int startCode) {
        this.startCode = startCode;
    }

    public int getEndCode() {
        return endCode;
    }

    public void setEndCode(int endCode) {
        this.endCode = endCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
