package com.example.latihan.crud.entities.master;

import com.example.latihan.crud.util.model.AuditableBase;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity extends AuditableBase {

    @Column(name = "kode_barang", unique=true, nullable = false)
    private int kodeBarang;

    @Column(name = "nama_barang", length = 50, nullable = false)
    private String namaBarang;

    @Column(name = "jumlah", nullable = false)
    private int jumlah;

    @Column(name = "harga", nullable = false)
    private int harga;

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

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "kodeBarang='" + kodeBarang + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", jumlah=" + jumlah +
                ", harga=" + harga +
                '}';
    }
}
