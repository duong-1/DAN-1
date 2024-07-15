/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.PhuongThucThanhToan;
import java.sql.*;
import java.util.ArrayList;
import repository.DBConnect;
/**
 *
 * @author TB
 */
public class PhuongThucThanhToanService {
    public List<PhuongThucThanhToan> getData(){
          Connection cn = DBConnect.getConnection();
        String sql = "Select * from PhuongThucThanhToan";
        List<PhuongThucThanhToan> lspttt = new ArrayList<>();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
               PhuongThucThanhToan pttt = new PhuongThucThanhToan();
               pttt.setId(rs.getString("id"));
               pttt.setTenPhuongThuc(rs.getString("TenPhuongThuc"));
               lspttt.add(pttt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lspttt;
    }
}
