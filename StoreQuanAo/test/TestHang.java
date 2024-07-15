
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.fail;
import model.Hang;
import model.KichThuoc;
import org.junit.Before;
import org.junit.Test;
import test.HangTest;
import test.kichThuocTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ba Thuc
 */
public class TestHang {

    List<Hang> list;
    HangTest hangTest;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        hangTest = new HangTest();
        list.add(new Hang("Ten1"));
        list.add(new Hang("Ten2"));
        list.add(new Hang("Ten3"));
        list.add(new Hang("Ten4"));
        list.add(new Hang("Ten5"));

    }

    @Test
    public void test1() {
        try {
            for (Hang hang : list) {
                hangTest.add(hang);
            }
        } catch (IllegalArgumentException e) {
            fail("Test failed: " + e.getMessage());
        }
    }
}
