/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class PhuongThucThanhToan {
    private String id;
    private String TenPhuongThuc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenPhuongThuc() {
        return TenPhuongThuc;
    }

    public void setTenPhuongThuc(String TenPhuongThuc) {
        this.TenPhuongThuc = TenPhuongThuc;
    }

    public PhuongThucThanhToan() {
    }

    public PhuongThucThanhToan(String id, String TenPhuongThuc) {
        this.id = id;
        this.TenPhuongThuc = TenPhuongThuc;
    }

    @Override
    public String toString() {
        return TenPhuongThuc ;
    }
    
}
