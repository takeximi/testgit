package com.example.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "ThongTinTiecCuoi") // Tên bảng trong cơ sở dữ liệu
public class ThongTinTiecCuoi {

    @Id
    @Column(name = "ID")
    private String id;


    @Column(name = "NgayToChuc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayToChuc;


    @Column(name = "TenCoDau")
    private String tenCoDau;


    @Column(name = "TenChuRe")
    private String tenChuRe;


    @Column(name = "SoLuongBan")
    private int soLuongBan;

    @Column(name = "DonGia")
    private Double donGia;

    @Column(name = "DichVuDiKem")
    private String dichVuDiKem;
    @Column(name = "TienDatCoc")
    private Double tienDatCoc;

    @Column(name = "TienThanhToan")
    private Double tienThanhToan;


    @Column(name = "NgayDatCoc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayDatCoc;
    @Column(name = "NgayThanhToan")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayThanhToan;


    @Column(name = "GhiChu")
    private String ghiChu;


    @Column(name = "TrangThai")
    private int trangThai;


    public ThongTinTiecCuoi() {

    }

    public ThongTinTiecCuoi(String id, LocalDate ngayToChuc, String tenCoDau, String tenChuRe, int soLuongBan, Double donGia, String dichVuDiKem, Double tienDatCoc, Double tienThanhToan, LocalDate ngayDatCoc, LocalDate ngayThanhToan, String ghiChu, int trangThai) {
        this.id = id;
        this.ngayToChuc = ngayToChuc;
        this.tenCoDau = tenCoDau;
        this.tenChuRe = tenChuRe;
        this.soLuongBan = soLuongBan;
        this.donGia = donGia;
        this.dichVuDiKem = dichVuDiKem;
        this.tienDatCoc = tienDatCoc;
        this.tienThanhToan = tienThanhToan;
        this.ngayDatCoc = ngayDatCoc;
        this.ngayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(LocalDate ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public String getTenCoDau() {
        return tenCoDau;
    }

    public void setTenCoDau(String tenCoDau) {
        this.tenCoDau = tenCoDau;
    }

    public String getTenChuRe() {
        return tenChuRe;
    }

    public void setTenChuRe(String tenChuRe) {
        this.tenChuRe = tenChuRe;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getDichVuDiKem() {
        return dichVuDiKem;
    }

    public void setDichVuDiKem(String dichVuDiKem) {
        this.dichVuDiKem = dichVuDiKem;
    }

    public Double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(Double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public Double getTienThanhToan() {
        return tienThanhToan;
    }

    public void setTienThanhToan(Double tienThanhToan) {
        this.tienThanhToan = tienThanhToan;
    }

    public LocalDate getNgayDatCoc() {
        return ngayDatCoc;
    }

    public void setNgayDatCoc(LocalDate ngayDatCoc) {
        this.ngayDatCoc = ngayDatCoc;
    }

    public LocalDate getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(LocalDate ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
