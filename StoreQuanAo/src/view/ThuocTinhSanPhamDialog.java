/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import Service.ChatLieuService;
import Service.HangService;
import Service.KichThuocService;
import Service.MauSacService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.Hang;
import model.KichThuoc;
import model.MauSac;

/**
 *
 * @author TB
 */
public class ThuocTinhSanPhamDialog extends javax.swing.JDialog {

    KichThuocService kts = new KichThuocService();
    ChatLieuService cls = new ChatLieuService();
    HangService hs = new HangService();
    MauSacService mss = new MauSacService();
    DefaultTableModel modelTableMauSac = new DefaultTableModel();
    DefaultTableModel modelTableChatLieu = new DefaultTableModel();
    DefaultTableModel modelTableHang = new DefaultTableModel();
    DefaultTableModel modelTableKichThuoc = new DefaultTableModel();

    /**
     * Creates new form ThuocTinhSanPhamDialog
     */
    public ThuocTinhSanPhamDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        pnMauSac.setVisible(true);
        pnChatLieu.setVisible(false);
        pnHang.setVisible(false);
        pnKichThuoc.setVisible(false);
        modelTableMauSac = (DefaultTableModel) tblMauSac.getModel();
        modelTableKichThuoc = (DefaultTableModel) tblKichThuoc.getModel();
        modelTableHang = (DefaultTableModel) tblHang.getModel();
        modelTableChatLieu = (DefaultTableModel) tblChatLieu.getModel();
        rdoMauSac.setSelected(true);
        fillToTableMauSac();
        fillToTableKichThuoc();
        fillToTableChatLieu();
        fillToTableHang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtTenThuocTinh = new javax.swing.JTextField();
        rdoMauSac = new javax.swing.JRadioButton();
        rdoKichThuoc = new javax.swing.JRadioButton();
        rdoHang = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        pnMauSac = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        pnKichThuoc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKichThuoc = new javax.swing.JTable();
        pnHang = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHang = new javax.swing.JTable();
        pnChatLieu = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblChatLieu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thuộc tính sản phẩm"));

        txtTenThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenThuocTinhActionPerformed(evt);
            }
        });

        rdoMauSac.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoMauSac);
        rdoMauSac.setText("Màu Sắc");
        rdoMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMauSacActionPerformed(evt);
            }
        });

        rdoKichThuoc.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoKichThuoc);
        rdoKichThuoc.setText("Kích Thước");
        rdoKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKichThuocActionPerformed(evt);
            }
        });

        rdoHang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoHang);
        rdoHang.setText("Hãng");
        rdoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHangActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(255, 204, 204));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 204, 204));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setText("Mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rdoChatLieu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoChatLieu);
        rdoChatLieu.setText("Chất Liệu");
        rdoChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChatLieuActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên Thuộc Tính");

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Màu Sắc", "Tên Màu Sắc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblMauSac);

        javax.swing.GroupLayout pnMauSacLayout = new javax.swing.GroupLayout(pnMauSac);
        pnMauSac.setLayout(pnMauSacLayout);
        pnMauSacLayout.setHorizontalGroup(
            pnMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        pnMauSacLayout.setVerticalGroup(
            pnMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMauSacLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 130, Short.MAX_VALUE))
        );

        tblKichThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kích Thước", "Tên Kích Thước"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblKichThuoc);

        javax.swing.GroupLayout pnKichThuocLayout = new javax.swing.GroupLayout(pnKichThuoc);
        pnKichThuoc.setLayout(pnKichThuocLayout);
        pnKichThuocLayout.setHorizontalGroup(
            pnKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        pnKichThuocLayout.setVerticalGroup(
            pnKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKichThuocLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        tblHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Hãng", "Tên Hãng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblHang);

        javax.swing.GroupLayout pnHangLayout = new javax.swing.GroupLayout(pnHang);
        pnHang.setLayout(pnHangLayout);
        pnHangLayout.setHorizontalGroup(
            pnHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        pnHangLayout.setVerticalGroup(
            pnHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHangLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        tblChatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Chất Liệu", "Tên Chất L:iệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblChatLieu);

        javax.swing.GroupLayout pnChatLieuLayout = new javax.swing.GroupLayout(pnChatLieu);
        pnChatLieu.setLayout(pnChatLieuLayout);
        pnChatLieuLayout.setHorizontalGroup(
            pnChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        pnChatLieuLayout.setVerticalGroup(
            pnChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChatLieuLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(pnMauSac, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pnKichThuoc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pnHang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pnChatLieu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnKichThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnKichThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rdoMauSac)
                        .addGap(64, 64, 64)
                        .addComponent(rdoKichThuoc)
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btnSua)
                                .addGap(28, 28, 28)
                                .addComponent(jButton3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoChatLieu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addComponent(rdoHang)
                                .addGap(34, 34, 34)))))
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSua, btnThem, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoMauSac)
                    .addComponent(rdoKichThuoc)
                    .addComponent(rdoHang)
                    .addComponent(rdoChatLieu))
                .addGap(29, 29, 29)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenThuocTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenThuocTinhActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
//        if (rdoMauSac.isSelected()) {

        if (rdoMauSac.isSelected()) {
            if (tblMauSac.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn màu sắc tương ứng");
                return;
            }
            if (checkTrungMauSac() == false) {
                return;
            }
            int mausacid = (int) tblMauSac.getValueAt(tblMauSac.getSelectedRow(), 0);
            MauSac ms = new MauSac();
            ms.setMausacid(mausacid);
            ms.setTenmausac(txtTenThuocTinh.getText());
            boolean result = mss.updateData(ms);
            if (result) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                fillToTableMauSac();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        }
        if (rdoKichThuoc.isSelected()) {
            if (tblKichThuoc.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn kích thước tương ứng tương ứng");
                return;
            }

            if (checkTrungKichThuoc() == false) {
                return;
            }

            int kichthuocid = (int) tblKichThuoc.getValueAt(tblKichThuoc.getSelectedRow(), 0);
            KichThuoc kt = new KichThuoc();
            kt.setTenkichthuoc(txtTenThuocTinh.getText());
            kt.setKichthuocid(kichthuocid);
            boolean result = kts.updateData(kt);
            if (result) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                fillToTableKichThuoc();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        }
        if (rdoChatLieu.isSelected()) {
            if (tblChatLieu.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn chất liệu tương ứng tương ứng");
                return;
            }

            if (checkChatLieu() == false) {
                return;
            }

            int chatlieuid = (int) tblChatLieu.getValueAt(tblChatLieu.getSelectedRow(), 0);
            ChatLieu cl = new ChatLieu();
            cl.setTenchatlieu(txtTenThuocTinh.getText());
            cl.setChatlieuid(chatlieuid);
            boolean result = cls.updateData(cl);
            if (result) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                fillToTableChatLieu();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        }

        if (rdoHang.isSelected()) {
            if (tblHang.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn hãng tương ứng tương ứng");
                return;
            }
            if (checkTrungHang() == false) {
                return;
            }
            Hang h = new Hang();
            h.setTenhang(txtTenThuocTinh.getText());
            boolean result = hs.addData(h);
            if (result) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillToTableHang();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }
//        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (rdoMauSac.isSelected()) {
            if (checkTrungMauSac() == false) {
                return;
            }
            MauSac ms = new MauSac();
            ms.setTenmausac(txtTenThuocTinh.getText());
            boolean result = mss.addData(ms);
            if (result) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillToTableMauSac();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }
        if (rdoKichThuoc.isSelected()) {
            if (checkTrungKichThuoc() == false) {
                return;
            }
            KichThuoc kt = new KichThuoc();
            kt.setTenkichthuoc(txtTenThuocTinh.getText());
            boolean result = kts.addData(kt);
            if (result) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillToTableKichThuoc();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }
        if (rdoChatLieu.isSelected()) {
            if (checkChatLieu() == false) {
                return;
            }
            ChatLieu cl = new ChatLieu();
            cl.setTenchatlieu(txtTenThuocTinh.getText());
            boolean result = cls.addData(cl);
            if (result) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillToTableChatLieu();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }

        if (rdoHang.isSelected()) {
            if (checkTrungHang() == false) {
                return;
            }
            Hang h = new Hang();
            h.setTenhang(txtTenThuocTinh.getText());
            boolean result = hs.addData(h);
            if (result) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillToTableHang();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void rdoMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMauSacActionPerformed
        pnMauSac.setVisible(true);
        pnChatLieu.setVisible(false);
        pnHang.setVisible(false);
        txtTenThuocTinh.setText("");
        pnKichThuoc.setVisible(false);
    }//GEN-LAST:event_rdoMauSacActionPerformed

    private void rdoKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKichThuocActionPerformed
        pnMauSac.setVisible(false);
        pnChatLieu.setVisible(false);
        txtTenThuocTinh.setText("");
        pnHang.setVisible(false);
        pnKichThuoc.setVisible(true);
    }//GEN-LAST:event_rdoKichThuocActionPerformed

    private void rdoChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChatLieuActionPerformed
        pnMauSac.setVisible(false);
        pnChatLieu.setVisible(true);
        txtTenThuocTinh.setText("");
        pnHang.setVisible(false);
        pnKichThuoc.setVisible(false);
    }//GEN-LAST:event_rdoChatLieuActionPerformed

    private void rdoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHangActionPerformed
        pnMauSac.setVisible(false);
        pnChatLieu.setVisible(false);
        pnHang.setVisible(true);
        txtTenThuocTinh.setText("");
        pnKichThuoc.setVisible(false);
    }//GEN-LAST:event_rdoHangActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtTenThuocTinh.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked

    }//GEN-LAST:event_tblMauSacMouseClicked
    public boolean checkTrungMauSac() {
        List<MauSac> lms = mss.getData();
        for (MauSac i : lms) {
            if (i.getTenmausac().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                JOptionPane.showMessageDialog(this, "Màu này đã tồn tại");
                return false;
            }
        }
        return true;
    }

    public boolean checkTrungKichThuoc() {
        List<KichThuoc> lkt = kts.getData();
        for (KichThuoc i : lkt) {
            if (i.getTenkichthuoc().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                JOptionPane.showMessageDialog(this, "Kích thước này đã tồn tại");
                return false;
            }
        }
        return true;
    }

    public boolean checkTrungHang() {
        List<Hang> lh = hs.getData();
        for (Hang i : lh) {
            if (i.getTenhang().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                JOptionPane.showMessageDialog(this, "Hãng này đã tồn tại");
                return false;
            }
        }
        return true;
    }

    public boolean checkChatLieu() {
        List<ChatLieu> lcl = cls.getData();
        for (ChatLieu i : lcl) {
            if (i.getTenchatlieu().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                JOptionPane.showMessageDialog(this, "Chất liệu này đã tồn tại");
                return false;
            }
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(ThuocTinhSanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThuocTinhSanPhamDialog dialog = new ThuocTinhSanPhamDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void fillToTableMauSac() {
        modelTableMauSac.setRowCount(0);
        List<MauSac> lms = mss.getData();
        for (MauSac i : lms) {
            modelTableMauSac.addRow(new Object[]{i.getMausacid(), i.getTenmausac()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel pnChatLieu;
    private javax.swing.JPanel pnHang;
    private javax.swing.JPanel pnKichThuoc;
    private javax.swing.JPanel pnMauSac;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoHang;
    private javax.swing.JRadioButton rdoKichThuoc;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JTable tblChatLieu;
    private javax.swing.JTable tblHang;
    private javax.swing.JTable tblKichThuoc;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTextField txtTenThuocTinh;
    // End of variables declaration//GEN-END:variables

    private void fillToTableKichThuoc() {
        modelTableKichThuoc.setRowCount(0);
        List<KichThuoc> lkt = kts.getData();
        for (KichThuoc i : lkt) {
            modelTableKichThuoc.addRow(new Object[]{i.getKichthuocid(), i.getTenkichthuoc()});
        }

    }

    private void fillToTableChatLieu() {
        modelTableChatLieu.setRowCount(0);
        List<ChatLieu> lcl = cls.getData();
        for (ChatLieu i : lcl) {
            modelTableChatLieu.addRow(new Object[]{i.getChatlieuid(), i.getTenchatlieu()});
        }
    }

    private void fillToTableHang() {
        modelTableHang.setRowCount(0);
        List<Hang> lh = hs.getData();
        for (Hang i : lh) {
            modelTableHang.addRow(new Object[]{i.getHangid(), i.getTenhang()});
        }

    }

    public void test() {
        System.out.println("Chào các bạn");
    }
}