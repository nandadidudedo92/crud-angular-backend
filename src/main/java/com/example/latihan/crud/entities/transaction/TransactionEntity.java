package com.example.latihan.crud.entities.transaction;

import com.example.latihan.crud.entities.master.CustomerEntity;
import com.example.latihan.crud.util.model.AuditableBase;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends AuditableBase {

    @Column(name = "transaction_code")
    private String transationCode;
    @Column(name = "total_transaction")
    private int totalTransaction;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    public String getTransationCode() {
        return transationCode;
    }

    public void setTransationCode(String transationCode) {
        this.transationCode = transationCode;
    }

    public int getTotalTransaction() {
        return totalTransaction;
    }

    public void setTotalTransaction(int totalTransaction) {
        this.totalTransaction = totalTransaction;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "transationCode='" + transationCode + '\'' +
                ", totalTransaction=" + totalTransaction +
                '}';
    }
}
