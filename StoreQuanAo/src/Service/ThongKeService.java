/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ThongKe;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class ThongKeService {

    public int demSoHoaDonTheoNgay(String date) {
        Connection cn = DBConnect.getConnection();
        String sql = "  select count(*) from HoaDon where CONVERT(date,created_at) = ? and TrangThaiHienThi = 1";
        int sohoadon = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, date);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                sohoadon = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sohoadon;
    }

    public int demSoKhachHangTheoNgay(String date) {
        Connection cn = DBConnect.getConnection();
        String sql = "  select count(KhachHangId) from HoaDon where CONVERT(date,created_at) = ? and TrangThaiHienThi = 1";
        int sokhachhang = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, date);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                sokhachhang = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sokhachhang;
    }

    public float tongTienTheoNgay(String date) {
        Connection cn = DBConnect.getConnection();
        String sql = "select sum(TongTien) from HoaDon where CONVERT(date,created_at) = ? and TrangThaiHienThi = 1";
        float tongsotien = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, date);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                tongsotien = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tongsotien;
    }

    public int demSoHoaDonTheoThang(String thang) {
        Connection cn = DBConnect.getConnection();
        String sql = "  SELECT count(*) FROM HoaDon WHERE MONTH(created_at) = ? and TrangThaiHienThi = 1";
        int sohoadon = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, thang);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                sohoadon = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sohoadon;
    }

    public int demSoKhachHangTheoThang(String thang) {
        Connection cn = DBConnect.getConnection();
        String sql = "  select count(KhachHangId) from HoaDon where MONTH(created_at) = ? and TrangThaiHienThi = 1";
        int sokhachhang = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, thang);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                sokhachhang = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sokhachhang;
    }

    public float tongTienTheoThang(String thang) {
        Connection cn = DBConnect.getConnection();
        String sql = "select sum(TongTien) from HoaDon where MONTH(created_at) = ? and TrangThaiHienThi = 1";
        float tongsotien = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, thang);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                tongsotien = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tongsotien;
    }

    public int demSoHoaDonTheoNam(String nam) {
        Connection cn = DBConnect.getConnection();
        String sql = "  SELECT count(*) FROM HoaDon WHERE Year(created_at) = ? and TrangThaiHienThi = 1";
        int sohoadon = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, nam);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                sohoadon = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sohoadon;
    }

    public int demSoKhachHangTheoNam(String nam) {
        Connection cn = DBConnect.getConnection();
        String sql = "  select count(KhachHangId) from HoaDon where year(created_at) = ? and TrangThaiHienThi = 1";
        int sokhachhang = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, nam);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                sokhachhang = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sokhachhang;
    }

    public float tongTienTheoNam(String nam) {
        Connection cn = DBConnect.getConnection();
        String sql = "select sum(TongTien) from HoaDon where year(created_at) = ? and TrangThaiHienThi = 1";
        float tongsotien = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, nam);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                tongsotien = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tongsotien;
    }

    public List<ThongKe> getDataThongKe(int nam) {
        Connection cn = DBConnect.getConnection();
        String sql = "SELECT MONTH(created_at) AS Month, sum(TongTien) AS TongDoanhThu, count(KhachHangId) as TongKhachHang\n"
                + "FROM HoaDon\n"
                + "WHERE YEAR(created_at) = ? and TrangThaiHienThi = 1\n"
                + "GROUP BY MONTH(created_at)";
        List<ThongKe> ltk = new ArrayList<>();
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, nam);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                ThongKe tk = new ThongKe();
                tk.setThang(rs.getInt("Month"));
                tk.setTongdoanhthu(rs.getFloat("TongDoanhThu"));
                tk.setTongkhachhang(rs.getInt("TongKhachHang"));
                ltk.add(tk);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return ltk;
    }
}
