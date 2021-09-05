package com.example.latihan.crud.entities.transaction;

import com.example.latihan.crud.util.model.AuditableBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends AuditableBase {

    @Column(name = "transaction_code")
    private String transationCode;
    @Column(name = "total_transaction")
    private int totalTransaction;

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

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "transationCode='" + transationCode + '\'' +
                ", totalTransaction=" + totalTransaction +
                '}';
    }
}
