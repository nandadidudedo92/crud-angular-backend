package com.example.latihan.crud.wrappers;

import com.example.latihan.crud.util.wrapper.AuditableBaseWrapper;

import java.util.List;

public class AddTransactionWrapper  extends AuditableBaseWrapper {
    private String customerName;
    private List<TransactionDetailWrappers> transactionDetailWrappersList;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<TransactionDetailWrappers> getTransactionWrapperList() {
        return transactionDetailWrappersList;
    }

    public void setTransactionWrapperList(List<TransactionDetailWrappers> transactionDetailWrappersList) {
        this.transactionDetailWrappersList = transactionDetailWrappersList;
    }
}
