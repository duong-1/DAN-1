
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.fail;
import model.ChatLieu;
import model.KichThuoc;
import org.junit.Before;
import org.junit.Test;
import test.ChatLieuTest;
import test.kichThuocTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ba Thuc
 */
public class TestChatLieu {

    List<ChatLieu> list;
    ChatLieuTest chatLieuTest;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        chatLieuTest = new ChatLieuTest();
        list.add(new ChatLieu("Ten1"));
        list.add(new ChatLieu("Ten2"));
        list.add(new ChatLieu("Ten3"));
        list.add(new ChatLieu("Ten4"));
        list.add(new ChatLieu("Ten5"));
       
    }

    @Test
    public void test1() {
        try {
            for (ChatLieu chatLieu : list) {
                chatLieuTest.add(chatLieu);
            }
        } catch (IllegalArgumentException e) {
            fail("Test failed: " + e.getMessage());
        }
    }
}
