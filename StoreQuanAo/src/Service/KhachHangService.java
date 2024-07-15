/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import model.HoaDon;
import model.KhachHang;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class KhachHangService {
     public boolean addData(KhachHang kh) {
        Connection cn = DBConnect.getConnection();
        String sql = "insert into KhachHang(HoTen,DiaChi,SoDienThoai,Gmail) values (?,?,?,?)";
        try {
          PreparedStatement pstm = cn.prepareStatement(sql);
          pstm.setObject(1, kh.getHoTen());
          pstm.setObject(2, kh.getDiaChi());
          pstm.setObject(3, kh.getSoDienThoai());
          pstm.setObject(4, kh.getGmail());
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
     
         public boolean updateData(KhachHang kh) {
        Connection cn = DBConnect.getConnection();
        String sql = "update KhachHang set HoTen = ?,DiaChi = ?,Gmail = ? where SoDienThoai = ?";
        try {
          PreparedStatement pstm = cn.prepareStatement(sql);
          pstm.setObject(1, kh.getHoTen());
          pstm.setObject(2, kh.getDiaChi());
          pstm.setObject(4, kh.getSoDienThoai());
          pstm.setObject(3, kh.getGmail());
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
     
     
     
          public boolean updateDataMua(KhachHang kh) {
        Connection cn = DBConnect.getConnection();
        String sql = "update KhachHang set SoLanMuaHang = ?, TongGiaTriDaMua = ? where KhachHangId = ?";
        try {
          PreparedStatement pstm = cn.prepareStatement(sql);
          pstm.setObject(1, kh.getSolanmuahang());
          pstm.setObject(2, kh.getTonggiatridamua());
          pstm.setObject(3, kh.getKhachHangId());
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
     public KhachHang findDataKhachHang(String sdt)
     {
         Connection cn = DBConnect.getConnection();
         String sql = "select * from KhachHang where SoDienThoai like ?";
         KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
         try{
             PreparedStatement pstm = cn.prepareStatement(sql);
             pstm.setObject(1, sdt);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                kh.setHoTen(rs.getString("HoTen"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setKhachHangId(rs.getInt("KhachHangId"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setSolanmuahang(rs.getInt("SoLanMuaHang"));
                kh.setGmail(rs.getString("Gmail"));
                kh.setTonggiatridamua(rs.getFloat("TongGiaTriDaMua"));
            }
         }catch(Exception e)
         {
             System.out.println(e);
         }
         return kh;
     }
     
     public List<KhachHang> getAllDataKhachHang()
     {
         Connection cn = DBConnect.getConnection();
         String sql = "select * from KhachHang";
         List<KhachHang> lkh = new ArrayList<>();
         try{
             PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
                kh.setHoTen(rs.getString("HoTen"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setKhachHangId(rs.getInt("KhachHangId"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setSolanmuahang(rs.getInt("SoLanMuaHang"));
                kh.setGmail(rs.getString("Gmail"));
                kh.setTonggiatridamua(rs.getFloat("TongGiaTriDaMua"));
                lkh.add(kh);
            }
         }catch(Exception e)
         {
             System.out.println(e);
         }
         return lkh;
     }
     
      public List<KhachHang> getAllDataKhachHangFollowHoTenSDT(String payload)
     {
         Connection cn = DBConnect.getConnection();
         String sql = "select * from KhachHang where SoDienThoai = ? or HoTen like ? or Gmail = ? ";
         List<KhachHang> lkh = new ArrayList<>();
         try{
             PreparedStatement pstm = cn.prepareStatement(sql);
             pstm.setObject(1, payload);
             pstm.setObject(2,'%'+ payload + '%');
             pstm.setObject(3, payload);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
                kh.setHoTen(rs.getString("HoTen"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setKhachHangId(rs.getInt("KhachHangId"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setSolanmuahang(rs.getInt("SoLanMuaHang"));
                kh.setGmail(rs.getString("Gmail"));
                kh.setTonggiatridamua(rs.getFloat("TongGiaTriDaMua"));
                lkh.add(kh);
            }
         }catch(Exception e)
         {
             System.out.println(e);
         }
         return lkh;
     }
      
      
        public List<KhachHang> getAllDataKhachHangFollowSoLanMuaHang(int payload)
     {
         Connection cn = DBConnect.getConnection();
         String sql = "select * from KhachHang where SoLanMuaHang >= ?";
         List<KhachHang> lkh = new ArrayList<>();
         try{
             PreparedStatement pstm = cn.prepareStatement(sql);
             pstm.setObject(1, payload);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
                kh.setHoTen(rs.getString("HoTen"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setKhachHangId(rs.getInt("KhachHangId"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setSolanmuahang(rs.getInt("SoLanMuaHang"));
                kh.setGmail(rs.getString("Gmail"));
                kh.setTonggiatridamua(rs.getFloat("TongGiaTriDaMua"));
                lkh.add(kh);
            }
         }catch(Exception e)
         {
             System.out.println(e);
         }
         return lkh;
     }
}
