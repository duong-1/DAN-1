/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import repository.DBConnect;
/**
 *
 * @author TB
 */
public class ChatLieuService {
      public boolean addData(ChatLieu cl)
    {
       Connection cn = DBConnect.getConnection();
       String sql = "insert into ChatLieu(TenChatLieu) values (?)";
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, cl.getTenchatlieu());
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
    
    public List<ChatLieu> getData()
    {
        Connection cn = DBConnect.getConnection();
       String sql = "select * from ChatLieu";
       List<ChatLieu> lcl = new ArrayList<>();
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           while(rs.next())
           {
               ChatLieu cl = new ChatLieu();
               cl.setChatlieuid(rs.getInt("ChatLieuId"));
               cl.setTenchatlieu(rs.getString("TenChatLieu"));
               lcl.add(cl);
           }
       }catch(Exception e)
       {
           System.out.println(e);
           
       }
       return lcl;
    }
    
    public boolean updateData(ChatLieu cl)
    {
       Connection cn = DBConnect.getConnection();
       String sql = "update ChatLieu set TenChatLieu = ? where ChatLieuId = ?";
       try{
           PreparedStatement pstm = cn.prepareStatement(sql);
           pstm.setObject(1, cl.getTenchatlieu());
           pstm.setObject(2, cl.getChatlieuid());
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
