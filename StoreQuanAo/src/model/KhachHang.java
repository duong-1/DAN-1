/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class KhachHang {
    private int KhachHangId;
    private String HoTen;
    private String DiaChi;
    private String SoDienThoai;
    private String gmail;
    private int solanmuahang;
    private float tonggiatridamua;

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getSolanmuahang() {
        return solanmuahang;
    }

    public void setSolanmuahang(int solanmuahang) {
        this.solanmuahang = solanmuahang;
    }

 

    public float getTonggiatridamua() {
        return tonggiatridamua;
    }

    public void setTonggiatridamua(float tonggiatridamua) {
        this.tonggiatridamua = tonggiatridamua;
    }
    
    
    

    public int getKhachHangId() {
        return KhachHangId;
    }

    public void setKhachHangId(int KhachHangId) {
        this.KhachHangId = KhachHangId;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public KhachHang(String john_Doe, String _Main_St, String string, String johndoeexamplecom) {
    }

    public KhachHang(int KhachHangId, String HoTen, String DiaChi, String SoDienThoai, String gmail, int solanmuahang, float tonggiatridamua) {
        this.KhachHangId = KhachHangId;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.gmail = gmail;
        this.solanmuahang = solanmuahang;
        this.tonggiatridamua = tonggiatridamua;
    }

 
    
    
}
