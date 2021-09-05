package com.example.latihan.crud.wrappers;

import com.example.latihan.crud.util.wrapper.AuditableBaseWrapper;

import java.util.List;

public class TransactionDetailWrapper extends AuditableBaseWrapper {


    private String transactionCode;
    private int total;
    private List<TransactionWrapper> transactionWrapperList;

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TransactionWrapper> getTransactionWrapperList() {
        return transactionWrapperList;
    }

    public void setTransactionWrapperList(List<TransactionWrapper> transactionWrapperList) {
        this.transactionWrapperList = transactionWrapperList;
    }
}
