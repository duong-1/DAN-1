
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import static junit.framework.TestCase.fail;
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
public class TestUpdateMauSac {
    private List<MauSac> list;
    private MauSacTest mauSacTest;

    @Before
    public void setUp(){
        list = new ArrayList<>();
        list.add(new MauSac(33,"ten2"));
        
    }
    @Test()
    public void test1() {
        try {
            for (MauSac mauSac : list) {
                mauSacTest.update(mauSac);
            }
        } catch (IllegalArgumentException e) {
            fail("Test failed: " + e.getMessage());
        }
    }
}
