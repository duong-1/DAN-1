/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class KichThuoc {
    private int kichthuocid;
    private String tenkichthuoc;
    
    

    public KichThuoc(String tenkichthuoc) {
        this.tenkichthuoc = tenkichthuoc;
    }

    public KichThuoc() {
    }

    public KichThuoc(int kichthuocid, String tenkichthuoc) {
        this.kichthuocid = kichthuocid;
        this.tenkichthuoc = tenkichthuoc;
    }

    public int getKichthuocid() {
        return kichthuocid;
    }

    public void setKichthuocid(int kichthuocid) {
        this.kichthuocid = kichthuocid;
    }

    public String getTenkichthuoc() {
        return tenkichthuoc;
    }

    public void setTenkichthuoc(String tenkichthuoc) {
        this.tenkichthuoc = tenkichthuoc;
    }

    @Override
    public String toString() {
        return tenkichthuoc;
    }
    
    
}
