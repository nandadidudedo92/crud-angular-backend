package com.example.latihan.crud.wrappers;

import com.example.latihan.crud.util.wrapper.AuditableBaseWrapper;

import java.util.List;

public class TransactionWrapper extends AuditableBaseWrapper {


    private String transactionCode;
    private int total;
    private List<TransactionDetailWrappers> transactionDetailWrappersList;

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

    public List<TransactionDetailWrappers> getTransactionWrapperList() {
        return transactionDetailWrappersList;
    }

    public void setTransactionWrapperList(List<TransactionDetailWrappers> transactionDetailWrappersList) {
        this.transactionDetailWrappersList = transactionDetailWrappersList;
    }
}
