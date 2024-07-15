import Service.ChiTietSanPhamService;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.ChiTietSanPham;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamServiceTest {

    private List<ChiTietSanPham> danhSachChiTietSanPham;
    private ChiTietSanPhamService chiTietSanPhamService;
    private ChiTietSanPhamValidator validator;

    @Before
    public void setUp() {
        danhSachChiTietSanPham = new ArrayList<>();
        danhSachChiTietSanPham.add(new ChiTietSanPham(1, 1, 1, 1, 1, 100000, 10, true, "Mô tả sơ bộ 1", "Mô tả chi tiết 1", "anh1.jpg"));
        danhSachChiTietSanPham.add(new ChiTietSanPham(2, 2, 2, 2, 2, 150000, 15, true, "Mô tả sơ bộ 2", "Mô tả chi tiết 2", "anh2.jpg"));
        chiTietSanPhamService = new ChiTietSanPhamService();
        
        validator = new ChiTietSanPhamValidator();
    
    }

    @Test
    public void testThemChiTietSanPhamThanhCong() {
        ChiTietSanPham ctsp = new ChiTietSanPham(3, 3, 3, 3, 3, 200000, 20, true, "Mô tả sơ bộ 3", "Mô tả chi tiết 3", "anh3.jpg");
        boolean result = chiTietSanPhamService.addChiTietSanPham(ctsp);

        assertTrue(result);
    }

    @Test
    public void testSuaChiTietSanPhamThanhCong() {
        ChiTietSanPham ctsp = danhSachChiTietSanPham.get(0);
        ctsp.setGiaTien(120000); 
        ctsp.setSoLuong(12);
        boolean result = chiTietSanPhamService.suaChiTietSanPham(ctsp);
        assertTrue(result);
    }

    @Test
    public void testTimKiemChiTietSanPhamTheoId() {
        int id = 2;
        ChiTietSanPham ketQua = chiTietSanPhamService.FindDataSanPhamChiTiet(id);
        assertNotNull(ketQua);
    }

    @Test
    public void testValidateChiTietSanPham_Null() {
        ChiTietSanPham ctsp = null;
        assertFalse(validator.validateChiTietSanPham(ctsp));
    }

    @Test
    public void testValidateChiTietSanPham_GiaTienAm() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setGiaTien(-100000);
        assertFalse(validator.validateChiTietSanPham(ctsp));
    }

    @Test
    public void testValidateChiTietSanPham_SoLuongAm() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setSoLuong(-10);
        assertFalse(validator.validateChiTietSanPham(ctsp));
    }

    @Test
    public void testValidateChiTietSanPham_IDAm() {
        // Kiểm tra khi ID âm
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMauSacId(-1);
        assertFalse(validator.validateChiTietSanPham(ctsp));
    }

}
