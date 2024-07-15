/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Service.KichThuocService;
import java.util.ArrayList;
import java.util.List;
import model.KichThuoc;
import model.MauSac;

/**
 *
 * @author Ba Thuc
 */
public class kichThuocTest {

    KichThuocService kichThuocService = new KichThuocService();
    List<KichThuoc> list;
    
    public kichThuocTest() {
        list = kichThuocService.getData();
    }

    public void add(KichThuoc kichThuoc) {
    if (list == null) {
        list = new ArrayList<>();
    }

    for (KichThuoc kichThuoc1 : list) {
        if (kichThuoc.getTenkichthuoc().equalsIgnoreCase(kichThuoc1.getTenkichthuoc())) {
            throw new IllegalArgumentException("Tên trùng");
        }
        break;
    }
    
    // Nếu không có phần tử nào trùng tên, thêm vào danh sách và trả về true
    kichThuocService.addData(kichThuoc);
}

    public void update(KichThuoc kichThuoc) {
    if (list == null) {
        list = new ArrayList<>();
    }

    if (kichThuoc.getKichthuocid()<= 0) {
        throw new IllegalArgumentException("Id không hợp lệ");
    }

    boolean found = false;

    for (KichThuoc kichThuoc1 : list) {
        if (kichThuoc.getKichthuocid()== kichThuoc1.getKichthuocid()) {
            found = true;
            break;
        }
    }

    if (!found) {
        throw new IllegalArgumentException("Không tìm thấy ID");
    }

    kichThuocService.updateData(kichThuoc);
    System.out.println("Update Thanh Cong");
}

    public List<KichThuoc> get(){
        return list;
    }
    
}
