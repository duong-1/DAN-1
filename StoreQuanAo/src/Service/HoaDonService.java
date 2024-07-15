/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import model.HoaDon;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class HoaDonService {

    public boolean addData(HoaDon hd) {
        Connection cn = DBConnect.getConnection();
        String sql = "insert into HoaDon(PhuongThucThanhToanId,TongTien,TrangThai,created_at,update_at,TrangThaiHienThi,NguoiTao) values (?,?,?,?,?,?,?)";
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String time = dateFormat.format(cal.getTime());
            PreparedStatement pstm = cn.prepareStatement(sql);
//            pstm.setObject(1, hd.getDonHangId());
            pstm.setObject(1, hd.getPhuongThucThanhToanId());
            pstm.setObject(2, hd.getTongTien());
            pstm.setObject(3, hd.isTrangThai());
//            pstm.setObject(4, hd.getKhachHangId());
            pstm.setObject(4, time);
            pstm.setObject(5, time);
            pstm.setObject(6, hd.isTrangThaiHienThi());
            pstm.setObject(7, hd.getNguoiTao());
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

    public List<HoaDon> showDataHoaDonWithKhachHang() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from HoaDon inner join KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setDonHangId(rs.getInt("DonHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setHoTenKhachHang(rs.getString("HoTen"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }

    public List<HoaDon> showDataHoaDon() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from HoaDon where TrangThai = 0 and TrangThaiHienThi = 1";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setNguoiTao(rs.getString("NguoiTao"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }

    public List<HoaDon> showDataHoaDonFollowHoaDonId(int hoadonid) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from HoaDon inner join KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId where donhangid = ?";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, hoadonid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setDonHangId(rs.getInt("DonHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setHoTenKhachHang(rs.getString("HoTen"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }

    public boolean ThanhToanHoaDon(HoaDon hd) {

        Connection cn = DBConnect.getConnection();
        String sql = "update HoaDon set TrangThai = 1,PhuongThucThanhToanId = ?,TenKhachHang = ?,KhachHangId = ?,TongTien = ?,NguoiTao = ?,KhuyenMaiId = ? where HoaDonId = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, hd.getPhuongThucThanhToanId());
            pstm.setObject(2, hd.getHoTenKhachHang());
            pstm.setObject(3, hd.getKhachHangId());
            pstm.setObject(4, hd.getTongTien());
            pstm.setObject(5, hd.getNguoiTao());
            if (hd.getKhuyenMaiId() != 0) {
                pstm.setObject(6, hd.getKhuyenMaiId());
            } else {
                pstm.setObject(6, null);
            }
            pstm.setObject(7, hd.getHoaDonId());
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

    public boolean HuyHoaDon(int hoadonid) {

        Connection cn = DBConnect.getConnection();
        String sql = "update HoaDon set TrangThaiHienThi = 0 where HoaDonId = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, hoadonid);
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

    public List<HoaDon> showDataHoaDonQLHoaDon() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n"
                + "inner join   KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId ORDER BY HoaDonId DESC";
//        String sql = "select * from HoaDon";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTrangThaiHienThi(rs.getBoolean("TrangThaiHienThi"));
                hd.setTenPhuongThuc(rs.getString("TenPhuongThuc"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }

    public List<HoaDon> dataHoaDonPhanTrang(int offset, int fetch) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n"
                + "inner join KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId inner join NguoiDung on HoaDon.NguoiTao = NguoiDung.NguoiDungId ORDER BY HoaDonId DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
//        String sql = "select * from HoaDon";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, offset);
            pstm.setObject(2, fetch);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTrangThaiHienThi(rs.getBoolean("TrangThaiHienThi"));
                hd.setTenPhuongThuc(rs.getString("TenPhuongThuc"));
                hd.setNguoiTao(rs.getString("NguoiDungId"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }

    public int countDataHoaDon() {
        Connection cn = DBConnect.getConnection();
        String sql = "select count(*) from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n"
                + "inner join   KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId";
        int count = 0;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public List<HoaDon> showDataHoaDonQLHoaDonFollowTTTT(boolean trangthai) {
        Connection cn = DBConnect.getConnection();
//        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n";
//                + "inner join   KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId";
        String sql = "select * from HoaDon where TrangThai = ?";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, trangthai);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTrangThaiHienThi(rs.getBoolean("TrangThaiHienThi"));
//                hd.setTenPhuongThuc(rs.getString("TenPhuongThuc"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }

    public List<HoaDon> showDataHoaDonQLHoaDonFollowPTTT(String pt) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n"
                + "inner join   KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId inner join NguoiDung on HoaDon.NguoiTao = NguoiDung.NguoiDungId where PhuongThucThanhToanId = ?";
//        String sql = "select * from HoaDon ";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, pt);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTrangThaiHienThi(rs.getBoolean("TrangThaiHienThi"));
                hd.setTenPhuongThuc(rs.getString("TenPhuongThuc"));
                hd.setNguoiTao(rs.getString("NguoiTao"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }
    
     public List<HoaDon> showDataHoaDonQLHoaDonFollowNguoiTao(String nguoitao) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n"
                + "inner join   KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId inner join NguoiDung on HoaDon.NguoiTao = NguoiDung.NguoiDungId where HoaDon.NguoiTao like ?";
//        String sql = "select * from HoaDon ";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1,"%"+ nguoitao +"%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTrangThaiHienThi(rs.getBoolean("TrangThaiHienThi"));
                hd.setTenPhuongThuc(rs.getString("TenPhuongThuc"));
                hd.setNguoiTao(rs.getString("NguoiTao"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }

//    public List<HoaDon> showDataHoaDonQLHoaDonFollowTTHD(boolean pt) {
//        Connection cn = DBConnect.getConnection();
////        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n";
////                + "inner join   KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId";
//        String sql = "select * from HoaDon where TrangThaiHienThi = ?";
//        List<HoaDon> lhd = new ArrayList<>();
//        try {
//            PreparedStatement pstm = cn.prepareStatement(sql);
//            pstm.setObject(1, pt);
//            ResultSet rs = pstm.executeQuery();
//            while (rs.next()) {
//                HoaDon hd = new HoaDon();
//                hd.setHoaDonId(rs.getInt("HoaDonId"));
//                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
//                hd.setTongTien(rs.getFloat("TongTien"));
//                hd.setTrangThai(rs.getBoolean("TrangThai"));
//                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
//                hd.setKhachHangId(rs.getInt("KhachHangId"));
//                hd.setCreated_at(rs.getString("created_at"));
//                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
//                hd.setTrangThaiHienThi(rs.getBoolean("TrangThaiHienThi"));
////                hd.setTenPhuongThuc(rs.getString("TenPhuongThuc"));
//                lhd.add(hd);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return lhd;
//    }

    public List<HoaDon> showDataHoaDonQLHoaDonFollowDateTime(String ngaybatdau, String ngayketthuc, int offset, int fetch) {
        Connection cn = DBConnect.getConnection();
//        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n";
//                + "inner join   KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId";
        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n"
                + "inner join   KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId inner join NguoiDung on HoaDon.NguoiTao = NguoiDung.NguoiDungId where created_at BETWEEN CAST(? AS DATETIME) AND CAST(? AS DATETIME) ORDER BY HoaDonId DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, ngaybatdau);
            pstm.setObject(2, ngayketthuc);
            pstm.setObject(3, offset);
            pstm.setObject(4, fetch);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTrangThaiHienThi(rs.getBoolean("TrangThaiHienThi"));
                hd.setTenPhuongThuc(rs.getString("TenPhuongThuc"));
                hd.setNguoiTao(rs.getString("NguoiTao"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }

    public List<HoaDon> showDataHoaDonQLHoaDonFollowKhachHangId(int khachhangid) {
        Connection cn = DBConnect.getConnection();
//        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n";
//                + "inner join   KhachHang on HoaDon.KhachHangId = KhachHang.KhachHangId";
        String sql = "select * from HoaDon inner join PhuongThucThanhToan on HoaDon.PhuongThucThanhToanId = PhuongThucThanhToan.id\n"
                + "where KhachHangId = ?";
        List<HoaDon> lhd = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, khachhangid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setHoaDonId(rs.getInt("HoaDonId"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setPhuongThucThanhToanId(rs.getString("PhuongThucThanhToanId"));
                hd.setKhachHangId(rs.getInt("KhachHangId"));
                hd.setCreated_at(rs.getString("created_at"));
                hd.setHoTenKhachHang(rs.getString("TenKhachHang"));
                hd.setTrangThaiHienThi(rs.getBoolean("TrangThaiHienThi"));
                hd.setTenPhuongThuc(rs.getString("TenPhuongThuc"));
                hd.setNguoiTao(rs.getString("NguoiTao"));
                lhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lhd;
    }
}
