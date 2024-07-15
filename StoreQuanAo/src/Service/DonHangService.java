/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.DonHang;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class DonHangService {

    public List<DonHang> getData() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from DonHang";
        List<DonHang> ldh = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DonHang dh = new DonHang();
   
                dh.setDonHangId(rs.getInt("DonHangId"));
                dh.setNguoiDungId(rs.getString("NguoiDungId"));
                dh.setTrangThai(rs.getBoolean("TrangThai"));
                dh.setCreated_at(rs.getString("created_at"));
                dh.setUpdate_at(rs.getString("update_at"));
          
                ldh.add(dh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ldh;
    }

    public boolean addData(DonHang dh) {
        Connection cn = DBConnect.getConnection();
        String sql = "insert into DonHang(TrangThai,created_at,update_at) values (?,?,?)";
        List<DonHang> ldh = new ArrayList<>();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String time = dateFormat.format(cal.getTime());
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, dh.isTrangThai());
            pstm.setObject(2, time);
            pstm.setObject(3, time);;
            int result = pstm.executeUpdate();
            if(result !=1)
            {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean thaydoiSoLuong(int maDon,int soLuong,float thanhtien){
          Connection cn = DBConnect.getConnection();
        String sql = "update DonHang set SoLuong = ?,ThanhTien = ? where DonHangId = ?";
        List<DonHang> ldh = new ArrayList<>();
        try {
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, soLuong);
           pstm.setObject(2, thanhtien);
           pstm.setObject(3,maDon);
            int result = pstm.executeUpdate();
            if(result !=1)
            {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean thayDoiTrangThai(boolean trangthai,int donhangid){
        Connection cn = DBConnect.getConnection();
        String sql = "update DonHang set TrangThai = ? where DonHangId = ?";
        List<DonHang> ldh = new ArrayList<>();
        try {
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, trangthai);
           pstm.setObject(2, donhangid);
            int result = pstm.executeUpdate();
            if(result !=1)
            {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public List<DonHang> getDataFollowDonHangId(int donhangid) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from DonHang where DonHangId = ?";
        List<DonHang> ldh = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, donhangid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DonHang dh = new DonHang();
   
                dh.setDonHangId(rs.getInt("DonHangId"));
                dh.setNguoiDungId(rs.getString("NguoiDungId"));
                dh.setTrangThai(rs.getBoolean("TrangThai"));
                dh.setCreated_at(rs.getString("created_at"));
                dh.setUpdate_at(rs.getString("update_at"));
          
                ldh.add(dh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ldh;
    }
      public List<DonHang> getDataFollowTrangThai() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from DonHang where TrangThai = ?";
        List<DonHang> ldh = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, false);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DonHang dh = new DonHang();
   
                dh.setDonHangId(rs.getInt("DonHangId"));
                dh.setNguoiDungId(rs.getString("NguoiDungId"));
                dh.setTrangThai(rs.getBoolean("TrangThai"));
                dh.setCreated_at(rs.getString("created_at"));
                dh.setUpdate_at(rs.getString("update_at"));
          
                ldh.add(dh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ldh;
    }
}
