/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Service.KhuyenMaiService;
import Service.ValidateService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhuyenMai;

/**
 *
 * @author TB
 */
public class QuanLyKhuyenMai extends javax.swing.JFrame {

    KhuyenMaiService kms = new KhuyenMaiService();
    List<KhuyenMai> lkm = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form QuanLyKhuyenMai
     */
    public QuanLyKhuyenMai() {
        initComponents();
        tblKhuyenMai.setRowHeight(30);
        model = (DefaultTableModel) tblKhuyenMai.getModel();
        fillToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenChuongTrinh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cboHinhThucGiamGia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMucGiamGia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSoLuongMa = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdThoiGianBatDau = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jdThoiGianKetThuc = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        btnTaoMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tạo Khuyến Mại"));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Tạo Mã Khuyến Mãi");

        jLabel2.setText("Tên Chương Trình Khuyến Mãi");

        jLabel3.setText("Hình Thức Giảm Giá");

        cboHinhThucGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm Theo Tiền", "Giảm Theo %" }));

        jLabel4.setText("Mức Giảm Giá");

        jLabel8.setText("Số Lượng Mã");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuongMa)
                    .addComponent(txtMaKhuyenMai)
                    .addComponent(txtTenChuongTrinh)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cboHinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(txtMucGiamGia))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(157, 157, 157)
                                .addComponent(jLabel4)))
                        .addGap(0, 165, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtSoLuongMa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Thời Gian Sử Dụng");

        jLabel6.setText("Thời Gian Bắt Đầu");

        jdThoiGianBatDau.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        jLabel7.setText("Thời Gian Kết Thúc");

        jdThoiGianKetThuc.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        btnTaoMoi.setBackground(new java.awt.Color(255, 204, 204));
        btnTaoMoi.setText("Tạo Mới");
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 204, 204));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(255, 204, 204));
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jdThoiGianBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdThoiGianKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdThoiGianBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jdThoiGianKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Các Khuyến Mại"));

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Khuyến Mãi", "Tên Chượng Trình", "Hình Thức Giảm Giá", "Giảm Giá", "Số Lượng Mã", "Ngày Bắt Đầu", "Ngày Kết Thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);
        if (tblKhuyenMai.getColumnModel().getColumnCount() > 0) {
            tblKhuyenMai.getColumnModel().getColumn(0).setResizable(false);
            tblKhuyenMai.getColumnModel().getColumn(1).setResizable(false);
            tblKhuyenMai.getColumnModel().getColumn(2).setResizable(false);
            tblKhuyenMai.getColumnModel().getColumn(3).setResizable(false);
            tblKhuyenMai.getColumnModel().getColumn(4).setResizable(false);
            tblKhuyenMai.getColumnModel().getColumn(5).setResizable(false);
            tblKhuyenMai.getColumnModel().getColumn(6).setResizable(false);
        }

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(70, 70, 70)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        if (validateForm() == false) {
            return;
        }
        if (checkTrung() == false) {
            return;
        }
        boolean result = kms.addDataKhuyenMai(getDataKhuyenMai());
        if (result) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        int index = tblKhuyenMai.getSelectedRow();
        txtMaKhuyenMai.setEnabled(false);
        KhuyenMai km = lkm.get(index);
        txtMaKhuyenMai.setText(km.getMaKhuyenMai());
        txtMucGiamGia.setText(km.getMucGiamGia());
        txtTenChuongTrinh.setText(km.getTenChuongTrinhKhuyenMai());
        txtSoLuongMa.setText(km.getSoluongma() + "");
        int htgg = km.isHinhThucGiamGia() == false ? 0 : 1;
        cboHinhThucGiamGia.setSelectedIndex(htgg);
        SimpleDateFormat sdateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        try {
            jdThoiGianBatDau.setDate(sdateformat.parse(km.getNgaybatdau()));
            jdThoiGianKetThuc.setDate(sdateformat.parse(km.getNgayketthuc()));
        } catch (ParseException ex) {
            Logger.getLogger(QuanLyKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if( validateForm() == false)
        {
            return;
        }
        KhuyenMai km = getDataKhuyenMai();
        int index = tblKhuyenMai.getSelectedRow();
        KhuyenMai km1 = lkm.get(index);
        km.setKhuyenMaiId(km1.getKhuyenMaiId());
        boolean result = kms.updateDataKhuyenMai(km);
        if (result) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            fillToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMaKhuyenMai.setEnabled(true);
        txtMaKhuyenMai.setText("");
        txtMucGiamGia.setText("");
        txtTenChuongTrinh.setText("");
        txtSoLuongMa.setText("");
        cboHinhThucGiamGia.setSelectedIndex(0);
    }//GEN-LAST:event_btnLamMoiActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhuyenMai().setVisible(true);
            }
        });
    }

    public KhuyenMai getDataKhuyenMai() {
        KhuyenMai km = new KhuyenMai();
        km.setMaKhuyenMai(txtMaKhuyenMai.getText());
        km.setMucGiamGia(txtMucGiamGia.getText());
        km.setTenChuongTrinhKhuyenMai(txtTenChuongTrinh.getText());
        km.setHinhThucGiamGia(cboHinhThucGiamGia.getSelectedIndex() == 0 ? false : true);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String timeBatDau = dateFormat.format(jdThoiGianBatDau.getDate());
        String timeKetThuc = dateFormat.format(jdThoiGianKetThuc.getDate());
        km.setNgaybatdau(timeBatDau);
        km.setNgayketthuc(timeKetThuc);
        km.setTrangThaiMa(true);
        km.setSoluongma(Integer.parseInt(txtSoLuongMa.getText()));
        return km;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JComboBox<String> cboHinhThucGiamGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private com.toedter.calendar.JDateChooser jdThoiGianBatDau;
    private com.toedter.calendar.JDateChooser jdThoiGianKetThuc;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtMucGiamGia;
    private javax.swing.JTextField txtSoLuongMa;
    private javax.swing.JTextField txtTenChuongTrinh;
    // End of variables declaration//GEN-END:variables

    private void fillToTable() {
        model.setRowCount(0);
        lkm = kms.getDataKhuyenMai();
        for (KhuyenMai i : lkm) {
            model.addRow(new Object[]{i.getMaKhuyenMai(), i.getTenChuongTrinhKhuyenMai(), i.isHinhThucGiamGia() == false ? "Giảm theo tiền" : "Giảm theo %", i.getMucGiamGia(), i.getSoluongma(), i.getNgaybatdau(), i.getNgayketthuc()});
        }
    }

    public boolean checkTrung() {
        ValidateService vls = new ValidateService();
        lkm = kms.getDataKhuyenMai();
        for (KhuyenMai i : lkm) {
            if (vls.checkTrung(i.getMaKhuyenMai(), txtMaKhuyenMai.getText()) == false) {
                JOptionPane.showMessageDialog(this, "Mã khuyễn mãi đã tồn tại");
                return false;
            }
        }
        return true;
    }

    public boolean validateForm() {
    
        ValidateService vls = new ValidateService();
        String[] mang = {txtMaKhuyenMai.getText(), txtSoLuongMa.getText(), txtTenChuongTrinh.getText(), txtMucGiamGia.getText()};
        if (vls.checkRongMang(mang) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống các trường");
            return false;
        }
        if (cboHinhThucGiamGia.getSelectedIndex() == 1) {
            if (vls.checkKiTu(txtMucGiamGia.getText()) == false) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng phải là số kèm đơn vị %");
                return false;
            }
        } else {
            if (vls.checkSoNguyen(txtMucGiamGia.getText()) == false) {
                JOptionPane.showMessageDialog(this, "Giá tiền phải là số nguyên");
                return false;
            } else if (Integer.parseInt(txtMucGiamGia.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Giá tiền phải lớn hơn 0");
                return false;
            }
        }
        if (jdThoiGianBatDau.getDate() == null || jdThoiGianKetThuc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ ô thời gian");
            return false;
        }
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String timeBatDau = dateFormat.format(jdThoiGianBatDau.getDate());
        String timeKetThuc = dateFormat.format(jdThoiGianKetThuc.getDate());
        if (timeBatDau.equals(timeKetThuc)) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại trường thời gian");
            return false;
        } else if (timeBatDau.compareTo(timeKetThuc) < 0) {
            return true;
            
        } else {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại trường thời gian");
            return false;
        }
//        return true;
    }
}
