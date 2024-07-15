/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class ThongKe {
    private int thang;
    private float tongdoanhthu;
    private int tongkhachhang;

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public float getTongdoanhthu() {
        return tongdoanhthu;
    }

    public void setTongdoanhthu(float tongdoanhthu) {
        this.tongdoanhthu = tongdoanhthu;
    }

    public int getTongkhachhang() {
        return tongkhachhang;
    }

    public void setTongkhachhang(int tongkhachhang) {
        this.tongkhachhang = tongkhachhang;
    }

    public ThongKe() {
    }

    public ThongKe(int thang, float tongdoanhthu, int tongkhachhang) {
        this.thang = thang;
        this.tongdoanhthu = tongdoanhthu;
        this.tongkhachhang = tongkhachhang;
    }
    
    
}
