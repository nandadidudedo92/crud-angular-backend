package com.example.latihan.crud.wrappers;

import com.example.latihan.crud.util.wrapper.AuditableBaseWrapper;

import java.util.List;

public class AddTransactionWrapper  extends AuditableBaseWrapper {
    private String customerName;
    private List<TransactionWrapper> transactionWrapperList;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<TransactionWrapper> getTransactionWrapperList() {
        return transactionWrapperList;
    }

    public void setTransactionWrapperList(List<TransactionWrapper> transactionWrapperList) {
        this.transactionWrapperList = transactionWrapperList;
    }
}
