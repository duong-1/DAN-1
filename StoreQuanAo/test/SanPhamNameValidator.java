import java.util.ArrayList;
import model.SanPham;
import java.util.List;

public class SanPhamNameValidator {

    private List<SanPham> productList;

    public SanPhamNameValidator(List<SanPham> productList) {
        this.productList = productList;
    }

    public void validateName(String name) throws InvalidProductNameException {
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            throw new InvalidProductNameException("Tên sản phẩm không được null hoặc trống!");
        }
    }

    public void validateUpdatedName(String newName) throws InvalidProductNameException {
        if (newName == null || newName.isEmpty() || newName.trim().isEmpty()) {
            throw new InvalidProductNameException("Tên sản phẩm cập nhật không được null hoặc trống!");
        }
    }

    public void checkNameUniqueness(String name) throws DuplicateProductNameException {
        for (SanPham product : productList) {
            if (product.getTenSanPham().equalsIgnoreCase(name)) {
                throw new DuplicateProductNameException("Tên sản phẩm đã tồn tại!");
            }
        }
    }
    public boolean validateUpdatedProduct(SanPham updatedProduct) throws InvalidProductNameException, DuplicateProductNameException {
    if (updatedProduct == null || updatedProduct.getTenSanPham() == null || updatedProduct.getTenSanPham().trim().isEmpty()) {
        throw new InvalidProductNameException("Tên sản phẩm cập nhật không được null hoặc trống!");
    }

    if (updatedProduct.getPhanLoai() == null || updatedProduct.getPhanLoai().trim().isEmpty()) {
        throw new InvalidProductNameException("Phân loại sản phẩm cập nhật không được null hoặc trống!");
    }

    // Kiểm tra tên sản phẩm cập nhật có trùng với tên của sản phẩm khác không
    for (SanPham sp : productList) {
        if (sp.getSanPhamId() != updatedProduct.getSanPhamId() && sp.getTenSanPham().equalsIgnoreCase(updatedProduct.getTenSanPham())) {
            throw new DuplicateProductNameException("Tên sản phẩm đã tồn tại!");
        }
    }

    return true;
}
    public List<SanPham> searchProduct(String productName) {
    List<SanPham> results = new ArrayList<>();
    for (SanPham sp :results) {
        if (sp.getTenSanPham().equalsIgnoreCase(productName)) {
            results.add(sp);
        }
    }
    return results;
}


}
