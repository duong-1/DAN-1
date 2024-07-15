/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TB
 */
public class ChatLieu {
    private int chatlieuid;
    private String tenchatlieu;

    public ChatLieu(String tenchatlieu) {
        this.tenchatlieu = tenchatlieu;
    }

    public ChatLieu() {
    }

    public ChatLieu(int chatlieuid, String tenchatlieu) {
        this.chatlieuid = chatlieuid;
        this.tenchatlieu = tenchatlieu;
    }

    public int getChatlieuid() {
        return chatlieuid;
    }

    public void setChatlieuid(int chatlieuid) {
        this.chatlieuid = chatlieuid;
    }

    public String getTenchatlieu() {
        return tenchatlieu;
    }

    public void setTenchatlieu(String tenchatlieu) {
        this.tenchatlieu = tenchatlieu;
    }

    @Override
    public String toString() {
        return tenchatlieu;
    }
    
    
}
