import model.ChiTietSanPham;

public class ChiTietSanPhamValidator {

    public boolean validateChiTietSanPham(ChiTietSanPham ctsp) {
        if (ctsp == null) {
            throw new IllegalArgumentException("Chi tiết sản phẩm không được null.");
        }
        if (!checkGiaTien(ctsp.getGiaTien())) {
            throw new IllegalArgumentException("Giá tiền không hợp lệ.");
        }
        if (!checkSoLuong(ctsp.getSoLuong())) {
            throw new IllegalArgumentException("Số lượng không hợp lệ.");
        }
        if (!checkID(ctsp.getMauSacId()) || !checkID(ctsp.getKichThuocId()) || !checkID(ctsp.getHangId()) || !checkID(ctsp.getChatLieuId())) {
            throw new IllegalArgumentException("ID không hợp lệ.");
        }
       
        return true;
    }
    

    private boolean checkGiaTien(float giaTien) {
        if (giaTien < 0) {
            throw new IllegalArgumentException("Giá tiền không được âm.");
        }
        return true; 
    }

    private boolean checkSoLuong(int soLuong) {
        if (soLuong < 0) {
            throw new IllegalArgumentException("Số lượng không được âm.");
        }
        return true; 
    }

    private boolean checkID(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID không hợp lệ.");
        }
        return true; 
    }
}
