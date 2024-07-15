/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.ChiTietSanPham;
import java.sql.*;
import java.util.ArrayList;
import repository.DBConnect;
/**
 *
 * @author TB
 */
public class ChiTietSanPhamService {
    public List<ChiTietSanPham> getDataSanPham(){
        Connection cn = DBConnect.getConnection();
        String sql = "Select * from SanPhamChiTiet";
        List<ChiTietSanPham> lsp = new ArrayList<>();
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();
                ChiTietSanPham sp = new ChiTietSanPham();
               sp.setId(rs.getInt("Id"));
               sp.setGiaTien(rs.getFloat("GiaTien"));
               sp.setAnh(rs.getString("Anh"));
               sp.setMoTaChitiet(null);
               sp.setMoTaSoBo(null);
               sp.setSoLuong(rs.getInt("SoLuong"));
               sp.setTrangThai(rs.getBoolean("TrangThai"));
               sp.setMauSacId(rs.getInt("MauSacId"));
               sp.setChatLieuId(rs.getInt("ChatLieuId"));
               sp.setHangId(rs.getInt("HangId"));
               sp.setKichThuocId(rs.getInt("KichThuocId"));
                lsp.add(sp);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return lsp;
    }
    public boolean addChiTietSanPham(ChiTietSanPham ctsp){
        Connection cn = DBConnect.getConnection();
        String sql = "insert into SanPhamChiTiet(GiaTien,SoLuong,MauSacId,KichThuocId,ChatLieuId,HangId,TrangThai,MoTaSoBo,MoTaChiTiet,Anh) values \n" +
"(?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, ctsp.getGiaTien());
            pstm.setObject(2, ctsp.getSoLuong());
            pstm.setObject(3, ctsp.getMauSacId());
            pstm.setObject(4, ctsp.getKichThuocId());
            pstm.setObject(5, ctsp.getChatLieuId());
            pstm.setObject(6, ctsp.getHangId());
            pstm.setObject(7, 1);
            pstm.setObject(8, null);
            pstm.setObject(9, null);
            pstm.setObject(10, ctsp.getAnh());
            int result = pstm.executeUpdate();
            if(result != 1)
            {
                return false;
            }
            return true;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean suaChiTietSanPham(ChiTietSanPham ctsp){
        Connection cn = DBConnect.getConnection();
        String sql = "update SanPhamChiTiet set Anh = ?,GiaTien = ?,SoLuong = ?,MauSacId = ?,KichThuocId = ?,ChatLieuId = ?,HangId = ? where Id = ?";
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(2, ctsp.getGiaTien());
            pstm.setObject(3, ctsp.getSoLuong());
            pstm.setObject(4, ctsp.getMauSacId());
            pstm.setObject(5, ctsp.getKichThuocId());
            pstm.setObject(6, ctsp.getChatLieuId());
            pstm.setObject(7, ctsp.getHangId());
            pstm.setObject(1, ctsp.getAnh());
            pstm.setObject(8, ctsp.getId());
            int result = pstm.executeUpdate();
            if(result != 1)
            {
                return false;
            }
            return true;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
      public boolean updateChiTietSanPham(int soluong,int id){
        Connection cn = DBConnect.getConnection();
        String sql = "update SanPhamChiTiet set SoLuong = ? where Id = ?";
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(2, id);
            pstm.setObject(1, soluong);
       
            int result = pstm.executeUpdate();
            if(result != 1)
            {
                return false;
            }
            return true;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
     public ChiTietSanPham FindDataSanPhamChiTiet(int sanphamchitietid){
        Connection cn = DBConnect.getConnection();
        String sql = "Select * from SanPhamChiTiet where Id = ?";
        ChiTietSanPham sp = new ChiTietSanPham();
        try{
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, sanphamchitietid);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
//                Calendar dateCurent = Calendar.getInstance();
//                Date date = (Date) dateCurent.getTime();
                
               sp.setId(rs.getInt("Id"));
               sp.setGiaTien(rs.getFloat("GiaTien"));
               sp.setAnh(null);
               sp.setMoTaChitiet(null);
               sp.setMoTaSoBo(null);
               sp.setSoLuong(rs.getInt("SoLuong"));
               sp.setTrangThai(rs.getBoolean("TrangThai"));
               sp.setMauSacId(rs.getInt("MauSacId"));
               sp.setChatLieuId(rs.getInt("ChatLieuId"));
               sp.setHangId(rs.getInt("HangId"));
               sp.setKichThuocId(rs.getInt("KichThuocId"));
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return sp;
}
}