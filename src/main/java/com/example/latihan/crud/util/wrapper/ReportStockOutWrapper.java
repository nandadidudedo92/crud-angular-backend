package com.example.latihan.crud.util.wrapper;

import com.example.latihan.crud.entities.master.ProductEntity;

public class ReportStockOutWrapper {

    private int kodeBarang;
    private String namaBarang;
    private Long qty;
    private Long totalStock;
    private Long restStock;

    private ProductEntity productEntity;

    public ReportStockOutWrapper(int kodeBarang, String namaBarang, Long qty, ProductEntity productEntity) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.qty = qty;
        this.productEntity = productEntity;
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

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }


    public Long getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Long totalStock) {
        this.totalStock = totalStock;
    }

    public Long getRestStock() {
        return restStock;
    }

    public void setRestStock(Long restStock) {
        this.restStock = restStock;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
