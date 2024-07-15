/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class ChiTietSanPham {
    private int Id;
    private int MauSacId;
    private int KichThuocId;
    private int HangId;
    private int ChatLieuId;
    private float giaTien;
    private int soLuong;
    private boolean trangThai;
    private String moTaSoBo;
    private String moTaChitiet;
    private String Anh;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getMauSacId() {
        return MauSacId;
    }

    public void setMauSacId(int MauSacId) {
        this.MauSacId = MauSacId;
    }

    public int getKichThuocId() {
        return KichThuocId;
    }

    public void setKichThuocId(int KichThuocId) {
        this.KichThuocId = KichThuocId;
    }

    public int getHangId() {
        return HangId;
    }

    public void setHangId(int HangId) {
        this.HangId = HangId;
    }

    public int getChatLieuId() {
        return ChatLieuId;
    }

    public void setChatLieuId(int ChatLieuId) {
        this.ChatLieuId = ChatLieuId;
    }

   

   

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTaSoBo() {
        return moTaSoBo;
    }

    public void setMoTaSoBo(String moTaSoBo) {
        this.moTaSoBo = moTaSoBo;
    }

    public String getMoTaChitiet() {
        return moTaChitiet;
    }

    public void setMoTaChitiet(String moTaChitiet) {
        this.moTaChitiet = moTaChitiet;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

 

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int Id, int MauSacId, int KichThuocId, int HangId, int ChatLieuId, float giaTien, int soLuong, boolean trangThai, String moTaSoBo, String moTaChitiet, String Anh) {
        this.Id = Id;
        this.MauSacId = MauSacId;
        this.KichThuocId = KichThuocId;
        this.HangId = HangId;
        this.ChatLieuId = ChatLieuId;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.moTaSoBo = moTaSoBo;
        this.moTaChitiet = moTaChitiet;
        this.Anh = Anh;
    }

    @Override
    public String toString() {
        return "ChiTietSanPham{" + "Id=" + Id + ", MauSacId=" + MauSacId + ", KichThuocId=" + KichThuocId + ", HangId=" + HangId + ", ChatLieuId=" + ChatLieuId + ", giaTien=" + giaTien + ", soLuong=" + soLuong + ", trangThai=" + trangThai + ", moTaSoBo=" + moTaSoBo + ", moTaChitiet=" + moTaChitiet + ", Anh=" + Anh + '}';
    }

   
   
    
}
