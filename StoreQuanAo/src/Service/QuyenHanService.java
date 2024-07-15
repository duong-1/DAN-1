/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import model.QuyenHan;
import java.sql.*;
import repository.DBConnect;
/**
 *
 * @author TB
 */
public class QuyenHanService {
    public boolean addData(QuyenHan qh)
    {
          Connection cn = DBConnect.getConnection();
        String sql = "insert into QuyenHan(NguoiDungId,TenQuyen) values(?,?)";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, qh.getNguoiDungId());
            pstm.setObject(2, qh.getTenQuyen());
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
