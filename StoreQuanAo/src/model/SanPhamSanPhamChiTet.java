/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class SanPhamSanPhamChiTet {
    private int SanPhamSanPhamChiTetId;
    private int SanPhamId;
    private int ChiTietSanPhamId;

    public int getSanPhamSanPhamChiTetId() {
        return SanPhamSanPhamChiTetId;
    }

    public void setSanPhamSanPhamChiTetId(int SanPhamSanPhamChiTetId) {
        this.SanPhamSanPhamChiTetId = SanPhamSanPhamChiTetId;
    }

    public int getSanPhamId() {
        return SanPhamId;
    }

    public void setSanPhamId(int SanPhamId) {
        this.SanPhamId = SanPhamId;
    }

    public int getChiTietSanPhamId() {
        return ChiTietSanPhamId;
    }

    public void setChiTietSanPhamId(int ChiTietSanPhamId) {
        this.ChiTietSanPhamId = ChiTietSanPhamId;
    }

    public SanPhamSanPhamChiTet() {
    }

    public SanPhamSanPhamChiTet(int SanPhamSanPhamChiTetId, int SanPhamId, int ChiTietSanPhamId) {
        this.SanPhamSanPhamChiTetId = SanPhamSanPhamChiTetId;
        this.SanPhamId = SanPhamId;
        this.ChiTietSanPhamId = ChiTietSanPhamId;
    }

   
    
    
}
