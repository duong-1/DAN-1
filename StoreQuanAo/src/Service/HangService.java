/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Hang;
import repository.DBConnect;
/**
 *
 * @author TB
 */
public class HangService {
      public boolean addData(Hang h)
    {
       Connection cn = DBConnect.getConnection();
       String sql = "insert into Hang(TenHang) values (?)";
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, h.getTenhang());
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
    
    public List<Hang> getData()
    {
        Connection cn = DBConnect.getConnection();
       String sql = "select * from Hang";
       List<Hang> lh = new ArrayList<>();
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           while(rs.next())
           {
               Hang h = new Hang();
               h.setHangid(rs.getInt("HangId"));
               h.setTenhang(rs.getString("TenHang"));
               lh.add(h);
           }
       }catch(Exception e)
       {
           System.out.println(e);
           
       }
       return lh;
    }
    
    public boolean updateData(Hang h)
    {
       Connection cn = DBConnect.getConnection();
       String sql = "update Hang set TenHang = ? where HangId = ?";
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, h.getTenhang());
           pstm.setObject(2, h.getHangid());
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
