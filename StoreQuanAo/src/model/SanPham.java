/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author TB
 */
public class SanPham {
    private int SanPhamId;
    private int SanPhamChiTietId;
    private String PhanLoai;
    private String TenSanPham;
    private String create_at;
    private String update_at;

    public int getSanPhamId() {
        return SanPhamId;
    }

    public void setSanPhamId(int SanPhamId) {
        this.SanPhamId = SanPhamId;
    }

    public int getSanPhamChiTietId() {
        return SanPhamChiTietId;
    }

    public void setSanPhamChiTietId(int SanPhamChiTietId) {
        this.SanPhamChiTietId = SanPhamChiTietId;
    }

   



    public String getPhanLoai() {
        return PhanLoai;
    }

    public void setPhanLoai(String PhanLoai) {
        this.PhanLoai = PhanLoai;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

  

   

    public SanPham() {
    }

    public SanPham(int SanPhamId, int SanPhamChiTietId, String PhanLoai, String TenSanPham, String create_at, String update_at) {
        this.SanPhamId = SanPhamId;
        this.SanPhamChiTietId = SanPhamChiTietId;
        this.PhanLoai = PhanLoai;
        this.TenSanPham = TenSanPham;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "SanPham{" + "SanPhamId=" + SanPhamId + ", SanPhamChiTietId=" + SanPhamChiTietId + ", PhanLoai=" + PhanLoai + ", TenSanPham=" + TenSanPham + ", create_at=" + create_at + ", update_at=" + update_at + '}';
    }
    
    
}
