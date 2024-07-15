/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.SanPham;
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
public class SanPhamService {

    public List<SanPham> getDataSanPham() {
        Connection cn = DBConnect.getConnection();
        String sql = "Select * from SanPham";
        List<SanPham> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();
                SanPham sp = new SanPham();
                sp.setSanPhamId(rs.getInt("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
    
    public List<SanPham> getDataSanPhamFollowId(int spid) {
        Connection cn = DBConnect.getConnection();
        String sql = "Select * from SanPham where SanPhamId = ?";
        List<SanPham> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, spid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();
                SanPham sp = new SanPham();
                sp.setSanPhamId(rs.getInt("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
    public boolean addSanPham(SanPham sp) {
        Connection cn = DBConnect.getConnection();
        String sql = "insert into SanPham(TenSanPham,PhanLoai,created_at,update_at) values\n"
                + "(?,?,?,?)";
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String time = dateFormat.format(cal.getTime());
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, sp.getTenSanPham());
            pstm.setObject(2, sp.getPhanLoai());
            pstm.setObject(3, time);
            pstm.setObject(4, time);
            int result = pstm.executeUpdate();
            if (result != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public SanPham findDataSanPham(int masp) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPham where SanPhamId like ?";
        SanPham sp = new SanPham();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, masp);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                sp.setSanPhamId(rs.getInt("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sp;
    }
    
        public List<SanPham> searchDataSanPham(String tensp) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPham where SanPhamId = ? or TenSanPham like ?";
        List<SanPham> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            try{
                int masp = Integer.parseInt(tensp);
                pstm.setObject(1, masp);
            }catch(Exception e)
            {
                 pstm.setObject(1, 0);
            }
            
            pstm.setObject(2,'%'+ tensp+'%');
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setSanPhamId(rs.getInt("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
        
            public List<SanPham> searchDataSanPhamFollowPhanLoai(String phanloai) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPham where PhanLoai = ?";
        List<SanPham> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, phanloai);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setSanPhamId(rs.getInt("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
        public boolean suaSanPham(SanPham sp) {
        Connection cn = DBConnect.getConnection();
        String sql = "update SanPham set TenSanPham = ?,PhanLoai=?,update_at=? where SanPhamId = ?";
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String time = dateFormat.format(cal.getTime());
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, sp.getTenSanPham());
            pstm.setObject(2, sp.getPhanLoai());
            pstm.setObject(3, time);
            pstm.setObject(4, sp.getSanPhamId());
            int result = pstm.executeUpdate();
            if (result != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
        public boolean checkRong(String data)
        {
         if(data.isEmpty() || data.length() < 1)
         {
             return false;
         }
         return true;
        }
        
        public boolean checkInt(String data)
        {
            try{
                int dataInt = Integer.parseInt(data);
                if(dataInt < 0)
                {
                    return false;
                }
                return true;
            }catch(NumberFormatException e)
            {
                System.out.println(e);
                return false;
            }
        }
        
}
