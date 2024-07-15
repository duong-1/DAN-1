/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import repository.DBConnect;
import java.sql.*;
import model.SanPhamSanPhamChiTet;
/**
 *
 * @author TB
 */
public class SanPhamSanPhamChiTietService {
    public boolean addSanPhamSanPhamChiTiet(SanPhamSanPhamChiTet spspct){
         Connection cn = DBConnect.getConnection();
        String sql = "insert into SanPhamSanPhamChiTiet(SanPhamId,SanPhamChiTietId,TrangThai) values (?,?,?)";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, spspct.getSanPhamId());
            pstm.setObject(2, spspct.getChiTietSanPhamId());
            pstm.setObject(3, true);
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
    
    public boolean removeSanPhamSanPhamChiTiet(int sanphamid, int sanphamchitietid)
    {
        Connection cn = DBConnect.getConnection();
        String sql = "update SanPhamSanPhamChiTiet set TrangThai = ? where SanPhamId = ? and SanPhamChiTietId = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, false);
            pstm.setObject(2, sanphamid);
            pstm.setObject(3, sanphamchitietid);
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
    
    public boolean enableSanPhamSanPhamChiTiet(int sanphamid, int sanphamchitietid)
    {
        Connection cn = DBConnect.getConnection();
        String sql = "update SanPhamSanPhamChiTiet set TrangThai = ? where SanPhamId = ? and SanPhamChiTietId = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, true);
            pstm.setObject(2, sanphamid);
            pstm.setObject(3, sanphamchitietid);
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
}
