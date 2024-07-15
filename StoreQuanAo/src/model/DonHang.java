/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class DonHang {

    private int DonHangId;
    private boolean TrangThai;
    private String NguoiDungId;
    private String created_at;
    private String update_at;

    public int getDonHangId() {
        return DonHangId;
    }

    public void setDonHangId(int DonHangId) {
        this.DonHangId = DonHangId;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getNguoiDungId() {
        return NguoiDungId;
    }

    public void setNguoiDungId(String NguoiDungId) {
        this.NguoiDungId = NguoiDungId;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public DonHang() {
    }

    public DonHang(int DonHangId, String NguoiDungId, boolean TrangThai, String created_at, String update_at) {
        this.DonHangId = DonHangId;
        this.NguoiDungId = NguoiDungId;
        this.TrangThai = TrangThai;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return DonHangId+"";
    }

   

}
