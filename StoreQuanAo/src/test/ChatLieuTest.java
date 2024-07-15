/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Service.ChatLieuService;
import Service.MauSacService;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import model.MauSac;

/**
 *
 * @author Ba Thuc
 */
public class ChatLieuTest {
       ChatLieuService chatLieuService = new ChatLieuService();
    List<ChatLieu> list;
    
    public ChatLieuTest() {
        list = chatLieuService.getData();
    }

    public void add(ChatLieu chatLieu) {
        if (list == null) {
            list = new ArrayList<>();
        }
//        if() sử lý số âm sử lý linh tinh
        for (ChatLieu chatLieu1 : list) {
            if(chatLieu.getTenchatlieu().equalsIgnoreCase(chatLieu1.getTenchatlieu())){
                throw new IllegalArgumentException("tên trùng");
            }else{
                break;
            }
        }
        chatLieuService.addData(chatLieu);
        
    }
    public void update(ChatLieu chatLieu) {
    if (list == null) {
        list = new ArrayList<>();
    }

    if (chatLieu.getChatlieuid()<= 0) {
        throw new IllegalArgumentException("Id không hợp lệ");
    }

    boolean found = false;

    for (ChatLieu chatLieu1 : list) {
        if (chatLieu.getChatlieuid()== chatLieu1.getChatlieuid()) {
            found = true;
            
            if (chatLieu.getTenchatlieu().equalsIgnoreCase(chatLieu1.getTenchatlieu())) {
                throw new IllegalArgumentException("Tên trùng");
            }

            break;
        }
    }

    if (!found) {
        throw new IllegalArgumentException("Không tìm thấy ID");
    }

    chatLieuService.updateData(chatLieu);
    System.out.println("Update Thanh Cong");
}

    public List<ChatLieu> get(){
        return list;
    }
}
