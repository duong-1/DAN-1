/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Service.KichThuocService;
import Service.MauSacService;
import java.util.ArrayList;
import java.util.List;
import model.KichThuoc;
import model.MauSac;

/**
 *
 * @author Ba Thuc
 */
public class MauSacTest {
       MauSacService mauSacService = new MauSacService();
    List<MauSac> list;
    
    public MauSacTest() {
        list = mauSacService.getData();
    }

    public void add(MauSac mauSac) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (MauSac mauSac1 : list) {
            if(mauSac.getTenmausac().equalsIgnoreCase(mauSac1.getTenmausac())){
                throw new IllegalArgumentException("tên trùng");
            }else{
                break;
            }
        }
        mauSacService.addData(mauSac);
        
    }
   public void update(MauSac mauSac) {
    if (list == null) {
        list = new ArrayList<>();
    }

    if (mauSac.getMausacid() <= 0) {
        throw new IllegalArgumentException("Id không hợp lệ");
    }

    boolean found = false;

    for (MauSac mauSac1 : list) {
        if (mauSac.getMausacid() == mauSac1.getMausacid()) {
            found = true;
            break;
        }
    }

    if (!found) {
        throw new IllegalArgumentException("Không tìm thấy ID");
    }

    mauSacService.updateData(mauSac);
    System.out.println("Update Thanh Cong");
}


    public List<MauSac> get(){
        return list;
    }
}
