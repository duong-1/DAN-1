/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class HoaDon {
    private int HoaDonId;
    private int DonHangId;
    private String PhuongThucThanhToanId;
    private String NguoiTao;
    private float TongTien;
    private int KhachHangId;
    private boolean TrangThai;
    private String created_at;
    private String update_at;
    private String TenPhuongThuc;
    private String hoTenKhachHang;
    private int KhuyenMaiId;
    private boolean TrangThaiHienThi;

    public int getKhuyenMaiId() {
        return KhuyenMaiId;
    }

    public void setKhuyenMaiId(int KhuyenMaiId) {
        this.KhuyenMaiId = KhuyenMaiId;
    }

    public boolean isTrangThaiHienThi() {
        return TrangThaiHienThi;
    }

    public void setTrangThaiHienThi(boolean TrangThaiHienThi) {
        this.TrangThaiHienThi = TrangThaiHienThi;
    }
    
    

    public String getHoTenKhachHang() {
        return hoTenKhachHang;
    }

    public void setHoTenKhachHang(String hoTenKhachHang) {
        this.hoTenKhachHang = hoTenKhachHang;
    }
    
    public int getHoaDonId() {
        return HoaDonId;
    }

    public void setHoaDonId(int HoaDonId) {
        this.HoaDonId = HoaDonId;
    }

    public int getDonHangId() {
        return DonHangId;
    }

    public void setDonHangId(int DonHangId) {
        this.DonHangId = DonHangId;
    }

    public String getPhuongThucThanhToanId() {
        return PhuongThucThanhToanId;
    }

    public String getTenPhuongThuc() {
        return TenPhuongThuc;
    }

    public void setTenPhuongThuc(String TenPhuongThuc) {
        this.TenPhuongThuc = TenPhuongThuc;
    }

    public void setPhuongThucThanhToanId(String PhuongThucThanhToanId) {
        this.PhuongThucThanhToanId = PhuongThucThanhToanId;
    }

    public String getNguoiTao() {
        return NguoiTao;
    }

    public void setNguoiTao(String NguoiTao) {
        this.NguoiTao = NguoiTao;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public int getKhachHangId() {
        return KhachHangId;
    }

    public void setKhachHangId(int KhachHangId) {
        this.KhachHangId = KhachHangId;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
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

    public HoaDon(int HoaDonId, int DonHangId, String PhuongThucThanhToanId, String NguoiTao, float TongTien, int KhachHangId, boolean TrangThai, String created_at, String update_at, String hoTenKhachHang, String tenPhuongThuc, boolean trangthaihienthi, int KhuyenMaiId) {
        this.HoaDonId = HoaDonId;
        this.DonHangId = DonHangId;
        this.PhuongThucThanhToanId = PhuongThucThanhToanId;
        this.NguoiTao = NguoiTao;
        this.TongTien = TongTien;
        this.KhachHangId = KhachHangId;
        this.TrangThai = TrangThai;
        this.created_at = created_at;
        this.update_at = update_at;
        this.hoTenKhachHang = hoTenKhachHang;
        this.TenPhuongThuc = tenPhuongThuc;
        this.TrangThaiHienThi = trangthaihienthi;
        this.KhuyenMaiId = KhuyenMaiId;
    }

  

    public HoaDon() {
    }

    @Override
    public String toString() {
        return HoaDonId + "";
    }
    
}
