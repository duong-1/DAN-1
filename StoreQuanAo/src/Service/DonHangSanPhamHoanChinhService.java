/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.DonHangSanPhamHoanChinh;
import java.sql.*;
import java.util.ArrayList;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class DonHangSanPhamHoanChinhService {

    public List<DonHangSanPhamHoanChinh> getData() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamDonHang\n"
                + "inner join SanPhamSanPhamChiTiet on SanPhamDonHang.SanPhamSanPhamChiTietId = SanPhamSanPhamChiTiet.SanPhamSanPhamChiTietId\n"
                + "inner join HoaDon on HoaDon.HoaDonId = SanPhamDonHang.HoaDonId\n"
                + "inner join SanPhamChiTiet on SanPhamSanPhamChiTiet.SanPhamChiTietId = SanPhamChiTiet.Id\n"
                + "inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId";
        List<DonHangSanPhamHoanChinh> ldhsphc = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DonHangSanPhamHoanChinh dhsphc = new DonHangSanPhamHoanChinh();
                dhsphc.setSanPhamId(rs.getInt("SanPhamId"));
                dhsphc.setGiaTien(rs.getFloat("GiaTien"));
                dhsphc.setHoaDonId(rs.getInt("HoaDonId"));
                dhsphc.setPhanLoai(rs.getString("PhanLoai"));
                dhsphc.setMausac(rs.getString("TenMauSac"));
                dhsphc.setChatlieu(rs.getString("TenChatLieu"));
                dhsphc.setNguoiDungId(rs.getString("NguoiDungId"));
                dhsphc.setSoLuong(rs.getInt(3));
                dhsphc.setSoLuongSanPhamGoc(rs.getInt(26));
                dhsphc.setTenSanPham(rs.getString("TenSanPham"));
                dhsphc.setTrangThaiDonHang(rs.getBoolean("TrangThai"));
                dhsphc.setChiTietSanPhamId(rs.getInt("SanPhamChiTietId"));
                dhsphc.setKichThuoc(rs.getString("TenKichThuoc"));
                ldhsphc.add(dhsphc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ldhsphc;
    }

//     public List<DonHangSanPhamHoanChinh> getDataFollowDonHangId(int donhangid){
//        Connection cn = DBConnect.getConnection();
//        String sql = "select * from SanPhamDonHang\n" +
//"inner join SanPhamSanPhamChiTiet on SanPhamDonHang.SanPhamSanPhamChiTietId = SanPhamSanPhamChiTiet.SanPhamSanPhamChiTietId\n" +
//"inner join DonHang on DonHang.DonHangId = SanPhamDonHang.DonHangId\n" +
//"inner join SanPhamChiTiet on SanPhamSanPhamChiTiet.SanPhamChiTietId = SanPhamChiTiet.Id\n" +
//"inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n" +
//"inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n" +
//"inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n" +
//"inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n" +
//"inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamDonHang.DonHangId = ?";
//        List<DonHangSanPhamHoanChinh> ldhsphc = new ArrayList<>();
//        try{
//            PreparedStatement pstm = cn.prepareStatement(sql);
//            pstm.setObject(1, donhangid);
//            ResultSet rs = pstm.executeQuery();
//            while(rs.next())
//            {
//             DonHangSanPhamHoanChinh dhsphc = new DonHangSanPhamHoanChinh();
//             dhsphc.setSanPhamId(rs.getInt("SanPhamId"));
//             dhsphc.setGiaTien(rs.getFloat("GiaTien"));
//             dhsphc.setDonHangId(rs.getInt("DonHangId"));
//             dhsphc.setPhanLoai(rs.getString("PhanLoai"));
//             dhsphc.setNguoiDungId(rs.getString("NguoiDungId"));
//             dhsphc.setSoLuong(rs.getInt("SoLuong"));
//             dhsphc.setTenSanPham(rs.getString("TenSanPham"));
//             dhsphc.setTrangThaiDonHang(rs.getBoolean(10));
//             dhsphc.setChiTietSanPhamId(rs.getInt("SanPhamChiTietId"));
//             dhsphc.setKichThuoc(rs.getString("TenKichThuoc"));
//             dhsphc.setSanPhamSanPhamChiTietId(rs.getInt("SanPhamSanPhamChiTietId"));
//             ldhsphc.add(dhsphc);
//            }
//        }catch(Exception e)
//        {
//            System.out.println(e);
//        }
//        return ldhsphc;
//    }
    public List<DonHangSanPhamHoanChinh> getDataHoaDon() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamDonHang\n"
                + "inner join SanPhamSanPhamChiTiet on SanPhamDonHang.SanPhamSanPhamChiTietId = SanPhamSanPhamChiTiet.SanPhamSanPhamChiTietId\n"
                + "inner join HoaDon on HoaDon.HoaDonId = SanPhamDonHang.HoaDonId\n"
                + "inner join SanPhamChiTiet on SanPhamSanPhamChiTiet.SanPhamChiTietId = SanPhamChiTiet.Id\n"
                + "inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId";
        List<DonHangSanPhamHoanChinh> ldhsphc = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DonHangSanPhamHoanChinh dhsphc = new DonHangSanPhamHoanChinh();
                dhsphc.setSanPhamId(rs.getInt("SanPhamId"));
                dhsphc.setGiaTien(rs.getFloat("GiaTien"));
                dhsphc.setHoaDonId(rs.getInt("HoaDonId"));
                dhsphc.setPhanLoai(rs.getString("PhanLoai"));
                dhsphc.setMausac(rs.getString("TenMauSac"));
                dhsphc.setChatlieu(rs.getString("TenChatLieu"));
//             dhsphc.setNguoiDungId(rs.getString("NguoiDungId"));
                dhsphc.setSoLuongSanPhamGoc(rs.getInt(26));
                dhsphc.setSoLuong(rs.getInt(3));
                dhsphc.setTenSanPham(rs.getString("TenSanPham"));
                dhsphc.setTrangThaiDonHang(rs.getBoolean(13));
                dhsphc.setChiTietSanPhamId(rs.getInt("SanPhamChiTietId"));
                dhsphc.setKichThuoc(rs.getString("TenKichThuoc"));
                dhsphc.setSanPhamSanPhamChiTietId(rs.getInt("SanPhamSanPhamChiTietId"));
                ldhsphc.add(dhsphc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ldhsphc;
    }

    public List<DonHangSanPhamHoanChinh> getDataHoaDonFollowId(int hoadonid) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamDonHang\n"
                + "inner join SanPhamSanPhamChiTiet on SanPhamDonHang.SanPhamSanPhamChiTietId = SanPhamSanPhamChiTiet.SanPhamSanPhamChiTietId\n"
                + "inner join HoaDon on HoaDon.HoaDonId = SanPhamDonHang.HoaDonId\n"
                + "inner join SanPhamChiTiet on SanPhamSanPhamChiTiet.SanPhamChiTietId = SanPhamChiTiet.Id\n"
                + "inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where HoaDon.HoaDonId = ?";
        List<DonHangSanPhamHoanChinh> ldhsphc = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, hoadonid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DonHangSanPhamHoanChinh dhsphc = new DonHangSanPhamHoanChinh();
                dhsphc.setSanPhamId(rs.getInt("SanPhamId"));
                dhsphc.setGiaTien(rs.getFloat("GiaTien"));
                dhsphc.setHoaDonId(rs.getInt("HoaDonId"));
                dhsphc.setPhanLoai(rs.getString("PhanLoai"));
//             dhsphc.setNguoiDungId(rs.getString("NguoiDungId"));
                dhsphc.setMausac(rs.getString("TenMauSac"));
                dhsphc.setChatlieu(rs.getString("TenChatLieu"));
                dhsphc.setSoLuong(rs.getInt(3));
                dhsphc.setTenSanPham(rs.getString("TenSanPham"));
                dhsphc.setTrangThaiDonHang(rs.getBoolean(13));
                dhsphc.setChiTietSanPhamId(rs.getInt("SanPhamChiTietId"));
                dhsphc.setKichThuoc(rs.getString("TenKichThuoc"));
                dhsphc.setSoLuongSanPhamGoc(rs.getInt(26));
                dhsphc.setSanPhamSanPhamChiTietId(rs.getInt("SanPhamSanPhamChiTietId"));
                ldhsphc.add(dhsphc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ldhsphc;
    }

    public DonHangSanPhamHoanChinh findDataHoaDonFollowIdandSanPhamSPCT(int hoadonid, int sanphamsanphamchitietid) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamDonHang\n"
                + "inner join SanPhamSanPhamChiTiet on SanPhamDonHang.SanPhamSanPhamChiTietId = SanPhamSanPhamChiTiet.SanPhamSanPhamChiTietId\n"
                + "inner join HoaDon on HoaDon.HoaDonId = SanPhamDonHang.HoaDonId\n"
                + "inner join SanPhamChiTiet on SanPhamSanPhamChiTiet.SanPhamChiTietId = SanPhamChiTiet.Id\n"
                + "inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where HoaDon.HoaDonId = ? and SanPhamSanPhamChiTiet.SanPhamSanPhamChiTietId = ?";
        DonHangSanPhamHoanChinh dhsphc = new DonHangSanPhamHoanChinh();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, hoadonid);
            pstm.setObject(2, sanphamsanphamchitietid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                dhsphc.setSanPhamId(rs.getInt("SanPhamId"));
                dhsphc.setGiaTien(rs.getFloat("GiaTien"));
                dhsphc.setHoaDonId(rs.getInt("HoaDonId"));
                dhsphc.setPhanLoai(rs.getString("PhanLoai"));
//             dhsphc.setNguoiDungId(rs.getString("NguoiDungId"));
//25
                dhsphc.setSoLuongSanPhamGoc(rs.getInt(26));
                dhsphc.setMausac(rs.getString("TenMauSac"));
                dhsphc.setChatlieu(rs.getString("TenChatLieu"));
                dhsphc.setSoLuong(rs.getInt(3));
                dhsphc.setTenSanPham(rs.getString("TenSanPham"));
                dhsphc.setTrangThaiDonHang(rs.getBoolean(13));
                dhsphc.setChiTietSanPhamId(rs.getInt("SanPhamChiTietId"));
                dhsphc.setKichThuoc(rs.getString("TenKichThuoc"));
                dhsphc.setSanPhamSanPhamChiTietId(rs.getInt("SanPhamSanPhamChiTietId"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dhsphc;
    }
}
