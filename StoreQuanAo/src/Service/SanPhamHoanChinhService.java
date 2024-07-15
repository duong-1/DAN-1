/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.SanPhamHoanChinh;
import java.sql.*;
import java.util.ArrayList;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class SanPhamHoanChinhService {

    public List<SanPhamHoanChinh> getData() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }

    public List<SanPhamHoanChinh> getDataDisable() {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 0";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }

    public List<SanPhamHoanChinh> getDataSearch(String tensanpham) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and SanPham.TenSanPham like ? or SanPham.SanPhamId = ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, '%' + tensanpham + '%');
            try{
                int sanphamid = Integer.parseInt(tensanpham);
                pstm.setObject(2, sanphamid);
            }catch(Exception e)
            {
                pstm.setObject(2, 0);
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
    
      public List<SanPhamHoanChinh> getDataSearchSPHC(String tensanpham) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and SanPham.TenSanPham like ? or SanPhamSanPhamChiTiet.SanPhamChiTietId = ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, '%' + tensanpham + '%');
            try{
                int sanphamid = Integer.parseInt(tensanpham);
                pstm.setObject(2, sanphamid);
            }catch(Exception e)
            {
                pstm.setObject(2, 0);
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
    
       public List<SanPhamHoanChinh> getDataSearchAndId(String tensanpham,int sanphamid1) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and SanPham.TenSanPham like ? and SanPham.SanPhamId like ? or SanPham.SanPhamId = ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, '%' + tensanpham + '%');
            pstm.setObject(2, sanphamid1);
            try{
                int sanphamid = Integer.parseInt(tensanpham);
                pstm.setObject(3, sanphamid);
            }catch(Exception e)
            {
                pstm.setObject(3, 0);
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
    
     public List<SanPhamHoanChinh> getDataPhanLoai(String phanloai) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and SanPham.PhanLoai like ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, '%' + phanloai + '%');
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
       public List<SanPhamHoanChinh> getDataPhanLoaiAndId(String phanloai,int sanphamid) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and SanPham.PhanLoai like ? and SanPham.SanPhamId like ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, '%' + phanloai + '%');
            pstm.setObject(2, sanphamid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
     public List<SanPhamHoanChinh> getDataMauSac(String mausac) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and MauSac.TenMauSac like ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, '%' + mausac + '%');
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
     
     public List<SanPhamHoanChinh> getDataMauSacAndId(String mausac,int sanphamid) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and MauSac.TenMauSac like ? and SanPham.SanPhamId like ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, '%' + mausac + '%');
            pstm.setObject(2, sanphamid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
     
     public List<SanPhamHoanChinh> getDataHang(String mausac) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and Hang.TenHang like ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, '%' + mausac + '%');
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
     public List<SanPhamHoanChinh> getDataHangAndId(String mausac,int sanphamid) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and Hang.TenHang like ? and SanPham.SanPhamId like ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, '%' + mausac + '%');
            pstm.setObject(2,sanphamid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
    public List<SanPhamHoanChinh> getDataFollowId(int SanPhamId) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and SanPham.SanPhamId = ?";
        List<SanPhamHoanChinh> lsp = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, SanPhamId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 SanPhamHoanChinh sp = new SanPhamHoanChinh();
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                lsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsp;
    }
    
     public SanPhamHoanChinh findDataFollowId(int SanPhamId, int sanphamchitietid) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and SanPham.SanPhamId = ? and SanPhamChiTiet.Id = ?";
        SanPhamHoanChinh sp = new SanPhamHoanChinh();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, SanPhamId);
            pstm.setObject(2, sanphamchitietid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sp;
    }
     
      public SanPhamHoanChinh findDataFollowSanPhamSanPhamChiTietId(int sanphamsanphamchitietid) {
        Connection cn = DBConnect.getConnection();
        String sql = "select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId\n"
                + "inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId\n"
                + "inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId\n"
                + "inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId\n"
                + "inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId\n"
                + "inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1 and SanPhamSanPhamChiTiet.SanPhamSanPhamChiTietId = ?";
        SanPhamHoanChinh sp = new SanPhamHoanChinh();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, sanphamsanphamchitietid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();

                 
                sp.setSanPhamId(rs.getString("SanPhamId"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSanPhamChiTietId(rs.getString("SanPhamChiTietId"));
                sp.setCreate_at(rs.getString("created_at"));
                sp.setUpdate_at(rs.getString("update_at"));
                sp.setChiTietSanPhamid(rs.getString("Id"));
                sp.setGiaTien(rs.getFloat("GiaTien"));
                sp.setMoTaChitiet(null);
                sp.setMoTaSoBo(null);
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMauSacId(rs.getInt("MauSacId"));
                sp.setKichThuocId(rs.getInt("KichThuocId"));
                sp.setChatLieuId(rs.getInt("ChatLieuId"));
                sp.setHangId(rs.getInt("HangId"));
                sp.setThuocTinhId(rs.getString("id"));
                sp.setHang(rs.getString("TenHang"));
                sp.setKichThuoc(rs.getString("TenKichThuoc"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setAnh(rs.getString("Anh"));
                sp.setSanPhamSanPhamChiTetId(rs.getInt("SanPhamSanPhamChiTietId"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sp;
    }
}
