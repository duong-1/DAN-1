/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class QuyenHan {
    private String NguoiDungId;
    private String TenQuyen;

    public String getNguoiDungId() {
        return NguoiDungId;
    }

    public void setNguoiDungId(String NguoiDungId) {
        this.NguoiDungId = NguoiDungId;
    }

    public String getTenQuyen() {
        return TenQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }

    public QuyenHan() {
    }

    public QuyenHan(String NguoiDungId, String TenQuyen) {
        this.NguoiDungId = NguoiDungId;
        this.TenQuyen = TenQuyen;
    }
    
    
}
