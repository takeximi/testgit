package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DichVu") // Tên bảng trong cơ sở dữ liệu
public class DichVu {
    @Id
    @Column(name = "ID_DichVu")
    private String id_DichVu;

    @Column(name = "TenDichVu")
    private String tenDichVu;

    @Column(name = "DonGia")
    private Double donGia;

    public DichVu() {

    }

    public DichVu(String id_DichVu, String tenDichVu, Double donGia) {

        this.id_DichVu = id_DichVu;
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
    }

    public String getId_DichVu() {
        return id_DichVu;
    }

    public void setId_DichVu(String id_DichVu) {
        this.id_DichVu = id_DichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
}
