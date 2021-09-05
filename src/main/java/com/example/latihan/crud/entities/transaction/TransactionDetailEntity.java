package com.example.latihan.crud.entities.transaction;

import com.example.latihan.crud.util.model.AuditableBase;

import javax.persistence.*;

@Entity
@Table(name = "transaction_detail")
public class TransactionDetailEntity extends AuditableBase {

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private TransactionEntity transactionEntity;

    @Column(name = "item_code")
    private int kodeBarang;
    @Column(name = "item_name")
    private String namaBarang;
    @Column(name = "quantity")
    private int qty;
    @Column(name = "sub_total")
    private int subTotal;
    @Column(name = "transaction_code")
    private String transactionCode;

    public TransactionEntity getTransactionEntity() {
        return transactionEntity;
    }

    public void setTransactionEntity(TransactionEntity transactionEntity) {
        this.transactionEntity = transactionEntity;
    }

    public int getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(int kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    @Override
    public String toString() {
        return "TransactionDetailEntity{" +
                "transactionEntity=" + transactionEntity +
                ", kodeBarang=" + kodeBarang +
                ", namaBarang='" + namaBarang + '\'' +
                ", qty=" + qty +
                ", subTotal=" + subTotal +
                ", transactionCode='" + transactionCode + '\'' +
                '}';
    }
}
