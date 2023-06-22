package com.hilman.chalenge.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "makanan")
public class Makanan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nama;
    private String descirption;
    private boolean diJual;

    public Makanan() {
    }

    public Makanan(String nama, String descirption, boolean diJual) {
        this.nama = nama;
        this.descirption = descirption;
        this.diJual = diJual;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public boolean isDiJual() {
        return diJual;
    }

    public void setDijual(boolean diJual) {
        this.diJual = diJual;
    }
}
