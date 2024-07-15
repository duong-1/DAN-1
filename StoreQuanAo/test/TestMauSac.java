
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import model.KichThuoc;
import model.MauSac;
import org.junit.Before;
import org.junit.Test;
import test.MauSacTest;
import test.kichThuocTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ba Thuc
 */
public class TestMauSac {
     List<MauSac> list;
    MauSacTest mauSacTest;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        mauSacTest = new MauSacTest();
        list.add(new MauSac("Ten1"));
         list.add(new MauSac("Ten2"));
          list.add(new MauSac("Ten3"));
           list.add(new MauSac("Ten4"));
            list.add(new MauSac("Ten5"));
    }

    @Test
    public void test1() {
        try {
             for (MauSac k : list) {
            mauSacTest.add(k);
        }
       }catch (ArithmeticException e) {
                TestCase.fail("Test failed: " + e.getMessage());
            }
       
    }

}
