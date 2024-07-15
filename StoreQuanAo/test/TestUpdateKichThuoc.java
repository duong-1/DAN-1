
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import model.KichThuoc;
import org.junit.Before;
import org.junit.Test;
import test.kichThuocTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ba Thuc
 */
public class TestUpdateKichThuoc {
     List<KichThuoc> list;
    kichThuocTest kichThuocRepo;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        kichThuocRepo = new kichThuocTest();
        list.add(new KichThuoc(12,"Ten4"));
       
    }

    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        try {
             for (KichThuoc k : list) {
            kichThuocRepo.update(k);
        }
       }catch (ArithmeticException e) {
                TestCase.fail("Test failed: " + e.getMessage());
            }
       
    }
}
