/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class MauSac {
    private int mausacid;
    private String tenmausac;

    public MauSac(String tenmausac) {
        this.tenmausac = tenmausac;
    }

    public int getMausacid() {
        return mausacid;
    }

    public void setMausacid(int mausacid) {
        this.mausacid = mausacid;
    }

    public String getTenmausac() {
        return tenmausac;
    }

    public void setTenmausac(String tenmausac) {
        this.tenmausac = tenmausac;
    }

    public MauSac(int mausacid, String tenmausac) {
        this.mausacid = mausacid;
        this.tenmausac = tenmausac;
    }

    public MauSac() {
    }

    @Override
    public String toString() {
        return tenmausac;
    }
    
    
}
