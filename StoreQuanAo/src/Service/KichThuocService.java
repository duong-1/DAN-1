/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KichThuoc;
import repository.DBConnect;
/**
 *
 * @author TB
 */
public class KichThuocService {
    
      public boolean addData(KichThuoc kt)
    {
       Connection cn = DBConnect.getConnection();
       String sql = "insert into KichThuoc(TenKichThuoc) values (?)";
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, kt.getTenkichthuoc());
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
    
    public List<KichThuoc> getData()
    {
        Connection cn = DBConnect.getConnection();
       String sql = "select * from KichThuoc";
       List<KichThuoc> lkt = new ArrayList<>();
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           while(rs.next())
           {
               KichThuoc kt = new KichThuoc();
               kt.setKichthuocid(rs.getInt("KichThuocId"));
               kt.setTenkichthuoc(rs.getString("TenKichThuoc"));
               lkt.add(kt);
           }
       }catch(Exception e)
       {
           System.out.println(e);
           
       }
       return lkt;
    }
    
    public boolean updateData(KichThuoc kt)
    {
       Connection cn = DBConnect.getConnection();
       String sql = "update KichThuoc set TenKichThuoc = ? where KichThuocId = ?";
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, kt.getTenkichthuoc());
           pstm.setObject(2, kt.getKichthuocid());
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
