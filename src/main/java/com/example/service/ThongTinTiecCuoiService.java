package com.example.service;

import com.example.model.DichVu;
import com.example.model.ThongTinTiecCuoi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ThongTinTiecCuoiService {
    @Autowired
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<ThongTinTiecCuoi> getAllThongTin() {
        Session session = sessionFactory.getCurrentSession();

        // Câu truy vấn HQL với điều kiện sắp xếp
        List<ThongTinTiecCuoi> khachHangList = session.createQuery("SELECT v FROM ThongTinTiecCuoi v ", ThongTinTiecCuoi.class).getResultList();

        return khachHangList;
    }


    @Transactional
    public void delete(String id) {
        ThongTinTiecCuoi tiecCuoi = sessionFactory.getCurrentSession().get(ThongTinTiecCuoi.class, id);
        if (tiecCuoi != null) {
            sessionFactory.getCurrentSession().delete(tiecCuoi);
        }
    }

    
    @Transactional(readOnly = true)
    // Phương thức để tìm kiếm xe theo tên nhà xe
    public List< Object[]> getTiecCuoiByTen(String ten) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                        "SELECT tieccuoi.id, tieccuoi.ngayToChuc, tieccuoi.tenCoDau, tieccuoi.tenChuRe, tieccuoi.soLuongBan, tieccuoi.donGia" +
                                ", tieccuoi.dichVuDiKem, tieccuoi.tienDatCoc, tieccuoi.tienThanhToan, tieccuoi.ngayDatCoc, tieccuoi.ngayThanhToan, tieccuoi.ghiChu, tieccuoi.trangThai " +
                                "FROM ThongTinTiecCuoi tieccuoi " +

                                "WHERE tieccuoi.tenCoDau LIKE :ten Or tieccuoi.tenChuRe LIKE :ten ",  Object[].class)
                .setParameter("ten", "%" + ten + "%")


                .list();
    }

    @Transactional(readOnly = true)

    public List< Object[]> getTiecCuoi() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                        "SELECT tieccuoi.id, tieccuoi.ngayToChuc, tieccuoi.tenCoDau, tieccuoi.tenChuRe, tieccuoi.soLuongBan, tieccuoi.donGia" +
                                ", tieccuoi.dichVuDiKem, tieccuoi.tienDatCoc, tieccuoi.tienThanhToan, tieccuoi.ngayDatCoc, tieccuoi.ngayThanhToan, tieccuoi.ghiChu, tieccuoi.trangThai " +
                                "FROM ThongTinTiecCuoi tieccuoi " ,  Object[].class)

                .list();
    }


    @Transactional
    public void save(ThongTinTiecCuoi tiecCuoi) {
                LocalDate currentDate = LocalDate.now();

        if (tiecCuoi.getSoLuongBan() >100 || tiecCuoi.getSoLuongBan() <0) {
            throw new IllegalArgumentException("Số lượng Bàn phải là số nguyên dương, tối đa là 100");
        }

        // Validate giá trị hợp đồng
        if (tiecCuoi.getTienDatCoc() <= tiecCuoi.getTienThanhToan()* 10/100) {
            throw new IllegalArgumentException("Tiền đặt cọc không đủ");
        }

        sessionFactory.getCurrentSession().save(tiecCuoi);
    }



    @Transactional(readOnly = true)
    public List<DichVu> getAllDichVu() {
        Session session = sessionFactory.getCurrentSession();

        // Câu truy vấn HQL với điều kiện sắp xếp
        List<DichVu> dichvu = session.createQuery("SELECT v FROM DichVu v ", DichVu.class).getResultList();

        return dichvu;
    }
    @Transactional(readOnly = true)
    public double getDonGia(String maDV) {
        DichVu dichVu = sessionFactory.getCurrentSession().get(DichVu.class, maDV);
        return (dichVu != null) ? dichVu.getDonGia() : 0; // Nếu không tìm thấy, trả về 0 vnđ
    }
}
