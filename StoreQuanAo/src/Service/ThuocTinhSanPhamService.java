/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.ThuocTinhSanPham;
import java.sql.*;
import java.util.ArrayList;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class ThuocTinhSanPhamService {

    public List<ThuocTinhSanPham> getData() {
        List<ThuocTinhSanPham> lttsp = new ArrayList<>();
        Connection cn = DBConnect.getConnection();
        String sql = "select * from ThuocTinhSanPham";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ThuocTinhSanPham ttsp = new ThuocTinhSanPham();
                ttsp.setId(rs.getString("id"));
                ttsp.setHang(rs.getString("Hang"));
                ttsp.setKichThuoc(rs.getString("KichThuoc"));
                ttsp.setMauSac(rs.getString("mausac"));
                ttsp.setChatLieu(rs.getString("chatlieu"));
                lttsp.add(ttsp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lttsp;
    }

    public boolean addData(ThuocTinhSanPham ttsp) {
        Connection cn = DBConnect.getConnection();
        String sql = "insert into ThuocTinhSanPham(id,ChatLieu,Hang,KichThuoc,MauSac) values (?,?,?,?,?)";
        try {
            PreparedStatement pstm = cn.prepareCall(sql);
            pstm.setObject(1, ttsp.getId());
            pstm.setObject(2, ttsp.getChatLieu());
            pstm.setObject(3, ttsp.getHang());
            pstm.setObject(4, ttsp.getKichThuoc());
            pstm.setObject(5, ttsp.getMauSac());
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

    public boolean updateData(ThuocTinhSanPham ttsp) {
        Connection cn = DBConnect.getConnection();
        String sql = "update ThuocTinhSanPham set ChatLieu = ?,Hang=?,MauSac = ?,KichThuoc = ? where id = ?";
        try {
            PreparedStatement pstm = cn.prepareCall(sql);
            pstm.setObject(5, ttsp.getId());
            pstm.setObject(1, ttsp.getChatLieu());
            pstm.setObject(2, ttsp.getHang());
            pstm.setObject(4, ttsp.getKichThuoc());
            pstm.setObject(3, ttsp.getMauSac());
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

    public boolean xoaData(String id) {
        Connection cn = DBConnect.getConnection();
        String sql = "delete from ThuocTinhSanPham where id = ?";
        try {
            PreparedStatement pstm = cn.prepareCall(sql);
            pstm.setObject(1, id);
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

    public ThuocTinhSanPham findData(String id) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from ThuocTinhSanPham where id like ?";
        ThuocTinhSanPham ttsp = new ThuocTinhSanPham();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ttsp.setId(rs.getString("id"));
                ttsp.setHang(rs.getString("Hang"));
                ttsp.setKichThuoc(rs.getString("KichThuoc"));
                ttsp.setMauSac(rs.getString("mausac"));
                ttsp.setChatLieu(rs.getString("chatlieu"));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return ttsp;
    }
}
