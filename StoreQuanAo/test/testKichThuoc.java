/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import static junit.framework.TestCase.fail;
import model.KichThuoc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.kichThuocTest;

/**
 *
 * @author Ba Thuc
 */
public class testKichThuoc {
   List<KichThuoc> list;
   boolean[] kq;
    kichThuocTest kichThuocRepo;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        kichThuocRepo = new kichThuocTest();
        list.add(new KichThuoc("Ten1"));
        list.add(new KichThuoc("Ten2"));
        list.add(new KichThuoc("Ten3"));
        list.add(new KichThuoc("Ten4"));
        list.add(new KichThuoc("Ten5"));
    }

    @Test
public void test1() {
    try {
        for (KichThuoc kichThuoc : list) {
            kichThuocRepo.add(kichThuoc);
        }
    } catch (IllegalArgumentException e) {
        fail("Test failed: " + e.getMessage());
    }
}

}
