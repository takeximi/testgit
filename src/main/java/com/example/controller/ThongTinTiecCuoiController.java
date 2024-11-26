package com.example.controller;

import com.example.model.DichVu;
import com.example.model.ThongTinTiecCuoi;
import com.example.service.ThongTinTiecCuoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

import static com.example.service.MyRandom.generateID;

@Controller
public class ThongTinTiecCuoiController {
    @Autowired
    private ThongTinTiecCuoiService thongTinTiecCuoiService;


    @GetMapping ("/addTiecCuoi")
    public String showAddContractForm(Model model) {
        model.addAttribute("tieccuoi", new ThongTinTiecCuoi());
        List<DichVu> dichvu = thongTinTiecCuoiService.getAllDichVu();
        model.addAttribute("dichvu", dichvu);
        return "addTiecCuoi"; // Trở về trang thêm hợp đồng

    }


    @RequestMapping(value = "/addTiecCuoi", method = RequestMethod.POST)
    public String addContract(@Valid @ModelAttribute("tieccuoi") ThongTinTiecCuoi tiecCuoi,
                              BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            // In ra số lượng lỗi trên console
            System.out.println("Số lượng lỗi: " + result.getErrorCount());
            // In ra thông điệp lỗi từng trường
            result.getAllErrors().forEach(error ->
                    System.out.println("Lỗi: " + error.getDefaultMessage())
            );
            return "addContract"; // Trả về view nếu có lỗi
        }

        LocalDate ngayDatCoc = LocalDate.now();
        tiecCuoi.setTrangThai(0); // Gán mã đăng ký vào đối tượng
        tiecCuoi.setNgayDatCoc(ngayDatCoc);

        Double giaTriThanhToan = 0.0;
        Double dongia = 0.0;
        if(tiecCuoi.getSoLuongBan() <=15 && tiecCuoi.getSoLuongBan() >1){
            dongia = Double.valueOf(2400000);
        }else if(tiecCuoi.getSoLuongBan() >15 && tiecCuoi.getSoLuongBan() <26){
            dongia = Double.valueOf(2300000);
        }else if(tiecCuoi.getSoLuongBan() >25 && tiecCuoi.getSoLuongBan() <36){
            dongia = Double.valueOf(2200000);
        }else if(tiecCuoi.getSoLuongBan() >35 && tiecCuoi.getSoLuongBan() <45){
            dongia = Double.valueOf(2100000);
        }else if(tiecCuoi.getSoLuongBan() >45 ){
            dongia = Double.valueOf(2000000);
        }

        giaTriThanhToan = dongia * tiecCuoi.getSoLuongBan() + thongTinTiecCuoiService.getDonGia(tiecCuoi.getDichVuDiKem()) - tiecCuoi.getTienDatCoc();
        tiecCuoi.setTienThanhToan(giaTriThanhToan);
        try {
            thongTinTiecCuoiService.save(tiecCuoi);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm hợp đồng thành công!");
            return "redirect:/viewTiecCuoi"; // Trở về danh sách hợp đồng
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/errorpage"; // Quay lại trang thêm hợp đồng
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi thêm hợp đồng: " + e.getMessage());
            return "redirect:/addTiecCuoi"; // Quay lại trang thêm hợp đồng
        }
    }



    @GetMapping("/deleteTiecCuoi")
    public String deleteTiecCuoi(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        try {
            thongTinTiecCuoiService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Tiệc cưới đã được xóa thành công.");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("message", "Không thể xóa Tiệc cưới " + e.getMessage());
        }
        return "redirect:/viewTiecCuoi"; // Path đến danh sách hợp đồng
    }


    @RequestMapping(value = "/viewTiecCuoi", method = RequestMethod.GET)
    public String layDanhSachXe(@RequestParam(name = "ten", required = false, defaultValue = "")
                                String ten,
                                Model model) {

        List<Object[]>  danhSachTiecCuoi;
        if (ten != null && !ten.isEmpty() ) {
            danhSachTiecCuoi = thongTinTiecCuoiService.getTiecCuoiByTen(ten);
        } else {
            danhSachTiecCuoi = thongTinTiecCuoiService.getTiecCuoi();
        }

        model.addAttribute("danhSachTiecCuoi", danhSachTiecCuoi);
        return "viewTiecCuoi"; // Trả về view JSP tương ứng
    }


}
