import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.SanPham;
import java.util.ArrayList;
import java.util.List;

public class SanPhamNameValidationTest {

    private List<SanPham> productList;
    private SanPhamNameValidator nameValidator;

    @Before
    public void setUp() {
        productList = new ArrayList<>();
        productList.add(new SanPham(1, 1, "Quần", "Quần Adidas", "08-04-2024", "08-04-2024"));
        productList.add(new SanPham(2, 2, "Áo", "Áo IPhone", "08-04-2024", "08-04-2024"));
        nameValidator = new SanPhamNameValidator(productList);
    }

     @Test
    public void testThemSanPhamThanhCong() {
        try {
            nameValidator.checkNameUniqueness("Áo Adidas"); // Giả định "Máy tính bảng" chưa tồn tại trong danh sách
        } catch (DuplicateProductNameException e) {
            fail("Không nên ném ra ngoại lệ DuplicateProductNameException");
        }
    }
    @Test
    public void testSuaSanPhamThanhCong() throws InvalidProductNameException, DuplicateProductNameException {
    SanPham sp = new SanPham(3, 3, "Quần áo", "Áo khoác", "", "");
    boolean result = nameValidator.validateUpdatedProduct(sp);
    assertTrue(result);
}


    @Test
    public void testTimKiemSanPhamThanhCong() {
        List<SanPham> ketQua = nameValidator.searchProduct("Áo sơ mi");
        assertFalse(ketQua.isEmpty());
    }

    @Test
    public void testKiemTraTenSanPhamVoiTenNull() {
        try {
            nameValidator.validateName(null);
            fail("ngoại lệ");
        } catch (InvalidProductNameException e) {
            assertEquals("Tên sản phẩm không được null hoặc trống!", e.getMessage());
        }
    }

    @Test
    public void testKiemTraTenSanPhamVoiTenRong() {
        try {
            nameValidator.validateName("");
            fail("ngoại lệ");
        } catch (InvalidProductNameException e) {
            assertEquals("Tên sản phẩm không được null hoặc trống!", e.getMessage());
        }
    }

    @Test
    public void testKiemTraTenSanPhamVoiTenKhongHopLe() {
        try {
            nameValidator.validateName("    ");
            fail("ngoại lệ");
        } catch (InvalidProductNameException e) {
            assertEquals("Tên sản phẩm không được null hoặc trống!", e.getMessage());
        }
    }

    @Test
    public void testKiemTraTenSanPhamCapNhatVoiTenNull() {
        try {
            nameValidator.validateUpdatedName(null);
            fail("Nên ném ra ngoại lệ InvalidProductNameException");
        } catch (InvalidProductNameException e) {
            assertEquals("Tên sản phẩm cập nhật không được null hoặc trống!", e.getMessage());
        }
    }

    @Test
    public void testKiemTraTenSanPhamCapNhatVoiTenRong() {
        try {
            nameValidator.validateUpdatedName("");
            fail("ngoại lệ");
        } catch (InvalidProductNameException e) {
            assertEquals("Tên sản phẩm cập nhật không được null hoặc trống!", e.getMessage());
        }
    }

    @Test
    public void testKiemTraTenSanPhamCapNhatVoiTenKhongHopLe() {
        try {
            nameValidator.validateUpdatedName("    ");
            fail("ngoại lệ");
        } catch (InvalidProductNameException e) {
            assertEquals("Tên sản phẩm cập nhật không được null hoặc trống!", e.getMessage());
        }
    }

    @Test
    public void testKiemTraSuKienTenSanPhamTonTai() {
        try {
            nameValidator.checkNameUniqueness("Laptop");
            fail("ngoại lệ");
        } catch (DuplicateProductNameException e) {
            assertEquals("Tên sản phẩm đã tồn tại!", e.getMessage());
        }
    }
}
