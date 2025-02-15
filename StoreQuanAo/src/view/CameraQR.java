/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Service.ChiTietSanPhamService;
import Service.DonHangSanPhamHoanChinhService;
import Service.DonHangSanPhamService;
import Service.DonHangService;
import Service.HoaDonService;
import Service.SanPhamHoanChinhService;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.DonHang;
import model.DonHangSanPham;
import model.DonHangSanPhamHoanChinh;
import model.HoaDon;
import model.SanPhamHoanChinh;
import static view.StoreForm.ldhsphc;

/**
 *
 * @author TB
 */
public class CameraQR extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;
    List<HoaDon> lhd = new ArrayList<>();
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    DefaultComboBoxModel cboMaDonModel = new DefaultComboBoxModel();
    DonHangService dhs = new DonHangService();
    DonHangSanPhamService dhspsv = new DonHangSanPhamService();
    HoaDonService hds = new HoaDonService();
    DonHangSanPhamHoanChinhService dhsphcsv = new DonHangSanPhamHoanChinhService();
    ChiTietSanPhamService ctspsv = new ChiTietSanPhamService();
    SanPhamHoanChinhService sphcsv = new SanPhamHoanChinhService();

    /**
     * Creates new form CameraQR
     */
    public CameraQR() {
        initComponents();
        initWebcam();
        setLocationRelativeTo(null);
        fillToComBoBoxDonHang();
        result_text.setVisible(false);
        System.out.println(StoreForm.dataStatic);
    }

    public void fillToComBoBoxDonHang() {
        lhd = hds.showDataHoaDon();
        cboMaDonModel.removeAllElements();
        for (HoaDon i : lhd) {
            cboMaDonModel.addElement(i);
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

        webPanel = new javax.swing.JPanel();
        result_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        webPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        webPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        result_text.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(webPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(result_text, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(webPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(result_text, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CameraQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CameraQR().setVisible(true);
            }
        });
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }
            if (result != null) {
                result_text.setText(result.getText());

            }
            addData();
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;

    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        System.out.println(panel);
        webPanel.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 290));

        executor.execute(this);
    }

    public void addData() {
        if (!result_text.getText().equals("")) {
            int quyetdinh = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm sản phẩm vào giỏ hàng không? ");
            if (quyetdinh == JOptionPane.YES_OPTION) {
                DonHangSanPham dhsp = new DonHangSanPham();
                
                  try{
                    int test = Integer.parseInt(result_text.getText());
                }catch(Exception e)
                {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại");
                    return;
                }
                
                dhsp.setSanPhamSanPhamChiTietId(Integer.parseInt(result_text.getText()));
                dhsp.setHoaDonId(StoreForm.dataStatic);
                String soluong = JOptionPane.showInputDialog(this, "Nhập số lượng");
                DonHangSanPhamHoanChinh dhsphc = dhsphcsv.findDataHoaDonFollowIdandSanPhamSPCT(StoreForm.dataStatic, dhsp.getSanPhamSanPhamChiTietId());
                SanPhamHoanChinh sphc = sphcsv.findDataFollowSanPhamSanPhamChiTietId(dhsp.getSanPhamSanPhamChiTietId());
              
                if(sphc.getSanPhamId() == null)
                {
                    JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại");
                    result_text.setText("");
                    return;
                }

                if (Integer.parseInt(soluong) > sphc.getSoLuong()) {
                    JOptionPane.showMessageDialog(this, "Sản phẩm chỉ còn: " + sphc.getSoLuong());
                    result_text.setText("");
                    return;
                }
//                
                dhsp.setSoLuong(Integer.parseInt(soluong));

                if (dhsphc.getHoaDonId() != 0) {
                    dhsp.setSoLuong(Integer.parseInt(soluong) + dhsphc.getSoLuong());
                    boolean result = dhspsv.udateData(dhsp);
                    System.out.println(dhsphc.getSoLuongSanPhamGoc() + "Duy nèee");
                    ctspsv.updateChiTietSanPham(dhsphc.getSoLuongSanPhamGoc() - Integer.parseInt(soluong), dhsphc.getChiTietSanPhamId());
                    if (result) {
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào đơn hàng thành công");
                        result_text.setText("");
                        return;
                    }
                } else {
                    boolean resultDuy = dhspsv.addData(dhsp);
                    DonHangSanPhamHoanChinh dhsphc1 = dhsphcsv.findDataHoaDonFollowIdandSanPhamSPCT(StoreForm.dataStatic, dhsp.getSanPhamSanPhamChiTietId());
                    System.out.println(dhsphc1.getSoLuongSanPhamGoc() + "Duy nèee");

                    ctspsv.updateChiTietSanPham(dhsphc1.getSoLuongSanPhamGoc() - Integer.parseInt(soluong), dhsphc1.getChiTietSanPhamId());
                    if (resultDuy) {

                        StoreForm.ldhsphc = dhsphcsv.getDataHoaDonFollowId(StoreForm.dataStatic);
//                        new StoreForm().fillToTableDonHang();
//                        new StoreForm().fillToTableDanhSachSanPham2();
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào đơn hàng thành công");
                        result_text.setText("");

                    } else {
                        result_text.setText("");
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào đơn hàng thất bại");
                    }
                }

            } else {
                result_text.setText("");
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField result_text;
    private javax.swing.JPanel webPanel;
    // End of variables declaration//GEN-END:variables
}
