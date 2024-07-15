/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class Hang {
    private int hangid;
    private String tenhang;

    public Hang(String tenhang) {
        this.tenhang = tenhang;
    }

    public int getHangid() {
        return hangid;
    }

    public void setHangid(int hangid) {
        this.hangid = hangid;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public Hang() {
    }

    public Hang(int hangid, String tenhang) {
        this.hangid = hangid;
        this.tenhang = tenhang;
    }

    @Override
    public String toString() {
        return tenhang;
    }
    
    
}
