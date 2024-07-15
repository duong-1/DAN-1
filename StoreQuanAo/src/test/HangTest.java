/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Service.HangService;
import Service.MauSacService;
import java.util.ArrayList;
import java.util.List;
import model.Hang;
import model.MauSac;

/**
 *
 * @author Ba Thuc
 */
public class HangTest {
       HangService hangService = new HangService();
    List<Hang> list;
    
    public HangTest() {
        list = hangService.getData();
    }

    public void add(Hang hang) {
        if (list == null) {
            list = new ArrayList<>();
        }
//        if() sử lý số âm sử lý linh tinh
        for (Hang hang1 : list) {
            if(hang.getTenhang().equalsIgnoreCase(hang1.getTenhang())){
                throw new IllegalArgumentException("tên trùng");
            }else{
                break;
            }
        }
        hangService.addData(hang);
        
    }
    public void update(Hang hang) {
    if (list == null) {
        list = new ArrayList<>();
    }

    if (hang.getHangid()<= 0) {
        throw new IllegalArgumentException("Id không hợp lệ");
    }

    boolean found = false;

    for (Hang hang1 : list) {
        if (hang.getHangid()== hang1.getHangid()) {
            found = true;
            
            if (hang.getTenhang().equalsIgnoreCase(hang.getTenhang())) {
                throw new IllegalArgumentException("Tên trùng");
            }

            break;
        }
    }

    if (!found) {
        throw new IllegalArgumentException("Không tìm thấy ID");
    }

    hangService.updateData(hang);
    System.out.println("Update Thanh Cong");
}

    public List<Hang> get(){
        return list;
    }
}
