/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Service.ChatLieuService;
import Service.ChiTietSanPhamService;
import Service.DonHangSanPhamHoanChinhService;
import Service.DonHangSanPhamService;
import Service.DonHangService;
import Service.HangService;
import Service.HoaDonService;
import Service.KhachHangService;
import Service.KhuyenMaiService;
import Service.KichThuocService;
import Service.LoginService;
import Service.MauSacService;
import Service.PhuongThucThanhToanService;
import Service.SanPhamHoanChinhService;
import Service.SanPhamSanPhamChiTietService;
import Service.SanPhamService;
import Service.ThuocTinhSanPhamService;
import Service.ValidateService;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.DonHang;
import model.DonHangSanPham;
import model.DonHangSanPhamHoanChinh;
import model.Hang;
import model.HoaDon;
import model.KhachHang;
import model.KhuyenMai;
import model.KichThuoc;
import model.MauSac;
import model.PhuongThucThanhToan;
import model.SanPham;
import model.SanPhamHoanChinh;
import model.SanPhamSanPhamChiTet;
import model.ThuocTinhSanPham;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NguoiDung;

/**
 *
 * @author TB
 */
public class StoreForm extends javax.swing.JFrame {
    
    boolean check = false;
    SanPhamService sps = new SanPhamService();
    List<SanPham> lsp = new ArrayList<>();
    List<ChiTietSanPham> lctsp = new ArrayList<>();
    ChiTietSanPhamService ctsv = new ChiTietSanPhamService();
    List<ThuocTinhSanPham> ttsp = new ArrayList<>();
    ThuocTinhSanPhamService ttspsv = new ThuocTinhSanPhamService();
    String urlAnh = new String();
    List<SanPhamHoanChinh> lsphc = new ArrayList<>();
    SanPhamHoanChinhService sphcsv = new SanPhamHoanChinhService();
    List<Object> allInfor = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();
    DefaultTableModel modelHoaDon = new DefaultTableModel();
    DefaultTableModel modelDonHang = new DefaultTableModel();
    List<DonHang> ldh = new ArrayList<>();
    DonHangService dhs = new DonHangService();
    List<DonHangSanPham> ldhsp = new ArrayList<>();
    DonHangSanPhamService dhspsv = new DonHangSanPhamService();
    String soluongBanDau = "";
    DefaultComboBoxModel cboMaDonModel = new DefaultComboBoxModel();
    public static List<DonHangSanPhamHoanChinh> ldhsphc = new ArrayList<>();
    DonHangSanPhamHoanChinhService dhsphcsv = new DonHangSanPhamHoanChinhService();
    DefaultComboBoxModel modelcboPhuongThucTT = new DefaultComboBoxModel();
    List<PhuongThucThanhToan> lpttt = new ArrayList<>();
    PhuongThucThanhToanService ptttsv = new PhuongThucThanhToanService();
    boolean edittable = false;
    KhachHangService khs = new KhachHangService();
    HoaDonService hds = new HoaDonService();
    SanPhamSanPhamChiTietService spspctsv = new SanPhamSanPhamChiTietService();
    DefaultTableModel modelTableHoaDon = new DefaultTableModel();
    SanPham SanPhamFormQuanLiSp = new SanPham();
    List<SanPham> lspmain = new ArrayList<>();
    public static int dataStatic;
    public static String tentaikhoan;
    public static String idtaikhoan;
    Font f = new Font(BaseFont.createFont("D:\\DUAN1\\VnArial_Font_VnUnikey.com_\\vuArialBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
    Font NORMAL_FONT = new Font(BaseFont.createFont("D:\\DUAN1\\VnArial_Font_VnUnikey.com_\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
    Font Font_Nghieng = new Font(BaseFont.createFont("D:\\DUAN1\\VnArial_Font_VnUnikey.com_\\vuArialItalic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));

    /**
     * Creates new form StoreForm
     */
    public StoreForm() throws DocumentException, IOException {
        initComponents();
        checkRoleUser();
        lblTest.setVisible(false);
        setLocationRelativeTo(null);
        lsphc = sphcsv.getData();
        model = (DefaultTableModel) tblStore.getModel();
        tblStore.setRowHeight(50);
        lsphc = sphcsv.getData();
        txtTenTaiKhoan.setText(tentaikhoan);
        fillToTable();
        jpHoaDon.setVisible(false);
        jpMainSanPham.setVisible(true);
        jpQuanLyHoaDon.setVisible(false);
        jpSanPham.setVisible(false);
        jpQuanLyNhanVien.setVisible(false);
        jpQuanLyKhuyenMai.setVisible(false);
        jpQuanLyThongKe.setVisible(false);
        jpQuanLyKhachHang.setVisible(false);
        btnSanPhamMain.setBackground(Color.red);
        tblSanPhamMain.setRowHeight(25);
        
        SanPhamMain();
        fillToComBoBoxThuocTinh();
        fillToComBoMauSacStore();
        fillToComBoHangStore();
    }
    
    public void fillToComBoBoxThuocTinh() {
        fillToComBoMauSac();
        fillToComBoBoxKichThuoc();
        fillToComBoBoxChatLieu();
        fillToComBoBoxHang();
    }
    
    public void fillToComBoMauSac() {
        MauSac ms = new MauSac();
        MauSacService mss = new MauSacService();
        List<MauSac> lms = mss.getData();
        DefaultComboBoxModel cboMauSacModel = new DefaultComboBoxModel();
        cboMauSacModel = (DefaultComboBoxModel) cboMauSac.getModel();
        cboMauSacModel.removeAllElements();
        for (MauSac i : lms) {
            cboMauSacModel.addElement(i);
        }
        
    }
    
    public void checkRoleUser() {
        LoginService lgs = new LoginService();
        if (idtaikhoan != null) {
            NguoiDung nd = lgs.findDataNguoiDungId(idtaikhoan);
            if (!nd.getRole().equalsIgnoreCase("Quản lý")) {
                btnQLThongKe.setVisible(false);
                btnQLNhanVien.setVisible(false);
            }
        }
        
    }
    
    public void fillToComBoMauSacStore() {
        MauSacService msv = new MauSacService();
        List<MauSac> lms1 = msv.getData();
        DefaultComboBoxModel cboMauSacStoreModel = new DefaultComboBoxModel();
        cboMauSacStoreModel = (DefaultComboBoxModel) cboMauSacStore.getModel();
        cboMauSacStoreModel.removeAllElements();
        MauSac ms2 = new MauSac();
        ms2.setTenmausac("");
        cboMauSacStoreModel.addElement(ms2);
        for (MauSac i : lms1) {
            
            cboMauSacStoreModel.addElement(i);
        }
    }
    
    public void fillToComBoBoxKichThuoc() {
        KichThuocService kts = new KichThuocService();
        KichThuoc kt = new KichThuoc();
        List<KichThuoc> lkt = kts.getData();
        DefaultComboBoxModel cboKichThuocModel = new DefaultComboBoxModel();
        cboKichThuocModel = (DefaultComboBoxModel) cboKichThuoc.getModel();
        cboKichThuocModel.removeAllElements();
        for (KichThuoc i : lkt) {
            cboKichThuocModel.addElement(i);
        }
    }
    
    public void fillToComBoBoxChatLieu() {
        
        ChatLieu cl = new ChatLieu();
        ChatLieuService cls = new ChatLieuService();
        List<ChatLieu> lcl = cls.getData();
        DefaultComboBoxModel cboChatLieModel = new DefaultComboBoxModel();
        
        cboChatLieModel = (DefaultComboBoxModel) cboChatLieu.getModel();
        
        cboChatLieModel.removeAllElements();
        
        for (ChatLieu i : lcl) {
            cboChatLieModel.addElement(i);
        }
        
    }
    
    public void fillToComBoBoxHang() {
        HangService hs = new HangService();
        Hang h = new Hang();
        
        List<Hang> lh = hs.getData();
        
        DefaultComboBoxModel cboHangModel = new DefaultComboBoxModel();
        
        cboHangModel = (DefaultComboBoxModel) cboHang.getModel();
        
        cboHangModel.removeAllElements();
        
        for (Hang i : lh) {
            cboHangModel.addElement(i);
        }
        
    }
    
    public void fillToComBoHangStore() {
        HangService hs = new HangService();
        List<Hang> lh1 = hs.getData();
        DefaultComboBoxModel cboHangStoreModel = new DefaultComboBoxModel();
        cboHangStoreModel = (DefaultComboBoxModel) cboHangStore.getModel();
        cboHangStoreModel.removeAllElements();
        Hang h2 = new Hang();
        h2.setTenhang("");
        cboHangStoreModel.addElement(h2);
        for (Hang i : lh1) {
            cboHangStoreModel.addElement(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnSanPham = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnHoaDon = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnSanPhamMain = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnQlHoaDon = new javax.swing.JPanel();
        btnQuanLyHoaDon = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnQLKhuyenMai = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btnQLNhanVien = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btnQLKhachHang = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btnQLThongKe = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtTenTaiKhoan = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jpSanPham = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtTenSp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cboPhanLoai = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStore = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jlbPickAnh = new javax.swing.JLabel();
        btnAddSanPham = new javax.swing.JButton();
        btnSuaSanPham = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cboChatLieu = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        cboKichThuoc = new javax.swing.JComboBox<>();
        cboHang = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        cboPhanLoaiStore = new javax.swing.JComboBox<>();
        cboMauSacStore = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        cboHangStore = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jpMainSanPham = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanPhamMain = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        txtTenSpMain = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cboPhanLoaiMain = new javax.swing.JComboBox<>();
        btnAddSanPhamMain = new javax.swing.JButton();
        btnSuaSanPhamMain = new javax.swing.JButton();
        btnMoiSanPhamMain = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtTimKiemMain = new javax.swing.JTextField();
        cboTimKiemPhanLoaiMain = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jpHoaDon = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnSuaSoLuong = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDanhSachSanPham2 = new javax.swing.JTable();
        txtTimKiemBanHang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnLamMoi2 = new javax.swing.JButton();
        btnQuetQr = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTienHang = new javax.swing.JLabel();
        lblCanTra = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboPTThanhToan = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtMaGiamGia = new javax.swing.JTextField();
        btnApDungMa = new javax.swing.JButton();
        lblTest = new javax.swing.JLabel();
        btnLamMoiMa = new javax.swing.JButton();
        jpQuanLyHoaDon = new javax.swing.JPanel();
        jpQuanLyKhuyenMai = new javax.swing.JPanel();
        jpQuanLyNhanVien = new javax.swing.JPanel();
        jpQuanLyKhachHang = new javax.swing.JPanel();
        jpQuanLyThongKe = new javax.swing.JPanel();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(240, 115, 34));
        jPanel1.setForeground(new java.awt.Color(204, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSanPham.setBackground(new java.awt.Color(255, 204, 204));
        btnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Sản Phẩm Chi Tiết");

        javax.swing.GroupLayout btnSanPhamLayout = new javax.swing.GroupLayout(btnSanPham);
        btnSanPham.setLayout(btnSanPhamLayout);
        btnSanPhamLayout.setHorizontalGroup(
            btnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        btnSanPhamLayout.setVerticalGroup(
            btnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(btnSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 60));

        btnHoaDon.setBackground(new java.awt.Color(255, 204, 204));
        btnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHoaDonMouseClicked(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dotgiamgia.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Bán Hàng");

        javax.swing.GroupLayout btnHoaDonLayout = new javax.swing.GroupLayout(btnHoaDon);
        btnHoaDon.setLayout(btnHoaDonLayout);
        btnHoaDonLayout.setHorizontalGroup(
            btnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        btnHoaDonLayout.setVerticalGroup(
            btnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(btnHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 260, 60));

        btnSanPhamMain.setBackground(new java.awt.Color(255, 204, 204));
        btnSanPhamMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSanPhamMainMouseClicked(evt);
            }
        });

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setText("Sản Phẩm");

        javax.swing.GroupLayout btnSanPhamMainLayout = new javax.swing.GroupLayout(btnSanPhamMain);
        btnSanPhamMain.setLayout(btnSanPhamMainLayout);
        btnSanPhamMainLayout.setHorizontalGroup(
            btnSanPhamMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSanPhamMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        btnSanPhamMainLayout.setVerticalGroup(
            btnSanPhamMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSanPhamMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnSanPhamMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(btnSanPhamMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 260, 60));

        btnQlHoaDon.setBackground(new java.awt.Color(255, 204, 204));
        btnQlHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQlHoaDonMouseClicked(evt);
            }
        });

        btnQuanLyHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuanLyHoaDon.setText("Hóa Đơn");

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hoadon.png"))); // NOI18N

        javax.swing.GroupLayout btnQlHoaDonLayout = new javax.swing.GroupLayout(btnQlHoaDon);
        btnQlHoaDon.setLayout(btnQlHoaDonLayout);
        btnQlHoaDonLayout.setHorizontalGroup(
            btnQlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        btnQlHoaDonLayout.setVerticalGroup(
            btnQlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnQlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(btnQlHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 260, 60));

        btnQLKhuyenMai.setBackground(new java.awt.Color(255, 204, 204));
        btnQLKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLKhuyenMaiMouseClicked(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setText("Khuyến Mại");

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/phieugiamgia.png"))); // NOI18N

        javax.swing.GroupLayout btnQLKhuyenMaiLayout = new javax.swing.GroupLayout(btnQLKhuyenMai);
        btnQLKhuyenMai.setLayout(btnQLKhuyenMaiLayout);
        btnQLKhuyenMaiLayout.setHorizontalGroup(
            btnQLKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        btnQLKhuyenMaiLayout.setVerticalGroup(
            btnQLKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnQLKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(btnQLKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 260, 60));

        btnQLNhanVien.setBackground(new java.awt.Color(255, 204, 204));
        btnQLNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLNhanVienMouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Nhân Viên");

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nhanvien.png"))); // NOI18N

        javax.swing.GroupLayout btnQLNhanVienLayout = new javax.swing.GroupLayout(btnQLNhanVien);
        btnQLNhanVien.setLayout(btnQLNhanVienLayout);
        btnQLNhanVienLayout.setHorizontalGroup(
            btnQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        btnQLNhanVienLayout.setVerticalGroup(
            btnQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(btnQLNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 260, 60));

        btnQLKhachHang.setBackground(new java.awt.Color(255, 204, 204));
        btnQLKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLKhachHangMouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setText("Khách Hàng");

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/khachhang.png"))); // NOI18N

        javax.swing.GroupLayout btnQLKhachHangLayout = new javax.swing.GroupLayout(btnQLKhachHang);
        btnQLKhachHang.setLayout(btnQLKhachHangLayout);
        btnQLKhachHangLayout.setHorizontalGroup(
            btnQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        btnQLKhachHangLayout.setVerticalGroup(
            btnQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(btnQLKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 260, 60));

        btnQLThongKe.setBackground(new java.awt.Color(255, 204, 204));
        btnQLThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLThongKeMouseClicked(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setText("Thống Kê Doanh Thu");

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu-bar.png"))); // NOI18N

        javax.swing.GroupLayout btnQLThongKeLayout = new javax.swing.GroupLayout(btnQLThongKe);
        btnQLThongKe.setLayout(btnQLThongKeLayout);
        btnQLThongKeLayout.setHorizontalGroup(
            btnQLThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        btnQLThongKeLayout.setVerticalGroup(
            btnQLThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnQLThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(btnQLThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 260, 60));

        btnThoat.setBackground(new java.awt.Color(255, 204, 204));
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setText("Thoát");

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thoat.png"))); // NOI18N

        javax.swing.GroupLayout btnThoatLayout = new javax.swing.GroupLayout(btnThoat);
        btnThoat.setLayout(btnThoatLayout);
        btnThoatLayout.setHorizontalGroup(
            btnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        btnThoatLayout.setVerticalGroup(
            btnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 260, 60));

        jPanel2.setBackground(new java.awt.Color(240, 113, 34));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(240, 156, 78));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Nendomatt-Apple-Louvre-Apple-Store-Tshirt.32.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel4.setText("V-Store");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 50));

        jLabel5.setBackground(new java.awt.Color(255, 255, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Everaldo-Kids-Icons-X.32.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 50, 40));

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));

        txtTenTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTenTaiKhoan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTenTaiKhoan.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 230, 50));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jpSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel13.setText("Tên sản Phẩm");

        txtTenSp.setEnabled(false);

        jLabel14.setText("Phân Loại");

        cboPhanLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quần", "Áo", "Váy" }));
        cboPhanLoai.setEnabled(false);

        jLabel15.setText("Số Lượng");

        jLabel16.setText("Giá Tiền");

        jLabel17.setText("Kích Thước");

        jLabel18.setText("Hãng");

        jLabel19.setText("Chất liệu");

        jLabel20.setText("Màu Sắc");

        tblStore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sản Phẩm ID", "Tên Sản Phẩm", "Loại Sản Phẩm", "Kích Thước", "Màu Sắc", "Chất Liệu", "Đơn Giá", "Số Lượng", "Hình Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStoreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStore);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        jButton2.setText("Thêm thuộc tính");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jlbPickAnh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbPickAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbPickAnh.setText("Chọn Ảnh");
        jlbPickAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbPickAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jlbPickAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbPickAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );

        btnAddSanPham.setText("Thêm sản phẩm");
        btnAddSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSanPhamActionPerformed(evt);
            }
        });

        btnSuaSanPham.setText("Sửa sản phẩm");
        btnSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamActionPerformed(evt);
            }
        });

        btnXoaSanPham.setText("Ẩn sản phẩm");
        btnXoaSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaSanPhamMouseClicked(evt);
            }
        });
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnMoi.setText("Làm mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cleaning.png"))); // NOI18N
        jButton3.setText("Hiển thị các sản phẩm đã ẩn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboChatLieuMouseClicked(evt);
            }
        });
        cboChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChatLieuActionPerformed(evt);
            }
        });

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMauSacMouseClicked(evt);
            }
        });

        cboKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboKichThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboKichThuocMouseClicked(evt);
            }
        });
        cboKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKichThuocActionPerformed(evt);
            }
        });

        cboHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboHangMouseClicked(evt);
            }
        });
        cboHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHangActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 204, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jLabel23.setText("Tìm kiếm:");

        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel31.setText("Phân Loại");

        cboPhanLoaiStore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Quần", "Áo", "Váy" }));
        cboPhanLoaiStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboPhanLoaiStoreMouseClicked(evt);
            }
        });
        cboPhanLoaiStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhanLoaiStoreActionPerformed(evt);
            }
        });

        cboMauSacStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMauSacStoreMouseClicked(evt);
            }
        });
        cboMauSacStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMauSacStoreActionPerformed(evt);
            }
        });

        jLabel32.setText("Màu Sắc");

        cboHangStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboHangStoreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboHangStoreMouseEntered(evt);
            }
        });
        cboHangStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHangStoreActionPerformed(evt);
            }
        });

        jLabel33.setText("Hãng");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboHangStore, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboMauSacStore, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboPhanLoaiStore, 0, 191, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(cboPhanLoaiStore, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMauSacStore, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(cboHangStore, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpSanPhamLayout = new javax.swing.GroupLayout(jpSanPham);
        jpSanPham.setLayout(jpSanPhamLayout);
        jpSanPhamLayout.setHorizontalGroup(
            jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpSanPhamLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenSp))
                            .addGroup(jpSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpSanPhamLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboChatLieu, 0, 207, Short.MAX_VALUE))
                                    .addGroup(jpSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboKichThuoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jpSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAddSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSuaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpSanPhamLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(14, 14, 14))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(29, 29, 29))
        );
        jpSanPhamLayout.setVerticalGroup(
            jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSanPhamLayout.createSequentialGroup()
                        .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpSanPhamLayout.createSequentialGroup()
                                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpSanPhamLayout.createSequentialGroup()
                                        .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jpSanPhamLayout.createSequentialGroup()
                                .addComponent(btnAddSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSuaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnXoaSanPham)
                                    .addComponent(cboKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnMoi)
                                    .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jpSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jpSanPhamLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddSanPham, btnMoi, btnSuaSanPham, btnXoaSanPham});

        jPanel3.add(jpSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1070, 650));

        jpMainSanPham.setBackground(new java.awt.Color(255, 204, 204));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("QUẢN LÝ SẢN PHẨM"));

        tblSanPhamMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sản Phẩm ID", "Tên Sản Phẩm", "Phân Loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMainMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSanPhamMain);

        jLabel27.setText("Tên sản Phẩm");

        jLabel28.setText("Phân Loại");

        cboPhanLoaiMain.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quần", "Áo", "Váy" }));

        btnAddSanPhamMain.setBackground(new java.awt.Color(255, 255, 255));
        btnAddSanPhamMain.setText("Thêm sản phẩm");
        btnAddSanPhamMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSanPhamMainActionPerformed(evt);
            }
        });

        btnSuaSanPhamMain.setBackground(new java.awt.Color(255, 255, 255));
        btnSuaSanPhamMain.setText("Sửa sản phẩm");
        btnSuaSanPhamMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamMainActionPerformed(evt);
            }
        });

        btnMoiSanPhamMain.setBackground(new java.awt.Color(255, 255, 255));
        btnMoiSanPhamMain.setText("Mới");
        btnMoiSanPhamMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMoiSanPhamMainMouseClicked(evt);
            }
        });
        btnMoiSanPhamMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiSanPhamMainActionPerformed(evt);
            }
        });

        btnXemChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        btnXemChiTiet.setText("Xem Chi Tiết");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(255, 204, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm Sản Phẩm"));

        jLabel29.setText("Tìm kiếm:");

        txtTimKiemMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMainMouseClicked(evt);
            }
        });
        txtTimKiemMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemMainActionPerformed(evt);
            }
        });
        txtTimKiemMain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemMainKeyPressed(evt);
            }
        });

        cboTimKiemPhanLoaiMain.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Quần", "Áo", "Váy" }));
        cboTimKiemPhanLoaiMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimKiemPhanLoaiMainActionPerformed(evt);
            }
        });

        jLabel30.setText("Phân Loại");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTimKiemPhanLoaiMain, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtTimKiemMain, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(469, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimKiemPhanLoaiMain, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiemMain, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(28, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboPhanLoaiMain, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSpMain, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(157, 157, 157)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnXemChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSanPhamMain, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaSanPhamMain, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiSanPhamMain, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddSanPhamMain, btnMoiSanPhamMain, btnSuaSanPhamMain, btnXemChiTiet});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaSanPhamMain, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenSpMain, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddSanPhamMain, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPhanLoaiMain, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiSanPhamMain, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddSanPhamMain, btnMoiSanPhamMain, btnSuaSanPhamMain, btnXemChiTiet});

        javax.swing.GroupLayout jpMainSanPhamLayout = new javax.swing.GroupLayout(jpMainSanPham);
        jpMainSanPham.setLayout(jpMainSanPhamLayout);
        jpMainSanPhamLayout.setHorizontalGroup(
            jpMainSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainSanPhamLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jpMainSanPhamLayout.setVerticalGroup(
            jpMainSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMainSanPhamLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jpMainSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 660));

        jpHoaDon.setBackground(new java.awt.Color(255, 204, 204));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Hóa Đơn"));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Tên NV", "Tên Khách Hàng", "Trạng Thái", "Ngày Tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn Hàng"));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên Sản Phẩm", "Màu Sắc", "Chất Liệu", "Kích thước", "Số lượng", "Đơn giá", "Trạng thái", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblGioHangMouseEntered(evt);
            }
        });
        tblGioHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblGioHangKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblGioHang.getColumnModel().getColumn(2).setPreferredWidth(1);
            tblGioHang.getColumnModel().getColumn(3).setPreferredWidth(1);
            tblGioHang.getColumnModel().getColumn(4).setPreferredWidth(3);
            tblGioHang.getColumnModel().getColumn(5).setPreferredWidth(1);
            tblGioHang.getColumnModel().getColumn(6).setPreferredWidth(2);
            tblGioHang.getColumnModel().getColumn(7).setPreferredWidth(1);
            tblGioHang.getColumnModel().getColumn(8).setPreferredWidth(10);
        }

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cleaning.png"))); // NOI18N
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSuaSoLuong.setBackground(new java.awt.Color(255, 204, 204));
        btnSuaSoLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/restore.png"))); // NOI18N
        btnSuaSoLuong.setText("Sửa số lượng");
        btnSuaSoLuong.setToolTipText("");
        btnSuaSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSoLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuaSoLuong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnSuaSoLuong))
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Sản Phẩm"));

        tblDanhSachSanPham2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm", "Kích Thước", "Màu Sắc", "Chất Liệu", "Đơn Giá", "Số Lượng", "Hình Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachSanPham2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSanPham2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblDanhSachSanPham2MouseEntered(evt);
            }
        });
        jScrollPane6.setViewportView(tblDanhSachSanPham2);

        txtTimKiemBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemBanHangActionPerformed(evt);
            }
        });

        jLabel6.setText("Tìm Kiếm");

        btnLamMoi2.setText("Làm Mới");
        btnLamMoi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoi2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnLamMoi2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnQuetQr.setBackground(new java.awt.Color(255, 204, 204));
        btnQuetQr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnQuetQr.setText("Quét QR");
        btnQuetQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetQrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuetQr, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnQuetQr, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("SDT Khách Hàng");

        jLabel8.setText("Tổng tiền hàng");

        jLabel9.setText("Khách cần trả");

        jLabel12.setText("Hình thức thanh toán ");

        cboPTThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThanhToan.setBackground(new java.awt.Color(255, 204, 204));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hoadon.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 204, 204));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setBackground(new java.awt.Color(255, 204, 204));
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel26.setText("Mã Giảm Giá");

        btnApDungMa.setBackground(new java.awt.Color(255, 204, 204));
        btnApDungMa.setText("Áp Dụng Mã");
        btnApDungMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApDungMaActionPerformed(evt);
            }
        });

        btnLamMoiMa.setBackground(new java.awt.Color(255, 204, 204));
        btnLamMoiMa.setText("Làm Mới Mã");
        btnLamMoiMa.setEnabled(false);
        btnLamMoiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTienHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboPTThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaGiamGia))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnLamMoiMa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(btnApDungMa))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon)
                        .addGap(8, 8, 8)
                        .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(lblTienHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(lblCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cboPTThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApDungMa)
                    .addComponent(btnLamMoiMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpHoaDonLayout = new javax.swing.GroupLayout(jpHoaDon);
        jpHoaDon.setLayout(jpHoaDonLayout);
        jpHoaDonLayout.setHorizontalGroup(
            jpHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpHoaDonLayout.setVerticalGroup(
            jpHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(jpHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 670));

        jpQuanLyHoaDon.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jpQuanLyHoaDonLayout = new javax.swing.GroupLayout(jpQuanLyHoaDon);
        jpQuanLyHoaDon.setLayout(jpQuanLyHoaDonLayout);
        jpQuanLyHoaDonLayout.setHorizontalGroup(
            jpQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jpQuanLyHoaDonLayout.setVerticalGroup(
            jpQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        jPanel3.add(jpQuanLyHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 670));

        jpQuanLyKhuyenMai.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jpQuanLyKhuyenMaiLayout = new javax.swing.GroupLayout(jpQuanLyKhuyenMai);
        jpQuanLyKhuyenMai.setLayout(jpQuanLyKhuyenMaiLayout);
        jpQuanLyKhuyenMaiLayout.setHorizontalGroup(
            jpQuanLyKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jpQuanLyKhuyenMaiLayout.setVerticalGroup(
            jpQuanLyKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        jPanel3.add(jpQuanLyKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 670));

        jpQuanLyNhanVien.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jpQuanLyNhanVienLayout = new javax.swing.GroupLayout(jpQuanLyNhanVien);
        jpQuanLyNhanVien.setLayout(jpQuanLyNhanVienLayout);
        jpQuanLyNhanVienLayout.setHorizontalGroup(
            jpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jpQuanLyNhanVienLayout.setVerticalGroup(
            jpQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        jPanel3.add(jpQuanLyNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 670));

        jpQuanLyKhachHang.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jpQuanLyKhachHangLayout = new javax.swing.GroupLayout(jpQuanLyKhachHang);
        jpQuanLyKhachHang.setLayout(jpQuanLyKhachHangLayout);
        jpQuanLyKhachHangLayout.setHorizontalGroup(
            jpQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jpQuanLyKhachHangLayout.setVerticalGroup(
            jpQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        jPanel3.add(jpQuanLyKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 670));

        jpQuanLyThongKe.setBackground(new java.awt.Color(255, 204, 204));
        jpQuanLyThongKe.setPreferredSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout jpQuanLyThongKeLayout = new javax.swing.GroupLayout(jpQuanLyThongKe);
        jpQuanLyThongKe.setLayout(jpQuanLyThongKeLayout);
        jpQuanLyThongKeLayout.setHorizontalGroup(
            jpQuanLyThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jpQuanLyThongKeLayout.setVerticalGroup(
            jpQuanLyThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        jPanel3.add(jpQuanLyThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ThuocTinhSanPhamDialog(this, true).setVisible(true);
        fillToComBoMauSacStore();
        fillToComBoHangStore();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jlbPickAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbPickAnhMouseClicked
        SelectImage();
    }//GEN-LAST:event_jlbPickAnhMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked
    

    private void btnAddSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSanPhamActionPerformed
        if (SanPhamFormQuanLiSp.getSanPhamId() == 0) {
            jpSanPham.setVisible(false);
            jpMainSanPham.setVisible(true);
            btnSanPhamMain.setBackground(Color.red);
            btnSanPham.setBackground(new Color(255, 204, 204));
            JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm tương ứng");
            SanPhamMain();
            return;
        }
        if (sps.checkRong(txtTenSp.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên sản phẩm");
            return;
        }
        if (sps.checkRong(txtSoLuong.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống số lượng");
            return;
        }
        
        if (sps.checkInt(txtSoLuong.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên");
            return;
        }
        if (sps.checkInt(txtGiaTien.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Giá tiền phải là số nguyên");
            return;
        }
        if (sps.checkRong(urlAnh) == false) {
            JOptionPane.showMessageDialog(this, "Bạn phải thêm ảnh");
            return;
        }
        if (checkTrungSanPhamCT() == false) {
            return;
        }
        ChiTietSanPham ctsp = getDataSanPhamChiTietInForm();
        
        boolean result1 = ctsv.addChiTietSanPham(ctsp);
        if (result1) {
            lctsp = ctsv.getDataSanPham();
            ChiTietSanPham ctsp2 = lctsp.get(lctsp.size() - 1);
            SanPham sp = SanPhamFormQuanLiSp;
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
            SanPhamSanPhamChiTet spspct = new SanPhamSanPhamChiTet();
            spspct.setChiTietSanPhamId(ctsp2.getId());
            spspct.setSanPhamId(sp.getSanPhamId());
            spspctsv.addSanPhamSanPhamChiTiet(spspct);
            lsphc = sphcsv.getDataFollowId(sp.getSanPhamId());
            fillToTable();
            
        } else {
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
        }
        

    }//GEN-LAST:event_btnAddSanPhamActionPerformed
    
    public boolean checkTrungSanPhamCT() {
        List<SanPhamHoanChinh> lctsp1 = sphcsv.getData();
        ChatLieu cl = (ChatLieu) cboChatLieu.getSelectedItem();
        Hang h = (Hang) cboHang.getSelectedItem();
        MauSac ms = (MauSac) cboMauSac.getSelectedItem();
        KichThuoc kt = (KichThuoc) cboKichThuoc.getSelectedItem();
        for (SanPhamHoanChinh i : lctsp1) {
            if (i.getTenSanPham().equals(txtTenSp.getText()) && i.getPhanLoai().equals((String) cboPhanLoai.getSelectedItem()) && i.getSoLuong() == Integer.parseInt(txtSoLuong.getText()) && i.getGiaTien() == Float.parseFloat(txtGiaTien.getText()) && i.getHangId() == h.getHangid() && i.getKichThuocId() == kt.getKichthuocid() && i.getMauSacId() == ms.getMausacid() && i.getChatLieuId() == cl.getChatlieuid() && i.getAnh().equals(urlAnh)) {
                JOptionPane.showMessageDialog(this, "Sản phẩm này đã tồn tại");
                return false;
            }
        }
        return true;
    }
    

    private void btnSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseClicked
        jpSanPham.setVisible(true);
        jpHoaDon.setVisible(false);
        jpMainSanPham.setVisible(false);
        jpQuanLyKhuyenMai.setVisible(false);
        btnQLKhuyenMai.setBackground(new Color(255, 204, 204));
        lsphc = sphcsv.getData();
        fillToTable();
        btnSanPham.setBackground(Color.red);
        jpQuanLyHoaDon.setVisible(false);
        btnQlHoaDon.setBackground(new Color(255, 204, 204));
        btnHoaDon.setBackground(new Color(255, 204, 204));
        btnSanPhamMain.setBackground(new Color(255, 204, 204));
        btnQLNhanVien.setBackground(new Color(255, 204, 204));
        jpQuanLyNhanVien.setVisible(false);
        jpQuanLyKhachHang.setVisible(false);
        btnQLKhachHang.setBackground(new Color(255, 204, 204));
        btnQLThongKe.setBackground(new Color(255, 204, 204));
        jpQuanLyThongKe.setVisible(false);
    }//GEN-LAST:event_btnSanPhamMouseClicked

    private void btnHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoaDonMouseClicked
        jpSanPham.setVisible(false);
        jpQuanLyHoaDon.setVisible(false);
        jpHoaDon.setVisible(true);
        jpMainSanPham.setVisible(false);
        jpQuanLyKhuyenMai.setVisible(false);
        btnQLKhuyenMai.setBackground(new Color(255, 204, 204));
        BanHang();
        tblDanhSachSanPham2.setRowSelectionInterval(0, 0);
        btnHoaDon.setBackground(Color.red);
        btnSanPham.setBackground(new Color(255, 204, 204));
        btnSanPhamMain.setBackground(new Color(255, 204, 204));
        btnQlHoaDon.setBackground(new Color(255, 204, 204));
        btnQLNhanVien.setBackground(new Color(255, 204, 204));
        jpQuanLyNhanVien.setVisible(false);
        jpQuanLyKhachHang.setVisible(false);
        btnQLKhachHang.setBackground(new Color(255, 204, 204));
        btnQLThongKe.setBackground(new Color(255, 204, 204));
        jpQuanLyThongKe.setVisible(false);
    }//GEN-LAST:event_btnHoaDonMouseClicked

    private void tblDanhSachSanPham2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSanPham2MouseClicked
        int quyetdinh = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm sản phẩm vào giỏ hàng không? ");
        if (quyetdinh == JOptionPane.YES_OPTION) {
            if (tblHoaDon.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn muốn thêm sản phẩm");
                return;
            }
            int indexDanhSachSp2 = tblDanhSachSanPham2.getSelectedRow();
            SanPhamHoanChinh sphc = lsphc.get(indexDanhSachSp2);
            
            List<HoaDon> lhd = new ArrayList<>();
            lhd = hds.showDataHoaDon();
            HoaDon hd = lhd.get(tblHoaDon.getSelectedRow());
            if (hd.isTrangThai() == true) {
                JOptionPane.showMessageDialog(this, "Hóa đơn đã được thanh toán không thể thêm");
                return;
            }
            btnApDungMa.setEnabled(true);
            txtMaGiamGia.setEnabled(true);
            DonHangSanPham dhsp = new DonHangSanPham();
            dhsp.setSanPhamSanPhamChiTietId(sphc.getSanPhamSanPhamChiTetId());
            dhsp.setHoaDonId(hd.getHoaDonId());
            String soluong = JOptionPane.showInputDialog(this, "Nhập số lượng");
            try {
                int soluong1 = Integer.parseInt(soluong);
                if (soluong1 <= 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải là số dương");
                    return;
                }
                if (soluong1 > sphc.getSoLuong()) {
                    JOptionPane.showMessageDialog(this, "Số lượng trong kho chỉ còn " + sphc.getSoLuong());
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số dương");
                return;
            }
            
            dhsp.setSoLuong(Integer.parseInt(soluong));
            for (DonHangSanPhamHoanChinh i : ldhsphc) {
                if (i.getSanPhamId() == Integer.parseInt(sphc.getSanPhamId()) && i.getChiTietSanPhamId() == Integer.parseInt(sphc.getChiTietSanPhamid())) {
                    dhsp.setSoLuong(Integer.parseInt(soluong) + i.getSoLuong());
                    ctsv.updateChiTietSanPham(sphc.getSoLuong() - Integer.parseInt(soluong), Integer.parseInt(sphc.getChiTietSanPhamid()));
                    boolean result = dhspsv.udateData(dhsp);
                    if (result) {
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào đơn hàng thành công");
                        ldhsphc = dhsphcsv.getDataHoaDonFollowId(hd.getHoaDonId());
                        fillToTableDonHang();
                        lsphc = sphcsv.getData();
                        fillToTableDanhSachSanPham2();
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào đơn hàng thất bại");
                        return;
                    }
                    
                }
            }
            
            boolean result = dhspsv.addData(dhsp);
            ctsv.updateChiTietSanPham(sphc.getSoLuong() - Integer.parseInt(soluong), Integer.parseInt(sphc.getChiTietSanPhamid()));
            if (result) {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào đơn hàng thành công");
                ldhsphc = dhsphcsv.getDataHoaDonFollowId(hd.getHoaDonId());
                fillToTableDonHang();
                lsphc = sphcsv.getData();
                fillToTableDanhSachSanPham2();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào đơn hàng thất bại");
            }
        }
    }//GEN-LAST:event_tblDanhSachSanPham2MouseClicked

    private void tblGioHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseEntered

    }//GEN-LAST:event_tblGioHangMouseEntered

    private void tblGioHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGioHangKeyPressed
//       int indexDonHang = tblGioHang.getSelectedRow();
//        DonHang donhangchoose = ldh.get(indexDonHang);


    }//GEN-LAST:event_tblGioHangKeyPressed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        soluongBanDau = tblGioHang.getValueAt(tblGioHang.getSelectedRow(), 2).toString();
//        System.out.println(soluongBanDau);
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        KhachHang kh = getDataKhachHangInForm();

//        KhachHang kh1 = khs.findDataKhachHang(kh.getSoDienThoai());
//        if (kh1.getKhachHangId() == 0) {
//            boolean result = khs.addData(kh);
//            if (result) {
//                KhachHang kh2 = khs.findDataKhachHang(kh.getSoDienThoai());
//                HoaDon hd = getHoaDonInForm(kh2.getKhachHangId());
//                boolean result2 = hds.addData(hd);
//                if (result2) {
//                    DonHang dh = (DonHang) cboMaDonHang.getSelectedItem();
//                    dhs.thayDoiTrangThai(true, dh.getDonHangId());
//                    JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
//                    FillToTableHoaDon();
//                    fillToTableDonHang();
//                }
//            }
//        } else {
        HoaDon hd = getHoaDonInForm();
        boolean result2 = hds.addData(hd);
        if (result2) {
//                DonHang dh = (DonHang) cboMaDonHang.getSelectedItem();
//                dhs.thayDoiTrangThai(true, dh.getDonHangId());
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
            FillToTableHoaDon();
//                fillToTableDonHang();
        }
//        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStoreMouseClicked

//        lsphc = sphcsv.getData();
        SanPhamHoanChinh sphc = lsphc.get(tblStore.getSelectedRow());
        SanPham sp = new SanPham();
        sp.setSanPhamId(Integer.parseInt(sphc.getSanPhamId()));
        sp.setTenSanPham(sphc.getTenSanPham());
//        SanPhamFormQuanLiSp = sp;
        txtTenSp.setText(sphc.getTenSanPham());
        cboPhanLoai.setSelectedItem(sphc.getPhanLoai());
        txtSoLuong.setText(sphc.getSoLuong() + "");
        txtGiaTien.setText(sphc.getGiaTien() + "");
        DefaultComboBoxModel cboChatLieuModel = new DefaultComboBoxModel();
        DefaultComboBoxModel cboHangModel = new DefaultComboBoxModel();
        DefaultComboBoxModel cboKichThuocModel = new DefaultComboBoxModel();
        DefaultComboBoxModel cboMauSacModel = new DefaultComboBoxModel();
        cboChatLieuModel = (DefaultComboBoxModel) cboChatLieu.getModel();
        cboHangModel = (DefaultComboBoxModel) cboHang.getModel();
        cboKichThuocModel = (DefaultComboBoxModel) cboKichThuoc.getModel();
        cboMauSacModel = (DefaultComboBoxModel) cboMauSac.getModel();
        MauSac ms = new MauSac();
        ms.setMausacid(sphc.getMauSacId());
        ms.setTenmausac(sphc.getMauSac());
        cboMauSacModel.setSelectedItem(ms);
        KichThuoc kt = new KichThuoc(sphc.getKichThuocId(), sphc.getKichThuoc());
        
        cboKichThuocModel.setSelectedItem(kt);
        ChatLieu cl = new ChatLieu(sphc.getChatLieuId(), sphc.getChatLieu());
        cboChatLieuModel.setSelectedItem(cl);
        
        Hang h = new Hang(sphc.getHangId(), sphc.getHang());
        cboHangModel.setSelectedItem(h);
        urlAnh = sphc.getAnh();
        Image imic = new ImageIcon(sphc.getAnh()).getImage().getScaledInstance(jlbPickAnh.getWidth(), jlbPickAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(imic);
        jlbPickAnh.setText("");
        jlbPickAnh.setIcon(image);

    }//GEN-LAST:event_tblStoreMouseClicked

    private void btnSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamActionPerformed
        int index = tblStore.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn hãy chọn sản phẩm tương ứng");
            return;
        }
        int selection = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không ?");
        
        if (selection == JOptionPane.YES_OPTION) {
            if (sps.checkInt(txtGiaTien.getText()) == false) {
                JOptionPane.showMessageDialog(this, "Số tiền phải là số nguyên");
                return;
            }
            if (sps.checkInt(txtSoLuong.getText()) == false) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên");
                return;
            }
            if (checkTrungSanPhamCT() == false) {
                return;
            }
            int indextblSanPham = tblStore.getSelectedRow();
            SanPhamHoanChinh sphc = lsphc.get(indextblSanPham);
            ChiTietSanPham ctsp = getDataSanPhamChiTietInForm();
            ctsp.setId(Integer.parseInt(sphc.getChiTietSanPhamid()));
            ctsv.suaChiTietSanPham(ctsp);
            SanPham spInform = getDataSanPhamInForm();
            SanPham sp = new SanPham();
            sp.setSanPhamId(Integer.parseInt(sphc.getSanPhamId()));
            sp.setTenSanPham(spInform.getTenSanPham());
            sp.setPhanLoai(spInform.getPhanLoai());
            boolean result = sps.suaSanPham(sp);
            if (result) {
                JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công");
                lsphc = sphcsv.getDataFollowId(sp.getSanPhamId());
                fillToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa sản phẩm thất bại");
            }
        }

    }//GEN-LAST:event_btnSuaSanPhamActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        int indexSphc = tblStore.getSelectedRow();
        if (indexSphc == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm tương ứng");
            return;
        }
        SanPhamHoanChinh sphc = lsphc.get(indexSphc);
        int quyetdinh = JOptionPane.showConfirmDialog(this, "Bạn có muốn ẩn sản phẩm này không ?");
        if (quyetdinh == JOptionPane.YES_OPTION) {
            boolean result = spspctsv.removeSanPhamSanPhamChiTiet(Integer.parseInt(sphc.getSanPhamId()), Integer.parseInt(sphc.getChiTietSanPhamid()));
            if (result) {
                JOptionPane.showMessageDialog(this, "ẩn thành công");
                lsphc = sphcsv.getDataFollowId(SanPhamFormQuanLiSp.getSanPhamId());
                fillToTable();
            } else {
                JOptionPane.showMessageDialog(this, "ẩn thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
//        SanPham sp = new SanPham();
//        SanPhamFormQuanLiSp = sp;

        txtSoLuong.setText("");
        txtGiaTien.setText("");
        cboMauSac.setSelectedIndex(0);
        cboChatLieu.setSelectedIndex(0);
        cboKichThuoc.setSelectedIndex(0);
        cboPhanLoaiStore.setSelectedIndex(0);
        cboHang.setSelectedIndex(0);
        if (SanPhamFormQuanLiSp.getSanPhamId() == 0) {
            txtTenSp.setText("");
            cboPhanLoai.setSelectedIndex(0);
            lsphc = sphcsv.getData();
            fillToTable();
        } else {
            lsphc = sphcsv.getDataFollowId(SanPhamFormQuanLiSp.getSanPhamId());
            fillToTable();
        }
        

    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        ValidateService vlsv = new ValidateService();
        if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập số điện thoại");
            return;
        }
        if (vlsv.checkPhone(txtSDT.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại");
            return;
        }
        int indexHoaDon = tblHoaDon.getSelectedRow();
        if (indexHoaDon == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn muốn thanh toán");
            return;
        }
        List<HoaDon> lhd = new ArrayList<>();
        lhd = hds.showDataHoaDon();
        KhuyenMaiService kms = new KhuyenMaiService();
        KhuyenMai km = kms.findDataKhuyenMai(txtMaGiamGia.getText());
        
        HoaDon hd = lhd.get(indexHoaDon);
        HoaDon hd1 = getDataHoaDon();
        hd1.setHoaDonId(hd.getHoaDonId());
        if (km.getKhuyenMaiId() != 0) {
            hd1.setKhuyenMaiId(km.getKhuyenMaiId());
        }
        
        int mahoadon = (int) tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0);
        boolean result = hds.ThanhToanHoaDon(hd1);
        
        if (result) {
            
            JOptionPane.showMessageDialog(this, "Thanh toán đơn hàng thành công");
            deleteDataThanhToan();
            kms.updateSoLuongKhuyenMai(km.getSoluongma() - 1, km.getKhuyenMaiId());
            FillToTableHoaDon();
            int quyetdinhin = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không ?");
            if (quyetdinhin == JOptionPane.YES_OPTION) {
                for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                    modelDonHang.setValueAt("Đã thanh toán", i, 7);
                }
                exportInvoiceToPDF(hd1, tblGioHang, txtSDT.getText());
            }
            
            modelDonHang.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(this, "Thanh toán đơn hàng thất bại");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed
    
    public void deleteDataThanhToan() {
        txtSDT.setText("");
        lblTienHang.setText("");
        lblCanTra.setText("");
        lblTest.setText("");
        cboPTThanhToan.setSelectedIndex(0);
        txtMaGiamGia.setText("");
        btnLamMoiMa.setEnabled(false);
        btnApDungMa.setEnabled(true);
    }
    
    private void exportInvoiceToPDF(HoaDon hd, JTable table, String sdt) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("D:\\DUAN1\\hoa_don.pdf"));
            document.open();

            // Tiêu đề
            addTitle(document, "Hóa Đơn Bán Hàng");
            addSubtitle(document, "Mã hóa đơn: " + hd.getHoaDonId());
            // Thông tin khách hàng
            addSubtitle(document, "Thông tin khách hàng");
            addKeyValue(document, "Họ tên khách hàng:", hd.getHoTenKhachHang());
            addKeyValue(document, "Số điện thoại khách hàng:", sdt);
            addKeyValue(document, "Ngày Mua:", getCurrentDate());

            // Thông tin hóa đơn
            addSubtitle(document, "Thông tin hóa đơn:");
            DecimalFormat decimalFormat2 = new DecimalFormat("###,### VND");
            addKeyValue(document, "Tổng tiền:", decimalFormat2.format(hd.getTongTien()));
            addKeyValue(document, "Người tạo:", hd.getNguoiTao());
            
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            //adding table headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(new Phrase(table.getColumnName(i), NORMAL_FONT));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    pdfTable.addCell(new Phrase(table.getModel().getValueAt(rows, cols).toString(), NORMAL_FONT));
                    
                }
            }
            document.add(pdfTable);
            addLineSeparator(document);
            kyTen(document, hd.getNguoiTao());
            JOptionPane.showMessageDialog(this, "Hóa đơn đã được xuất thành công.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
    
    private void addTitle(Document document, String title) throws Exception {
        f.setSize(30);
        Paragraph pg1 = new Paragraph(title, f);
        pg1.setAlignment(Element.ALIGN_CENTER);
        document.add(pg1);
    }
    
    private void addSubtitle(Document document, String subtitle) throws Exception {
        Font_Nghieng.setSize(14);
        Paragraph pg1 = new Paragraph(subtitle, Font_Nghieng);
        pg1.setAlignment(Element.ALIGN_CENTER);
        pg1.setSpacingAfter(20);
        document.add(pg1);
    }
    
    private void addKeyValue(Document document, String key, String value) throws Exception {
        NORMAL_FONT.setSize(12);
        Phrase phrase = new Phrase();
        phrase.add(new Phrase(key, NORMAL_FONT));
        phrase.add(new Phrase(" " + value + "\n", NORMAL_FONT));
        document.add(phrase);
    }
    
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new Date());
    }
    
    private void addLineSeparator(Document document) throws Exception {
        LineSeparator line = new LineSeparator();
        document.add(new Chunk(line));
    }
    
    public void kyTen(Document document, String nguoiki) throws DocumentException {
        Paragraph pg1 = new Paragraph();
        Phrase phaPhrase = new Phrase();
        phaPhrase.add(new Phrase("Người Bán \n", NORMAL_FONT));
        phaPhrase.add(new Phrase(nguoiki, NORMAL_FONT));
        phaPhrase.setFont(NORMAL_FONT);
        pg1.add(phaPhrase);
        pg1.setAlignment(Element.ALIGN_RIGHT);
        pg1.setSpacingBefore(30);
        document.add(pg1);
    }
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int indexGioHang = tblGioHang.getSelectedRow();
        if (indexGioHang == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm muốn xóa");
            return;
        }
        int indexHoaDon = tblHoaDon.getSelectedRow();
        if (indexHoaDon == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn");
            return;
        }
        
        int quyetdinh = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?");
        if (quyetdinh == JOptionPane.NO_OPTION || quyetdinh == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Đã không xóa");
            return;
        }
        
        List<HoaDon> lhd = hds.showDataHoaDon();
        HoaDon hd = lhd.get(indexHoaDon);
        DonHangSanPhamHoanChinh dhsphc = ldhsphc.get(indexGioHang);
        if (dhsphc.isTrangThaiDonHang() == true) {
            JOptionPane.showMessageDialog(this, "Không thể xóa đơn hàng đã được thêm vào hóa đơn");
            
            return;
        } else {
            boolean result = dhspsv.removeData(dhsphc.getSanPhamSanPhamChiTietId(), hd.getHoaDonId());
            if (result) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                ldhsphc = dhsphcsv.getDataHoaDonFollowId(hd.getHoaDonId());
                ChiTietSanPham ctsp = ctsv.FindDataSanPhamChiTiet(dhsphc.getChiTietSanPhamId());
                ctsv.updateChiTietSanPham(dhsphc.getSoLuong() + ctsp.getSoLuong(), ctsp.getId());
                fillToTableDonHang();
                lsphc = sphcsv.getData();
                fillToTableDanhSachSanPham2();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SanPhamAn spa = new SanPhamAn();
        spa.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cboHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHangActionPerformed

    }//GEN-LAST:event_cboHangActionPerformed

    private void cboKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKichThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboKichThuocActionPerformed

    private void cboHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboHangMouseClicked
        
        fillToComBoBoxHang();
    }//GEN-LAST:event_cboHangMouseClicked

    private void cboKichThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboKichThuocMouseClicked
        
        fillToComBoBoxKichThuoc();
    }//GEN-LAST:event_cboKichThuocMouseClicked

    private void cboMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMauSacMouseClicked
        fillToComBoMauSac();
    }//GEN-LAST:event_cboMauSacMouseClicked

    private void cboChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboChatLieuMouseClicked
        fillToComBoBoxChatLieu();
    }//GEN-LAST:event_cboChatLieuMouseClicked

    private void btnXoaSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaSanPhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaSanPhamMouseClicked

    private void btnQuetQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetQrActionPerformed
        int indexHoaDon = tblHoaDon.getSelectedRow();
        if (indexHoaDon == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn");
            return;
        }
        int mahoadon = (int) tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0);
        dataStatic = mahoadon;
        new CameraQR().setVisible(true);

    }//GEN-LAST:event_btnQuetQrActionPerformed

    private void btnAddSanPhamMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSanPhamMainActionPerformed
        if (checkTrungSanPhamMain() == false) {
            return;
        }
        SanPham sp = new SanPham();
        sp.setTenSanPham(txtTenSpMain.getText());
        sp.setPhanLoai((String) cboPhanLoaiMain.getSelectedItem());
        boolean result = sps.addSanPham(sp);
        if (result) {
            JOptionPane.showMessageDialog(this, "Thêm Sản Phẩm Thành Công");
            lspmain = sps.getDataSanPham();
            fillToTableSanPhamMain(lspmain);
        } else {
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
        }
    }//GEN-LAST:event_btnAddSanPhamMainActionPerformed
    
    public boolean checkTrungSanPhamMain() {
        lspmain = sps.getDataSanPham();
        for (SanPham i : lspmain) {
            if (i.getTenSanPham().equals(txtTenSpMain.getText()) && i.getPhanLoai().equals((String) cboPhanLoaiMain.getSelectedItem())) {
                JOptionPane.showMessageDialog(this, "Tên sản phẩm và phân loại đã tồn tại");
                return false;
            }
        }
        return true;
    }
    

    private void btnSuaSanPhamMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamMainActionPerformed
        int indexSanPhamMain = tblSanPhamMain.getSelectedRow();
        if (indexSanPhamMain == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm tương ứng");
            return;
        }
        List<SanPham> lsp = sps.getDataSanPham();
        SanPham spSua = lsp.get(indexSanPhamMain);
        SanPham sp = new SanPham();
        sp.setSanPhamId(spSua.getSanPhamId());
        sp.setTenSanPham(txtTenSpMain.getText());
        sp.setPhanLoai((String) cboPhanLoaiMain.getSelectedItem());
        boolean result = sps.suaSanPham(sp);
        if (result) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            List<SanPham> lsp1 = sps.getDataSanPham();
            fillToTableSanPhamMain(lsp1);
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaSanPhamMainActionPerformed

    private void btnMoiSanPhamMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoiSanPhamMainMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoiSanPhamMainMouseClicked

    private void btnMoiSanPhamMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiSanPhamMainActionPerformed
        txtTenSpMain.setText("");
        txtTimKiemMain.setText("");
        cboPhanLoaiMain.setSelectedIndex(0);
        List<SanPham> lsp = sps.getDataSanPham();
        lspmain = lsp;
        fillToTableSanPhamMain(lspmain);
    }//GEN-LAST:event_btnMoiSanPhamMainActionPerformed

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        int indexSanPhamMain = tblSanPhamMain.getSelectedRow();
        if (indexSanPhamMain == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm tương ứng");
            return;
        }
//        lspmain = sps.getDataSanPham();
        SanPhamFormQuanLiSp = lspmain.get(indexSanPhamMain);
        fillTxtSanPham();
        lsphc = sphcsv.getDataFollowId(SanPhamFormQuanLiSp.getSanPhamId());
        fillToTable();
        jpSanPham.setVisible(true);
        jpMainSanPham.setVisible(false);
        btnSanPham.setBackground(Color.red);
        btnSanPhamMain.setBackground(new Color(255, 204, 204));
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnSanPhamMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMainMouseClicked
        jpSanPham.setVisible(false);
        jpHoaDon.setVisible(false);
        jpQuanLyHoaDon.setVisible(false);
        jpMainSanPham.setVisible(true);
        jpQuanLyKhuyenMai.setVisible(false);
        btnQLKhuyenMai.setBackground(new Color(255, 204, 204));
        tblSanPhamMain.setRowHeight(25);
        SanPhamMain();
        tblDanhSachSanPham2.setRowSelectionInterval(0, 0);
        btnSanPhamMain.setBackground(Color.red);
        btnSanPham.setBackground(new Color(255, 204, 204));
        btnHoaDon.setBackground(new Color(255, 204, 204));
        btnQlHoaDon.setBackground(new Color(255, 204, 204));
        btnQLNhanVien.setBackground(new Color(255, 204, 204));
        jpQuanLyNhanVien.setVisible(false);
        jpQuanLyKhachHang.setVisible(false);
        btnQLKhachHang.setBackground(new Color(255, 204, 204));
        btnQLThongKe.setBackground(new Color(255, 204, 204));
        jpQuanLyThongKe.setVisible(false);
    }//GEN-LAST:event_btnSanPhamMainMouseClicked

    private void tblSanPhamMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMainMouseClicked
        int spid = (int) tblSanPhamMain.getValueAt(tblSanPhamMain.getSelectedRow(), 0);
//       lspmain = sps.getDataSanPham();
//        lspmain = sps.getDataSanPhamFollowId(spid);
        int indexSanPhamMain = tblSanPhamMain.getSelectedRow();
        SanPham sp = lspmain.get(indexSanPhamMain);
        txtTenSpMain.setText(sp.getTenSanPham());
        cboPhanLoaiMain.setSelectedItem(sp.getPhanLoai());
    }//GEN-LAST:event_tblSanPhamMainMouseClicked

    private void txtTimKiemMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemMainActionPerformed
        
        List<SanPham> lsp = sps.searchDataSanPham(txtTimKiemMain.getText());
        lspmain = lsp;
        fillToTableSanPhamMain(lspmain);
    }//GEN-LAST:event_txtTimKiemMainActionPerformed

    private void txtTimKiemMainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemMainKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemMainKeyPressed

    private void cboTimKiemPhanLoaiMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimKiemPhanLoaiMainActionPerformed
        String phanloai = (String) cboTimKiemPhanLoaiMain.getSelectedItem();
        if (phanloai.equals(" ")) {
            List<SanPham> lsp = sps.getDataSanPham();
            lspmain = lsp;
            fillToTableSanPhamMain(lspmain);
            return;
        }
        
        List<SanPham> lsp = sps.searchDataSanPhamFollowPhanLoai(phanloai);
        
        lspmain = lsp;
        txtTimKiemMain.setText("");
        fillToTableSanPhamMain(lspmain);
        

    }//GEN-LAST:event_cboTimKiemPhanLoaiMainActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        if (SanPhamFormQuanLiSp.getSanPhamId() != 0) {
            lsphc = sphcsv.getDataSearchAndId(txtTimKiem.getText(), SanPhamFormQuanLiSp.getSanPhamId());
            fillToTable();
        } else {
            lsphc = sphcsv.getDataSearch(txtTimKiem.getText());
            fillToTable();
        }
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cboPhanLoaiStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhanLoaiStoreActionPerformed
        if (SanPhamFormQuanLiSp.getSanPhamId() != 0) {
            String phanloai = (String) cboPhanLoaiStore.getSelectedItem();
            if (!phanloai.equals(" ")) {
                lsphc = sphcsv.getDataPhanLoaiAndId(phanloai, SanPhamFormQuanLiSp.getSanPhamId());
                fillToTable();
            }
            
        } else {
            String phanloai = (String) cboPhanLoaiStore.getSelectedItem();
            if (!phanloai.equals(" ")) {
                lsphc = sphcsv.getDataPhanLoai(phanloai);
                fillToTable();
            }
            
        }

    }//GEN-LAST:event_cboPhanLoaiStoreActionPerformed

    private void cboHangStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboHangStoreMouseClicked
        
        cboMauSacStore.setSelectedIndex(0);
        cboPhanLoaiStore.setSelectedIndex(0);
        txtTimKiem.setText("");
    }//GEN-LAST:event_cboHangStoreMouseClicked

    private void cboMauSacStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMauSacStoreMouseClicked
        
        cboHangStore.setSelectedIndex(0);
        cboPhanLoaiStore.setSelectedIndex(0);
        txtTimKiem.setText("");
    }//GEN-LAST:event_cboMauSacStoreMouseClicked

    private void cboHangStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHangStoreActionPerformed
        if (SanPhamFormQuanLiSp.getSanPhamId() != 0) {
            Hang h = (Hang) cboHangStore.getSelectedItem();
            if (h != null) {
                lsphc = sphcsv.getDataHangAndId(h.getTenhang(), SanPhamFormQuanLiSp.getSanPhamId());
                fillToTable();
            }
            
        } else {
            SanPham sp = new SanPham();
            SanPhamFormQuanLiSp = sp;
            Hang h = (Hang) cboHangStore.getSelectedItem();
            if (h != null) {
                lsphc = sphcsv.getDataHang(h.getTenhang());
                fillToTable();
            }
            
        }

    }//GEN-LAST:event_cboHangStoreActionPerformed

    private void cboMauSacStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMauSacStoreActionPerformed
        if (SanPhamFormQuanLiSp.getSanPhamId() != 0) {
            MauSac ms = (MauSac) cboMauSacStore.getSelectedItem();
            if (ms != null) {
                lsphc = sphcsv.getDataMauSacAndId(ms.getTenmausac(), SanPhamFormQuanLiSp.getSanPhamId());
                fillToTable();
            }
            
        } else {
            MauSac ms = (MauSac) cboMauSacStore.getSelectedItem();
            if (ms != null) {
                lsphc = sphcsv.getDataMauSac(ms.getTenmausac());
                fillToTable();
            }
            
        }

    }//GEN-LAST:event_cboMauSacStoreActionPerformed

    private void cboPhanLoaiStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPhanLoaiStoreMouseClicked
        cboHangStore.setSelectedIndex(0);
        cboMauSacStore.setSelectedIndex(0);
        txtTimKiem.setText("");
    }//GEN-LAST:event_cboPhanLoaiStoreMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int hoadonid = (int) tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0);
        ldhsphc = dhsphcsv.getDataHoaDonFollowId(hoadonid);
        fillToTableDonHang();
        lsphc = sphcsv.getData();
        fillToTableDanhSachSanPham2();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblDanhSachSanPham2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSanPham2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachSanPham2MouseEntered

    private void btnSuaSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSoLuongActionPerformed
        int tblHoaDonindex = tblHoaDon.getSelectedRow();
        int tblDonHangIndex = tblGioHang.getSelectedRow();
        if (tblDonHangIndex == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm tương ứng");
            return;
        }
        int soluongbandau = (int) tblGioHang.getValueAt(tblDonHangIndex, 5);
        DonHangSanPhamHoanChinh dhsphc = ldhsphc.get(tblDonHangIndex);
        SanPhamHoanChinh sphc = sphcsv.findDataFollowId(dhsphc.getSanPhamId(), dhsphc.getChiTietSanPhamId());
        System.out.println(tblDonHangIndex);
        
        String soluong = JOptionPane.showInputDialog(this, "Nhập số lượng");
        try {
            int soluong1 = Integer.parseInt(soluong);
            if (soluong1 <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số dương");
                return;
            }
//            if (soluong1 > sphc.getSoLuong()) {
//                JOptionPane.showMessageDialog(this, "Số lượng trong kho chỉ còn " + sphc.getSoLuong());
//                return;
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số dương");
            return;
        }
        DonHangSanPham dhsp = new DonHangSanPham();
        dhsp.setHoaDonId(dhsphc.getHoaDonId());
        dhsp.setSanPhamSanPhamChiTietId(dhsphc.getSanPhamSanPhamChiTietId());
        dhsp.setSoLuong(Integer.parseInt(soluong));
        
        ChiTietSanPham ctsp = ctsv.FindDataSanPhamChiTiet(dhsphc.getChiTietSanPhamId());
        int soluongsanpham = soluongbandau + ctsp.getSoLuong();
        int soluongcapnhat = soluongsanpham - Integer.parseInt(soluong);
        if (soluongcapnhat < 0) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không đủ số lượng");
            return;
        }
        ctsv.updateChiTietSanPham(soluongsanpham - Integer.parseInt(soluong), ctsp.getId());
        
        boolean result = dhspsv.udateData(dhsp);
        if (result) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            
            ldhsphc = dhsphcsv.getDataHoaDonFollowId(dhsphc.getHoaDonId());
            fillToTableDonHang();
            lsphc = sphcsv.getData();
            fillToTableDanhSachSanPham2();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaSoLuongActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int indexHoaDon = tblHoaDon.getSelectedRow();
        if (indexHoaDon == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn muốn hủy");
            return;
            
        }
        int quyetdinh = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn huy không?");
        if (quyetdinh == JOptionPane.NO_OPTION || quyetdinh == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Đã không hủy");
            return;
        }
        int hoadonid = (int) tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0);
        List<DonHangSanPhamHoanChinh> ldhsphc = dhsphcsv.getDataHoaDonFollowId(hoadonid);
        for (DonHangSanPhamHoanChinh i : ldhsphc) {
            ChiTietSanPham ctsp = ctsv.FindDataSanPhamChiTiet(i.getChiTietSanPhamId());
            ctsv.updateChiTietSanPham(i.getSoLuong() + i.getSoLuongSanPhamGoc(), ctsp.getId());
            
        }
        boolean result = hds.HuyHoaDon(hoadonid);
        if (result) {
            JOptionPane.showMessageDialog(this, "Hủy thành công");
            modelDonHang.setRowCount(0);
            FillToTableHoaDon();
            lsphc = sphcsv.getData();
            fillToTableDanhSachSanPham2();
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnQlHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQlHoaDonMouseClicked
        jpSanPham.setVisible(false);
        jpHoaDon.setVisible(false);
        btnQlHoaDon.setBackground(Color.red);
        jpMainSanPham.setVisible(false);
        jpQuanLyHoaDon.setVisible(true);
        btnSanPhamMain.setBackground(new Color(255, 204, 204));
        btnSanPham.setBackground(new Color(255, 204, 204));
        btnHoaDon.setBackground(new Color(255, 204, 204));
        jpQuanLyKhuyenMai.setVisible(false);
        btnQLKhuyenMai.setBackground(new Color(255, 204, 204));
        btnQLNhanVien.setBackground(new Color(255, 204, 204));
        jpQuanLyNhanVien.setVisible(false);
        jpQuanLyKhachHang.setVisible(false);
        btnQLKhachHang.setBackground(new Color(255, 204, 204));
        btnQLThongKe.setBackground(new Color(255, 204, 204));
        jpQuanLyThongKe.setVisible(false);
        jpQuanLyHoaDon.removeAll();
        jpQuanLyHoaDon.add(new QuanLyHoaDon().getContentPane());
    }//GEN-LAST:event_btnQlHoaDonMouseClicked

    private void btnQLKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLKhuyenMaiMouseClicked
        jpSanPham.setVisible(false);
        jpHoaDon.setVisible(false);
        btnQlHoaDon.setBackground(new Color(255, 204, 204));
        jpMainSanPham.setVisible(false);
        jpQuanLyHoaDon.setVisible(false);
        jpQuanLyKhuyenMai.setVisible(true);
        btnQLKhuyenMai.setBackground(Color.red);
        btnQLNhanVien.setBackground(new Color(255, 204, 204));
        jpQuanLyNhanVien.setVisible(false);
        btnSanPhamMain.setBackground(new Color(255, 204, 204));
        btnSanPham.setBackground(new Color(255, 204, 204));
        btnHoaDon.setBackground(new Color(255, 204, 204));
        jpQuanLyKhachHang.setVisible(false);
        btnQLKhachHang.setBackground(new Color(255, 204, 204));
        btnQLThongKe.setBackground(new Color(255, 204, 204));
        jpQuanLyThongKe.setVisible(false);
        jpQuanLyKhuyenMai.removeAll();
        jpQuanLyKhuyenMai.add(new QuanLyKhuyenMai().getContentPane());

    }//GEN-LAST:event_btnQLKhuyenMaiMouseClicked

    private void btnApDungMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApDungMaActionPerformed
        KhuyenMaiService kms = new KhuyenMaiService();
        KhuyenMai km = kms.findDataKhuyenMai(txtMaGiamGia.getText());
        if (km.getKhuyenMaiId() == 0) {
            JOptionPane.showMessageDialog(this, "Mã không tồn tại");
            return;
        }
        if (km.getSoluongma() == 0) {
            JOptionPane.showMessageDialog(this, "Đã hết mã giảm giá");
            return;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
        Calendar cal = Calendar.getInstance();
        String timeHienTai = dateFormat.format(cal.getTime());
        String timeBatDau = km.getNgaybatdau();
        String timeKetThuc = km.getNgayketthuc();
//        System.out.println(timeHienTai);
//        System.out.println(timeKetThuc);
//        System.out.println(timeBatDau);
        SimpleDateFormat sdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        try {
            Date dateHienTai = sdateFormat.parse(timeHienTai);
            Date dateKetThuc = sdateFormat.parse(timeKetThuc);
            Date dateBatDau = sdateFormat.parse(timeBatDau);
            if ((dateHienTai.before(dateKetThuc) || dateHienTai.equals(dateKetThuc)) && (dateHienTai.after(dateBatDau) || dateHienTai.equals(dateBatDau))) {
                if (km.isHinhThucGiamGia() == false) {
                    float tienhang = Float.parseFloat(lblTest.getText()) - Float.parseFloat(km.getMucGiamGia());
                    if (tienhang < 0) {
                        JOptionPane.showMessageDialog(this, "Mã giảm giá vượt quá giá trị đơn hàng");
                        return;
                    }
                    lblTest.setText(tienhang + "");
                    DecimalFormat decimalFormat2 = new DecimalFormat("###,### VND");
                    lblTienHang.setText(decimalFormat2.format(tienhang));
                    lblCanTra.setText(decimalFormat2.format(tienhang));
                    JOptionPane.showMessageDialog(this, "Áp dụng mã giảm giá thành công");
                    btnApDungMa.setEnabled(false);
                    btnLamMoiMa.setEnabled(true);
                    txtMaGiamGia.setEnabled(false);
                } else {
                    String mucgiam = km.getMucGiamGia();
                    float mucgiamchuyendoi = (float) (Float.parseFloat(mucgiam.replace("%", "")) / 100.0);
                    float tienhanggoc = Float.parseFloat(lblTest.getText());
                    float tienhang = tienhanggoc - (tienhanggoc * mucgiamchuyendoi);
                    if (tienhang < 0) {
                        JOptionPane.showMessageDialog(this, "Mã giảm giá vượt quá giá trị đơn hàng");
                        return;
                    }
                    lblTest.setText(tienhang + "");
                    DecimalFormat decimalFormat2 = new DecimalFormat("###,### VND");
                    lblTienHang.setText(decimalFormat2.format(tienhang));
                    lblCanTra.setText(decimalFormat2.format(tienhang));
                    JOptionPane.showMessageDialog(this, "Áp dụng mã giảm giá thành công");
                    btnApDungMa.setEnabled(false);
                    btnLamMoiMa.setEnabled(true);
                    txtMaGiamGia.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Mã này đã hết hạn hoặc chưa tới thời gian sử dụng");
            }
        } catch (ParseException ex) {
            Logger.getLogger(StoreForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_btnApDungMaActionPerformed

    private void btnQLNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLNhanVienMouseClicked
        jpSanPham.setVisible(false);
        jpHoaDon.setVisible(false);
        btnQlHoaDon.setBackground(new Color(255, 204, 204));
        jpMainSanPham.setVisible(false);
        jpQuanLyHoaDon.setVisible(false);
        jpQuanLyKhuyenMai.setVisible(false);
        jpQuanLyNhanVien.setVisible(true);
        btnQLKhuyenMai.setBackground(new Color(255, 204, 204));
        btnSanPhamMain.setBackground(new Color(255, 204, 204));
        btnSanPham.setBackground(new Color(255, 204, 204));
        btnHoaDon.setBackground(new Color(255, 204, 204));
        jpQuanLyKhachHang.setVisible(false);
        btnQLKhachHang.setBackground(new Color(255, 204, 204));
        btnQLNhanVien.setBackground(Color.red);
        btnQLThongKe.setBackground(new Color(255, 204, 204));
        jpQuanLyThongKe.setVisible(false);
        jpQuanLyNhanVien.removeAll();
        jpQuanLyNhanVien.add(new QuanLyNhanVien().getContentPane());
    }//GEN-LAST:event_btnQLNhanVienMouseClicked

    private void btnQLKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLKhachHangMouseClicked
        jpSanPham.setVisible(false);
        jpHoaDon.setVisible(false);
        btnQlHoaDon.setBackground(new Color(255, 204, 204));
        jpMainSanPham.setVisible(false);
        jpQuanLyHoaDon.setVisible(false);
        jpQuanLyKhuyenMai.setVisible(false);
        jpQuanLyNhanVien.setVisible(false);
        jpQuanLyKhachHang.setVisible(true);
        btnQLKhachHang.setBackground(Color.red);
        btnQLKhuyenMai.setBackground(new Color(255, 204, 204));
        btnSanPhamMain.setBackground(new Color(255, 204, 204));
        btnSanPham.setBackground(new Color(255, 204, 204));
        btnHoaDon.setBackground(new Color(255, 204, 204));
        btnQLNhanVien.setBackground(new Color(255, 204, 204));
        btnQLThongKe.setBackground(new Color(255, 204, 204));
        jpQuanLyThongKe.setVisible(false);
        jpQuanLyKhachHang.removeAll();
        jpQuanLyKhachHang.add(new QuanLyKhachHang().getContentPane());
    }//GEN-LAST:event_btnQLKhachHangMouseClicked

    private void btnQLThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLThongKeMouseClicked
        jpSanPham.setVisible(false);
        jpHoaDon.setVisible(false);
        btnQlHoaDon.setBackground(new Color(255, 204, 204));
        jpMainSanPham.setVisible(false);
        jpQuanLyHoaDon.setVisible(false);
        jpQuanLyKhuyenMai.setVisible(false);
        jpQuanLyNhanVien.setVisible(false);
        jpQuanLyKhachHang.setVisible(false);
        btnQLKhachHang.setBackground(new Color(255, 204, 204));
        btnQLKhuyenMai.setBackground(new Color(255, 204, 204));
        btnSanPhamMain.setBackground(new Color(255, 204, 204));
        btnSanPham.setBackground(new Color(255, 204, 204));
        btnHoaDon.setBackground(new Color(255, 204, 204));
        btnQLNhanVien.setBackground(new Color(255, 204, 204));
        btnQLThongKe.setBackground(Color.red);
        jpQuanLyThongKe.setVisible(true);
        jpQuanLyThongKe.removeAll();
        jpQuanLyThongKe.add(new QuanLyThongKe().getContentPane());
    }//GEN-LAST:event_btnQLThongKeMouseClicked

    private void btnLamMoiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiMaActionPerformed
        KhuyenMaiService kms = new KhuyenMaiService();
        KhuyenMai km = kms.findDataKhuyenMai(txtMaGiamGia.getText());
        if (km.isHinhThucGiamGia() == false) {
            float tienhang = Float.parseFloat(lblTest.getText()) + Float.parseFloat(km.getMucGiamGia());
            lblTest.setText(tienhang + "");
            DecimalFormat decimalFormat2 = new DecimalFormat("###,### VND");
            lblTienHang.setText(decimalFormat2.format(tienhang));
            lblCanTra.setText(decimalFormat2.format(tienhang));
            JOptionPane.showMessageDialog(this, "Làm mới thành công");
            txtMaGiamGia.setText("");
            btnApDungMa.setEnabled(true);
            btnLamMoiMa.setEnabled(false);
            txtMaGiamGia.setEnabled(true);
        } else {
            String mucgiam = km.getMucGiamGia();
            float mucgiamchuyendoi = (float) (Float.parseFloat(mucgiam.replace("%", "")) / 100.0);
            float tienhanggoc = Float.parseFloat(lblTest.getText());
            float tienhang = tienhanggoc / (1 - mucgiamchuyendoi);
            lblTest.setText(tienhang + "");
            DecimalFormat decimalFormat2 = new DecimalFormat("###,### VND");
            lblTienHang.setText(decimalFormat2.format(tienhang));
            lblCanTra.setText(decimalFormat2.format(tienhang));
            JOptionPane.showMessageDialog(this, "Làm mới thành công");
            txtMaGiamGia.setText("");
            btnApDungMa.setEnabled(true);
            btnLamMoiMa.setEnabled(false);
            txtMaGiamGia.setEnabled(true);
        }
    }//GEN-LAST:event_btnLamMoiMaActionPerformed

    private void txtTimKiemBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemBanHangActionPerformed
        lsphc = sphcsv.getDataSearchSPHC(txtTimKiemBanHang.getText());
        fillToTableDanhSachSanPham2();
    }//GEN-LAST:event_txtTimKiemBanHangActionPerformed

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnThoatMouseClicked

    private void txtTimKiemMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMainMouseClicked
        cboTimKiemPhanLoaiMain.setSelectedIndex(0);
    }//GEN-LAST:event_txtTimKiemMainMouseClicked

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        cboHangStore.setSelectedIndex(0);
        cboMauSacStore.setSelectedIndex(0);
        cboPhanLoaiStore.setSelectedIndex(0);
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void cboHangStoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboHangStoreMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cboHangStoreMouseEntered

    private void btnLamMoi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoi2ActionPerformed
        lsphc = sphcsv.getData();
        fillToTableDanhSachSanPham2();
        txtTimKiemBanHang.setText("");
    }//GEN-LAST:event_btnLamMoi2ActionPerformed

    private void cboChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboChatLieuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StoreForm().setVisible(true);
                } catch (DocumentException ex) {
                    Logger.getLogger(StoreForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(StoreForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSanPham;
    private javax.swing.JButton btnAddSanPhamMain;
    private javax.swing.JButton btnApDungMa;
    private javax.swing.JPanel btnHoaDon;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi2;
    private javax.swing.JButton btnLamMoiMa;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnMoiSanPhamMain;
    private javax.swing.JPanel btnQLKhachHang;
    private javax.swing.JPanel btnQLKhuyenMai;
    private javax.swing.JPanel btnQLNhanVien;
    private javax.swing.JPanel btnQLThongKe;
    private javax.swing.JPanel btnQlHoaDon;
    private javax.swing.JLabel btnQuanLyHoaDon;
    private javax.swing.JButton btnQuetQr;
    private javax.swing.JPanel btnSanPham;
    private javax.swing.JPanel btnSanPhamMain;
    private javax.swing.JButton btnSuaSanPham;
    private javax.swing.JButton btnSuaSanPhamMain;
    private javax.swing.JButton btnSuaSoLuong;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JPanel btnThoat;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboHang;
    private javax.swing.JComboBox<String> cboHangStore;
    private javax.swing.JComboBox<String> cboKichThuoc;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboMauSacStore;
    private javax.swing.JComboBox<String> cboPTThanhToan;
    private javax.swing.JComboBox<String> cboPhanLoai;
    private javax.swing.JComboBox<String> cboPhanLoaiMain;
    private javax.swing.JComboBox<String> cboPhanLoaiStore;
    private javax.swing.JComboBox<String> cboTimKiemPhanLoaiMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel jlbPickAnh;
    private javax.swing.JPanel jpHoaDon;
    private javax.swing.JPanel jpMainSanPham;
    private javax.swing.JPanel jpQuanLyHoaDon;
    private javax.swing.JPanel jpQuanLyKhachHang;
    private javax.swing.JPanel jpQuanLyKhuyenMai;
    private javax.swing.JPanel jpQuanLyNhanVien;
    private javax.swing.JPanel jpQuanLyThongKe;
    private javax.swing.JPanel jpSanPham;
    private javax.swing.JLabel lblCanTra;
    private javax.swing.JLabel lblTest;
    private javax.swing.JLabel lblTienHang;
    private javax.swing.JTable tblDanhSachSanPham2;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPhamMain;
    private javax.swing.JTable tblStore;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaGiamGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JTextField txtTenSpMain;
    private javax.swing.JTextField txtTenTaiKhoan;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemBanHang;
    private javax.swing.JTextField txtTimKiemMain;
    // End of variables declaration//GEN-END:variables

    public void fillToTable() {
        model.setRowCount(0);
        for (SanPhamHoanChinh i : lsphc) {
//            ImageIcon imic = new ImageIcon( new ImageIcon(i.getAnh()).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            DecimalFormat decimalFormat = new DecimalFormat("###,### VND");
            String formattedAmount = decimalFormat.format(i.getGiaTien());
            model.addRow(new Object[]{i.getSanPhamId(), i.getTenSanPham(), i.getPhanLoai(), i.getKichThuoc(), i.getMauSac(), i.getChatLieu(), formattedAmount, i.getSoLuong(), i.getAnh()});
            tblStore.getColumnModel().getColumn(8).setCellRenderer(new ImageRender());
            
        }
    }
    
    private class ImageRender extends DefaultTableCellRenderer {
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String photoName = value.toString();
            ImageIcon imic = new ImageIcon(new ImageIcon(photoName).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            return new JLabel(imic);
        }
        
    }
    
    private void fillComBoBox() {
        modelCombo.removeAllElements();
        ttsp = ttspsv.getData();
        for (ThuocTinhSanPham i : ttsp) {
            modelCombo.addElement(i);
        }
        
    }
    
    private void SelectImage() {
        JFileChooser choosefile = new JFileChooser();
        int result = choosefile.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File getImage = choosefile.getSelectedFile();
            ImageIcon imgIcon = new ImageIcon(getImage.getAbsolutePath());
            jlbPickAnh.setText("");
            urlAnh = imgIcon.toString();
            Image img = imgIcon.getImage().getScaledInstance(jlbPickAnh.getWidth(), jlbPickAnh.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imic = new ImageIcon(img);
            jlbPickAnh.setIcon(imic);
            
        }
    }
    
    public ChiTietSanPham getDataSanPhamChiTietInForm() {
        MauSac ms = (MauSac) cboMauSac.getSelectedItem();
        ChatLieu cl = (ChatLieu) cboChatLieu.getSelectedItem();
        KichThuoc kt = (KichThuoc) cboKichThuoc.getSelectedItem();
        Hang h = (Hang) cboHang.getSelectedItem();
        String anh = jlbPickAnh.getIcon().toString();
        ChiTietSanPham ctsp = new ChiTietSanPham(1, ms.getMausacid(), kt.getKichthuocid(), h.getHangid(), cl.getChatlieuid(), Float.parseFloat(txtGiaTien.getText()), Integer.parseInt(txtSoLuong.getText()), true, null, null, urlAnh);
        return ctsp;
    }
    
    public SanPham getDataSanPhamInForm() {
        Object phanloai = cboPhanLoai.getSelectedItem();
        SanPham sp = new SanPham(1, 0, phanloai + "", txtTenSp.getText(), null, null);
        
        return sp;
    }
    
    public void fillToTableDonHang() {
//        DonHang dh = (DonHang) cboMaDonHang.getSelectedItem();
        float tongtien = 0;
        modelDonHang.setRowCount(0);
        
        for (DonHangSanPhamHoanChinh i : ldhsphc) {
            DecimalFormat decimalFormat = new DecimalFormat("###,###");
            String formattedAmount = decimalFormat.format(i.getGiaTien());
            String thanhtien = decimalFormat.format(i.getGiaTien() * i.getSoLuong());
            modelDonHang.addRow(new Object[]{i.getSanPhamSanPhamChiTietId(), i.getTenSanPham(), i.getMausac(), i.getChatlieu(), i.getKichThuoc(), i.getSoLuong(), formattedAmount, i.isTrangThaiDonHang() == false ? "Chờ" : "Đã thêm vào hóa đơn", thanhtien});
            tongtien += (i.getGiaTien() * i.getSoLuong());
        }
        DecimalFormat decimalFormat2 = new DecimalFormat("###,### VND");
        lblTienHang.setText(decimalFormat2.format(tongtien));
        lblCanTra.setText(decimalFormat2.format(tongtien));
        lblTest.setText(tongtien + "");
    }
    
    public void BanHang() {
        modelTableHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        modelHoaDon = (DefaultTableModel) tblDanhSachSanPham2.getModel();
        tblHoaDon.setRowHeight(25);
        modelDonHang = (DefaultTableModel) tblGioHang.getModel();
        tblGioHang.setRowHeight(25);
        modelcboPhuongThucTT = (DefaultComboBoxModel) cboPTThanhToan.getModel();
//        fillToComBoBoxDonHang();
        FillToTableHoaDon();
        lsphc = sphcsv.getData();
        fillToTableDanhSachSanPham2();
//        fillToTableDonHang();
        fillToComBoBoxPhuongThucTT();
        tblDanhSachSanPham2.setRowHeight(50);
        modelDonHang.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (tblGioHang.isEditing()) {
                    String value = (String) tblGioHang.getValueAt(tblGioHang.getSelectedRow(), 2);
                    edittable = true;
                }
                
            }
        });
        
    }
    
    public void fillToComBoBoxDonHang() {
        ldh = dhs.getDataFollowTrangThai();
        cboMaDonModel.removeAllElements();
        for (DonHang i : ldh) {
            cboMaDonModel.addElement(i);
        }
    }
    
    public void fillToComBoBoxPhuongThucTT() {
        lpttt = ptttsv.getData();
        modelcboPhuongThucTT.removeAllElements();
        for (PhuongThucThanhToan i : lpttt) {
            modelcboPhuongThucTT.addElement(i);
        }
    }
    
    public void fillToTableDanhSachSanPham2() {
        modelHoaDon.setRowCount(0);
        for (SanPhamHoanChinh i : lsphc) {
            DecimalFormat decimalFormat2 = new DecimalFormat("###,###");
//            ImageIcon imic = new ImageIcon( new ImageIcon(i.getAnh()).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            modelHoaDon.addRow(new Object[]{i.getSanPhamSanPhamChiTetId(), i.getTenSanPham(), i.getPhanLoai(), i.getKichThuoc(), i.getMauSac(), i.getChatLieu(), decimalFormat2.format(i.getGiaTien()), i.getSoLuong(), i.getAnh()});
            tblDanhSachSanPham2.getColumnModel().getColumn(8).setCellRenderer(new ImageRender());
            
        }
    }
    
    public KhachHang getDataKhachHangInForm() {
        KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
        kh.setSoDienThoai(txtSDT.getText());
        return kh;
    }
    
    public HoaDon getHoaDonInForm() {
        HoaDon hd = new HoaDon();
        hd.setNguoiTao(idtaikhoan);
        hd.setTrangThai(false);
        hd.setTrangThaiHienThi(true);
        return hd;
    }
    
    public void FillToTableHoaDon() {
        List<HoaDon> lhd = new ArrayList<>();
        lhd = hds.showDataHoaDon();
        modelTableHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        modelTableHoaDon.setRowCount(0);
        for (HoaDon i : lhd) {
            modelTableHoaDon.addRow(new Object[]{i.getHoaDonId(), i.getNguoiTao(), i.getHoTenKhachHang(), i.isTrangThai() == false ? "Chờ thanh toán" : "Đã thanh toán", i.getCreated_at()});
        }
    }

    //Quản Lý Sản Phẩm
    public void SanPhamMain() {
        tblSanPhamMain.setRowHeight(30);
        List<SanPham> lsp = sps.getDataSanPham();
        lspmain = lsp;
        fillToTableSanPhamMain(lspmain);
    }
    
    public void fillToTableSanPhamMain(List<SanPham> lsp) {
        DefaultTableModel modelSanPhamMain = new DefaultTableModel();
        modelSanPhamMain = (DefaultTableModel) tblSanPhamMain.getModel();
        modelSanPhamMain.setRowCount(0);
        for (SanPham i : lsp) {
            modelSanPhamMain.addRow(new Object[]{i.getSanPhamId(), i.getTenSanPham(), i.getPhanLoai()});
        }
    }
    
    public void fillTxtSanPham() {
        txtTenSp.setText(SanPhamFormQuanLiSp.getTenSanPham());
        cboPhanLoai.setSelectedItem(SanPhamFormQuanLiSp.getPhanLoai());
    }
    
    public HoaDon getDataHoaDon() {
        PhuongThucThanhToan pttt = (PhuongThucThanhToan) cboPTThanhToan.getSelectedItem();
        KhachHang kh2 = khs.findDataKhachHang(txtSDT.getText());
        if (kh2.getKhachHangId() == 0) {
            ThongTinKhachHang.sdt = txtSDT.getText();
            new ThongTinKhachHang(this, true).setVisible(true);
            
        }
        KhachHang kh3 = khs.findDataKhachHang(txtSDT.getText());
        if (kh3.getSolanmuahang() == 0) {
            KhachHang kh4 = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
            kh4.setSolanmuahang(1);
            kh4.setTonggiatridamua(Float.parseFloat(lblTest.getText()));
            kh4.setKhachHangId(kh3.getKhachHangId());
            khs.updateDataMua(kh4);
        } else {
            KhachHang kh4 = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
            kh4.setSolanmuahang(kh3.getSolanmuahang() + 1);
            kh4.setTonggiatridamua(kh3.getTonggiatridamua() + Float.parseFloat(lblTest.getText()));
            kh4.setKhachHangId(kh3.getKhachHangId());
            khs.updateDataMua(kh4);
        }
        HoaDon hd = new HoaDon();
        hd.setKhachHangId(kh3.getKhachHangId());
        hd.setTongTien(Float.parseFloat(lblTest.getText()));
        hd.setPhuongThucThanhToanId(pttt.getId());
        hd.setNguoiTao(idtaikhoan);
        hd.setHoTenKhachHang(kh3.getHoTen());
        return hd;
    }

//    public HoaDon luuHoaDon() {
//        PhuongThucThanhToan pttt = (PhuongThucThanhToan) cboPTThanhToan.getSelectedItem();
//        HoaDon hd = new HoaDon();
//        hd.setTongTien(Float.parseFloat(lblTienHang.getText()));
//        hd.setPhuongThucThanhToanId(pttt.getId());
//        return hd;
//    }
}
