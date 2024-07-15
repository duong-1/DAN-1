/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.NguoiDung;
import java.sql.*;
import java.util.ArrayList;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class LoginService {

    public List<NguoiDung> getDataLogin() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from NguoiDung inner join QuyenHan on NguoiDung.NguoiDungId = QuyenHan.NguoiDungId";
        List<NguoiDung> lnd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setIdNguoiDung(rs.getString("NguoiDungId"));
                nd.setHoten(rs.getString("HoTen"));
                nd.setMatkhau(rs.getString("MatKhau"));
                nd.setRole(rs.getString("TenQuyen"));
                nd.setGioiTinh(rs.getBoolean("GioiTinh"));
                nd.setDiachi(rs.getString("DiaChi"));
                nd.setEmail(rs.getString("Email"));
                nd.setPhone(rs.getString("Phone"));
                nd.setNgaysinh(rs.getString("NgaySinh"));
                lnd.add(nd);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return lnd;
    }

    public boolean addDataLogin(NguoiDung nd) {
        Connection cn = DBConnect.getConnection();
        String sql = "  insert into NguoiDung(NguoiDungId,HoTen,NgaySinh,MatKhau,Phone,GioiTinh,DiaChi,Email) values (?,?,?,?,?,?,?,?)";
        List<NguoiDung> lnd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, nd.getIdNguoiDung());
            pstm.setObject(2, nd.getHoten());
            pstm.setObject(3, nd.getNgaysinh());
            pstm.setObject(4, nd.getMatkhau());
            pstm.setObject(5, nd.getPhone());
            pstm.setObject(6, nd.isGioiTinh());
            pstm.setObject(7, nd.getDiachi());
            pstm.setObject(8, nd.getEmail());
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

    public boolean updateDataLogin(NguoiDung nd) {
        Connection cn = DBConnect.getConnection();
        String sql = " update NguoiDung set HoTen = ?,NgaySinh = ?,MatKhau = ?,Phone = ?,GioiTinh = ?,DiaChi = ?,Email = ? where NguoiDungId = ?";
        List<NguoiDung> lnd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, nd.getHoten());
            pstm.setObject(2, nd.getNgaysinh());
            pstm.setObject(3, nd.getMatkhau());
            pstm.setObject(4, nd.getPhone());
            pstm.setObject(5, nd.isGioiTinh());
            pstm.setObject(6, nd.getDiachi());
            pstm.setObject(7, nd.getEmail());
            pstm.setObject(8, nd.getIdNguoiDung());
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

    public boolean updateQuyenHan(String ndid, String tenq) {
        Connection cn = DBConnect.getConnection();
        String sql = " update QuyenHan set TenQuyen = ? where NguoiDungId = ?";
        List<NguoiDung> lnd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, tenq);
            pstm.setObject(2, ndid);
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

    public List<NguoiDung> getDataLoginFollowNameOrId(String payload) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from NguoiDung inner join QuyenHan on NguoiDung.NguoiDungId = QuyenHan.NguoiDungId where NguoiDung.NguoiDungId = ? or NguoiDung.HoTen like ?";
        List<NguoiDung> lnd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, payload);
            pstm.setObject(2, '%' + payload + '%');
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setIdNguoiDung(rs.getString("NguoiDungId"));
                nd.setHoten(rs.getString("HoTen"));
                nd.setMatkhau(rs.getString("MatKhau"));
                nd.setRole(rs.getString("TenQuyen"));
                nd.setGioiTinh(rs.getBoolean("GioiTinh"));
                nd.setDiachi(rs.getString("DiaChi"));
                nd.setEmail(rs.getString("Email"));
                nd.setPhone(rs.getString("Phone"));
                nd.setNgaysinh(rs.getString("NgaySinh"));
                lnd.add(nd);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return lnd;
    }

    public NguoiDung findDataNguoiDungId(String payload) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from NguoiDung inner join QuyenHan on NguoiDung.NguoiDungId = QuyenHan.NguoiDungId where NguoiDung.NguoiDungId = ?";
        NguoiDung nd = new NguoiDung();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, payload);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                nd.setIdNguoiDung(rs.getString("NguoiDungId"));
                nd.setHoten(rs.getString("HoTen"));
                nd.setMatkhau(rs.getString("MatKhau"));
                nd.setRole(rs.getString("TenQuyen"));
                nd.setGioiTinh(rs.getBoolean("GioiTinh"));
                nd.setDiachi(rs.getString("DiaChi"));
                nd.setEmail(rs.getString("Email"));
                nd.setPhone(rs.getString("Phone"));
                nd.setNgaysinh(rs.getString("NgaySinh"));

            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return nd;
    }

    public List<NguoiDung> getDataLoginFollowGioiTinh(boolean payload) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from NguoiDung inner join QuyenHan on NguoiDung.NguoiDungId = QuyenHan.NguoiDungId where NguoiDung.GioiTinh = ?";
        List<NguoiDung> lnd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, payload);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setIdNguoiDung(rs.getString("NguoiDungId"));
                nd.setHoten(rs.getString("HoTen"));
                nd.setMatkhau(rs.getString("MatKhau"));
                nd.setRole(rs.getString("TenQuyen"));
                nd.setGioiTinh(rs.getBoolean("GioiTinh"));
                nd.setDiachi(rs.getString("DiaChi"));
                nd.setEmail(rs.getString("Email"));
                nd.setPhone(rs.getString("Phone"));
                nd.setNgaysinh(rs.getString("NgaySinh"));
                lnd.add(nd);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return lnd;
    }

    public List<NguoiDung> getDataLoginFollowQuyenHan(String payload) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from NguoiDung inner join QuyenHan on NguoiDung.NguoiDungId = QuyenHan.NguoiDungId where QuyenHan.TenQuyen = ?";
        List<NguoiDung> lnd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, payload);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setIdNguoiDung(rs.getString("NguoiDungId"));
                nd.setHoten(rs.getString("HoTen"));
                nd.setMatkhau(rs.getString("MatKhau"));
                nd.setRole(rs.getString("TenQuyen"));
                nd.setGioiTinh(rs.getBoolean("GioiTinh"));
                nd.setDiachi(rs.getString("DiaChi"));
                nd.setEmail(rs.getString("Email"));
                nd.setPhone(rs.getString("Phone"));
                nd.setNgaysinh(rs.getString("NgaySinh"));
                lnd.add(nd);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return lnd;
    }
}
