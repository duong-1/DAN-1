/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import model.MauSac;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import repository.DBConnect;
/**
 *
 * @author TB
 */
public class MauSacService {
    public boolean addData(MauSac ms)
    {
        System.out.println(ms);
       Connection cn = DBConnect.getConnection();
       String sql = "insert into MauSac(TenMauSac) values (?)";
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, ms.getTenmausac());
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
    
    public List<MauSac> getData()
    {
        Connection cn = DBConnect.getConnection();
       String sql = "select * from mausac";
       List<MauSac> lms = new ArrayList<>();
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           while(rs.next())
           {
               MauSac ms = new MauSac();
               ms.setMausacid(rs.getInt("MauSacId"));
               ms.setTenmausac(rs.getString("TenMauSac"));
               lms.add(ms);
           }
       }catch(Exception e)
       {
           System.out.println(e);
           
       }
       return lms;
    }
    
    public boolean updateData(MauSac ms)
    {
       Connection cn = DBConnect.getConnection();
       String sql = "update MauSac set TenMauSac = ? where MauSacId = ?";
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, ms.getTenmausac());
           pstm.setObject(2, ms.getMausacid());
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
    
}
