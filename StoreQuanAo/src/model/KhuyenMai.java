/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class KhuyenMai {
    private int KhuyenMaiId;
    private String TenChuongTrinhKhuyenMai;
    private String MaKhuyenMai;
    private boolean HinhThucGiamGia;
    private String MucGiamGia;
    private int soluongma;
    private String ngaybatdau;
    private String ngayketthuc;
    private boolean TrangThaiMa;

    public boolean isTrangThaiMa() {
        return TrangThaiMa;
    }

    public void setTrangThaiMa(boolean TrangThaiMa) {
        this.TrangThaiMa = TrangThaiMa;
    }
    
    

    public int getKhuyenMaiId() {
        return KhuyenMaiId;
    }

    public void setKhuyenMaiId(int KhuyenMaiId) {
        this.KhuyenMaiId = KhuyenMaiId;
    }

    public String getTenChuongTrinhKhuyenMai() {
        return TenChuongTrinhKhuyenMai;
    }

    public void setTenChuongTrinhKhuyenMai(String TenChuongTrinhKhuyenMai) {
        this.TenChuongTrinhKhuyenMai = TenChuongTrinhKhuyenMai;
    }

    public String getMaKhuyenMai() {
        return MaKhuyenMai;
    }

    public void setMaKhuyenMai(String MaKhuyenMai) {
        this.MaKhuyenMai = MaKhuyenMai;
    }

    public boolean isHinhThucGiamGia() {
        return HinhThucGiamGia;
    }

    public void setHinhThucGiamGia(boolean HinhThucGiamGia) {
        this.HinhThucGiamGia = HinhThucGiamGia;
    }

    public String getMucGiamGia() {
        return MucGiamGia;
    }

    public void setMucGiamGia(String MucGiamGia) {
        this.MucGiamGia = MucGiamGia;
    }

    public int getSoluongma() {
        return soluongma;
    }

    public void setSoluongma(int soluongma) {
        this.soluongma = soluongma;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public KhuyenMai() {
    }

    public KhuyenMai(int KhuyenMaiId, String TenChuongTrinhKhuyenMai, String MaKhuyenMai, boolean HinhThucGiamGia, String MucGiamGia, int soluongma, String ngaybatdau, String ngayketthuc, boolean TrangThaiMa) {
        this.KhuyenMaiId = KhuyenMaiId;
        this.TenChuongTrinhKhuyenMai = TenChuongTrinhKhuyenMai;
        this.MaKhuyenMai = MaKhuyenMai;
        this.HinhThucGiamGia = HinhThucGiamGia;
        this.MucGiamGia = MucGiamGia;
        this.soluongma = soluongma;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.TrangThaiMa = TrangThaiMa;
    }

    @Override
    public String toString() {
        return TenChuongTrinhKhuyenMai;
    }

 
    
    
}
