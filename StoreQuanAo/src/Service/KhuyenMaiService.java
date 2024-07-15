/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import model.KhuyenMai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class KhuyenMaiService {

    public boolean addDataKhuyenMai(KhuyenMai km) {
        Connection cn = DBConnect.getConnection();
        String sql = "insert into KhuyenMai(MaKhuyenMai,TenChuongTrinhKhuyenMai,HinhThucGiamGia,MucGiamGia,SoLuong,ThoiGianBatDau,ThoiGianKetThuc,TrangThai) \n"
                + "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, km.getMaKhuyenMai());
            pstm.setObject(2, km.getTenChuongTrinhKhuyenMai());
            pstm.setObject(3, km.isHinhThucGiamGia());
            pstm.setObject(4, km.getMucGiamGia());
            pstm.setObject(5, km.getSoluongma());
            pstm.setObject(6, km.getNgaybatdau());
            pstm.setObject(7, km.getNgayketthuc());
            pstm.setObject(8, km.isTrangThaiMa());
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

    public boolean updateSoLuongKhuyenMai(int soluong, int khuyenmaiid) {
        Connection cn = DBConnect.getConnection();
        String sql = "  update KhuyenMai set SoLuong = ? where KhuyenMaiId = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, soluong);
            pstm.setObject(2, khuyenmaiid);
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

    public boolean updateDataKhuyenMai(KhuyenMai km) {
        Connection cn = DBConnect.getConnection();
        String sql = "  update KhuyenMai set SoLuong = ?,TenChuongTrinhKhuyenMai = ?,MaKhuyenMai = ?,HinhThucGiamGia = ?,MucGiamGia = ?,ThoiGianBatDau = ?,ThoiGianKetThuc = ? where KhuyenMaiId = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, km.getSoluongma());
            pstm.setObject(2, km.getTenChuongTrinhKhuyenMai());
            pstm.setObject(3, km.getMaKhuyenMai());
            pstm.setObject(4, km.isHinhThucGiamGia());
            pstm.setObject(5, km.getMucGiamGia());
            pstm.setObject(6, km.getNgaybatdau());
            pstm.setObject(7, km.getNgayketthuc());
            pstm.setObject(8, km.getKhuyenMaiId());
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

    public KhuyenMai findDataKhuyenMai(String makhuyenmai) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from KhuyenMai where MaKhuyenMai = ?";
        KhuyenMai km = new KhuyenMai();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, makhuyenmai);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                km.setKhuyenMaiId(rs.getInt("KhuyenMaiId"));
                km.setTenChuongTrinhKhuyenMai(rs.getString("TenChuongTrinhKhuyenMai"));
                km.setMaKhuyenMai(rs.getString("MaKhuyenMai"));
                km.setHinhThucGiamGia(rs.getBoolean("HinhThucGiamGia"));
                km.setMucGiamGia(rs.getString("MucGiamGia"));
                km.setSoluongma(rs.getInt("SoLuong"));
                km.setNgaybatdau(rs.getString("ThoiGianBatDau"));
                km.setNgayketthuc(rs.getString("ThoiGianKetThuc"));
                km.setTrangThaiMa(rs.getBoolean("TrangThai"));
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return km;
    }

    public List<KhuyenMai> getDataKhuyenMai() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from KhuyenMai";
        List<KhuyenMai> lkm = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setKhuyenMaiId(rs.getInt("KhuyenMaiId"));
                km.setTenChuongTrinhKhuyenMai(rs.getString("TenChuongTrinhKhuyenMai"));
                km.setMaKhuyenMai(rs.getString("MaKhuyenMai"));
                km.setHinhThucGiamGia(rs.getBoolean("HinhThucGiamGia"));
                km.setMucGiamGia(rs.getString("MucGiamGia"));
                km.setSoluongma(rs.getInt("SoLuong"));
                km.setNgaybatdau(rs.getString("ThoiGianBatDau"));
                km.setNgayketthuc(rs.getString("ThoiGianKetThuc"));
                km.setTrangThaiMa(rs.getBoolean("TrangThai"));
                lkm.add(km);
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return lkm;
    }
}
