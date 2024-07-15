/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class ThuocTinhSanPham {
    private String id;
    private String MauSac;
    private String KichThuoc;
    private String ChatLieu;
    private String Hang;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ThuocTinhSanPham(String id, String MauSac, String KichThuoc, String ChatLieu, String Hang) {
        this.id = id;
        this.MauSac = MauSac;
        this.KichThuoc = KichThuoc;
        this.ChatLieu = ChatLieu;
        this.Hang = Hang;
    }

    public ThuocTinhSanPham() {
    }

    @Override
    public String toString() {
        return id;
    }
    
    
}
