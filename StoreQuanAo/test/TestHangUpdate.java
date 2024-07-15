
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.fail;
import model.Hang;
import model.MauSac;
import org.junit.Before;
import org.junit.Test;
import test.HangTest;
import test.MauSacTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ba Thuc
 */
public class TestHangUpdate {
      private List<Hang> list;
    private HangTest hangTest;

    @Before
    public void setUp(){
        list = new ArrayList<>();
        list.add(new Hang(1,"ten2"));
        
    }
    @Test()
    public void test1() {
        try {
            for (Hang hang : list) {
                hangTest.update(hang);
            }
        } catch (IllegalArgumentException e) {
            fail("Test failed: " + e.getMessage());
        }
    }
}
