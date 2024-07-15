
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.fail;
import model.ChatLieu;
import model.MauSac;
import org.junit.Before;
import org.junit.Test;
import test.ChatLieuTest;
import test.MauSacTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ba Thuc
 */
public class TestChatLieuUpdate {
      private List<ChatLieu> list;
    private ChatLieuTest chatLieuTest;

    @Before
    public void setUp(){
        list = new ArrayList<>();
        list.add(new ChatLieu(1,"ten2"));
        
    }
    @Test()
    public void test1() {
        try {
            for (ChatLieu chatLieu : list) {
                chatLieuTest.update(chatLieu    );
            }
        } catch (IllegalArgumentException e) {
            fail("Test failed: " + e.getMessage());
        }
    }
}
