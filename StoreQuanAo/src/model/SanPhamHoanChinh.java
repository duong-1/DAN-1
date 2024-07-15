/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author TB
 */
public class SanPhamHoanChinh {
     private String SanPhamId;
    private String SanPhamChiTietId;
    private String PhanLoai;
    private String TenSanPham;
    private String create_at;
    private String update_at;
    private String ThuocTinhId;
    private String ThuocTinhSanPhamId;
    private float giaTien;
    private int soLuong;
    private boolean trangThai;
    private String moTaSoBo;
    private String moTaChitiet;
    private String ChiTietSanPhamid;
    private String MauSac;
    private String Anh;
    private String KichThuoc;
    private String ChatLieu;
    private String Hang;
    private int MauSacId;
    private int KichThuocId;
    private int ChatLieuId;
    private int HangId;
    private int spspctSanPhamId;
    private int spspctChiTietSanPhamId;
    private int SanPhamSanPhamChiTetId;
    public SanPhamHoanChinh() {
    }

    public SanPhamHoanChinh(String SanPhamId, String SanPhamChiTietId, String PhanLoai, String TenSanPham, String create_at, String update_at, String ThuocTinhId, String ThuocTinhSanPhamId, float giaTien, int soLuong, boolean trangThai, String moTaSoBo, String moTaChitiet, String ChiTietSanPhamid, String MauSac, String Anh, String KichThuoc, String ChatLieu, String Hang, int MauSacId, int KichThuocId, int ChatLieuId, int HangId, int spspctSanPhamId, int spspctChiTietSanPhamId, int SanPhamSanPhamChiTetId) {
        this.SanPhamId = SanPhamId;
        this.SanPhamChiTietId = SanPhamChiTietId;
        this.PhanLoai = PhanLoai;
        this.TenSanPham = TenSanPham;
        this.create_at = create_at;
        this.update_at = update_at;
        this.ThuocTinhId = ThuocTinhId;
        this.ThuocTinhSanPhamId = ThuocTinhSanPhamId;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.moTaSoBo = moTaSoBo;
        this.moTaChitiet = moTaChitiet;
        this.ChiTietSanPhamid = ChiTietSanPhamid;
        this.MauSac = MauSac;
        this.Anh = Anh;
        this.KichThuoc = KichThuoc;
        this.ChatLieu = ChatLieu;
        this.Hang = Hang;
        this.MauSacId = MauSacId;
        this.KichThuocId = KichThuocId;
        this.ChatLieuId = ChatLieuId;
        this.HangId = HangId;
        this.spspctSanPhamId = spspctSanPhamId;
        this.spspctChiTietSanPhamId = spspctChiTietSanPhamId;
        this.SanPhamSanPhamChiTetId = SanPhamSanPhamChiTetId;
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

    public int getChatLieuId() {
        return ChatLieuId;
    }

    public void setChatLieuId(int ChatLieuId) {
        this.ChatLieuId = ChatLieuId;
    }

    public int getHangId() {
        return HangId;
    }

    public void setHangId(int HangId) {
        this.HangId = HangId;
    }

    

    

   

    

   

    public int getSanPhamSanPhamChiTetId() {
        return SanPhamSanPhamChiTetId;
    }

    public void setSanPhamSanPhamChiTetId(int SanPhamSanPhamChiTetId) {
        this.SanPhamSanPhamChiTetId = SanPhamSanPhamChiTetId;
    }

   

    public int getSpspctSanPhamId() {
        return spspctSanPhamId;
    }

    public void setSpspctSanPhamId(int spspctSanPhamId) {
        this.spspctSanPhamId = spspctSanPhamId;
    }

    public int getSpspctChiTietSanPhamId() {
        return spspctChiTietSanPhamId;
    }

    public void setSpspctChiTietSanPhamId(int spspctChiTietSanPhamId) {
        this.spspctChiTietSanPhamId = spspctChiTietSanPhamId;
    }

    public String getSanPhamId() {
        return SanPhamId;
    }

    public void setSanPhamId(String SanPhamId) {
        this.SanPhamId = SanPhamId;
    }

    public String getSanPhamChiTietId() {
        return SanPhamChiTietId;
    }

    public void setSanPhamChiTietId(String SanPhamChiTietId) {
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



    public String getThuocTinhId() {
        return ThuocTinhId;
    }

    public void setThuocTinhId(String ThuocTinhId) {
        this.ThuocTinhId = ThuocTinhId;
    }

    public String getThuocTinhSanPhamId() {
        return ThuocTinhSanPhamId;
    }

    public void setThuocTinhSanPhamId(String ThuocTinhSanPhamId) {
        this.ThuocTinhSanPhamId = ThuocTinhSanPhamId;
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



  

    public String getChiTietSanPhamid() {
        return ChiTietSanPhamid;
    }

    public void setChiTietSanPhamid(String ChiTietSanPhamid) {
        this.ChiTietSanPhamid = ChiTietSanPhamid;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getKichThuoc() {
        return KichThuoc;
    }

    public void setKichThuoc(String KichThuoc) {
        this.KichThuoc = KichThuoc;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    @Override
    public String toString() {
        return "SanPhamHoanChinh{" + "SanPhamId=" + SanPhamId + ", SanPhamChiTietId=" + SanPhamChiTietId + ", PhanLoai=" + PhanLoai + ", TenSanPham=" + TenSanPham + ", create_at=" + create_at + ", update_at=" + update_at + ", ThuocTinhId=" + ThuocTinhId + ", ThuocTinhSanPhamId=" + ThuocTinhSanPhamId + ", giaTien=" + giaTien + ", soLuong=" + soLuong + ", trangThai=" + trangThai + ", moTaSoBo=" + moTaSoBo + ", moTaChitiet=" + moTaChitiet + ", Anh=" + Anh+ ", ChiTietSanPhamid=" + ChiTietSanPhamid + ", MauSac=" + MauSac + ", KichThuoc=" + KichThuoc + ", ChatLieu=" + ChatLieu + ", Hang=" + Hang + '}';
    }
    
}
