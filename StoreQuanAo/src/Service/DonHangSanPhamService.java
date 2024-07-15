/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DonHang;
import model.DonHangSanPham;
import repository.DBConnect;

/**
 *
 * @author TB
 */
public class DonHangSanPhamService {
    public boolean addData(DonHangSanPham dhsp) {
        Connection cn = DBConnect.getConnection();
        String sql = "insert into SanPhamDonHang(HoaDonId,SanPhamSanPhamChiTietId,SoLuong) values (?,?,?)";
      
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, dhsp.getHoaDonId());
            pstm.setObject(2, dhsp.getSanPhamSanPhamChiTietId());
            pstm.setObject(3, dhsp.getSoLuong());
            int result = pstm.executeUpdate();
            if(result !=1)
            {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    }
    
        public boolean udateData(DonHangSanPham dhsp) {
        Connection cn = DBConnect.getConnection();
        String sql = "update SanPhamDonHang set SoLuong = ? where HoaDonId = ? and SanPhamSanPhamChiTietId = ?";
      
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, dhsp.getSoLuong());
            pstm.setObject(2, dhsp.getHoaDonId());
            pstm.setObject(3, dhsp.getSanPhamSanPhamChiTietId());
            int result = pstm.executeUpdate();
            if(result !=1)
            {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    }
    
    public boolean removeData(int sanphamsanphamchitietid, int HoaDonId)
    {
         Connection cn = DBConnect.getConnection();
        String sql = "delete from SanPhamDonHang where SanPhamSanPhamChiTietId = ? and HoaDonId = ?";
      
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, sanphamsanphamchitietid);
            pstm.setObject(2, HoaDonId);
            int result = pstm.executeUpdate();
            if(result !=1)
            {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
