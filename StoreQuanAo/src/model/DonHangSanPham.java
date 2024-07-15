/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class DonHangSanPham {

  private int SanPhamSanPhamChiTietId;
  private int HoaDonId;
  private int SoLuong;

    public DonHangSanPham() {
    }

    public int getSanPhamSanPhamChiTietId() {
        return SanPhamSanPhamChiTietId;
    }

    public void setSanPhamSanPhamChiTietId(int SanPhamSanPhamChiTietId) {
        this.SanPhamSanPhamChiTietId = SanPhamSanPhamChiTietId;
    }

    public DonHangSanPham(int SanPhamSanPhamChiTietId, int HoaDonId, int SoLuong) {
        this.SanPhamSanPhamChiTietId = SanPhamSanPhamChiTietId;
        this.HoaDonId = HoaDonId;
        this.SoLuong = SoLuong;
    }

    public int getHoaDonId() {
        return HoaDonId;
    }

    public void setHoaDonId(int HoaDonId) {
        this.HoaDonId = HoaDonId;
    }

  

  
    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

  
}
