/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TB
 */
public class testXuatPdf extends javax.swing.JFrame {

    Font f = new Font(BaseFont.createFont("D:\\DUAN1\\VnArial_Font_VnUnikey.com_\\vuArialBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
    Font NORMAL_FONT = new Font(BaseFont.createFont("D:\\DUAN1\\VnArial_Font_VnUnikey.com_\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
    Font Font_Nghieng = new Font(BaseFont.createFont("D:\\DUAN1\\VnArial_Font_VnUnikey.com_\\vuArialItalic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));

    /**
     * Creates new form testXuatPdf
     */
    public testXuatPdf() throws DocumentException, IOException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnpdf = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnpdf.setText("Xuất pdf");
        btnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdfActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Lê Văn Khoa", "Ăn"},
                {"Lê Văn Duy", "Ngủ"}
            },
            new String [] {
                "Họ Tên", "Sở Thích"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnpdf)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnpdf)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdfActionPerformed
        exportInvoiceToPDF();
    }//GEN-LAST:event_btnpdfActionPerformed
    private void exportInvoiceToPDF() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("D:\\DUAN1\\hoa_don.pdf"));
            document.open();

            // Tiêu đề
            addTitle(document, "Hóa Đơn Bán Hàng");
            addSubtitle(document, "Mã hóa đơn: 10");
            // Thông tin khách hàng
            addSubtitle(document, "Thông tin khách hàng");
            addKeyValue(document, "Họ tên khách hàng:", "Lê Văn Duy");
            addKeyValue(document, "Ngày Mua:", getCurrentDate());

            // Thông tin hóa đơn
            addSubtitle(document, "Thông tin hóa đơn:");
            addKeyValue(document, "Tổng tiền:", "500,000 VND");
            addKeyValue(document, "Người tạo:", "Admin");
            
            
            
             PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            //adding table headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(new Phrase(table.getColumnName(i),NORMAL_FONT));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            System.out.println(table.getRowCount());
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    pdfTable.addCell(new Phrase(table.getModel().getValueAt(rows, cols).toString(),NORMAL_FONT));

                }
            }
            document.add(pdfTable);
            addLineSeparator(document);
            kyTen(document, "Lê Văn Duy");
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
    
    public void kyTen(Document document, String nguoiki) throws DocumentException
    {
        Paragraph pg1 = new Paragraph();
        Phrase phaPhrase = new Phrase();
        phaPhrase.add(new Phrase("Người Bán \n",NORMAL_FONT));
        phaPhrase.add(new Phrase(nguoiki,NORMAL_FONT));
        phaPhrase.setFont(NORMAL_FONT);
        pg1.add(phaPhrase);
        pg1.setAlignment(Element.ALIGN_RIGHT);
        pg1.setSpacingBefore(30);
        document.add(pg1);
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
            java.util.logging.Logger.getLogger(testXuatPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testXuatPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testXuatPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testXuatPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new testXuatPdf().setVisible(true);
                } catch (DocumentException ex) {
                    Logger.getLogger(testXuatPdf.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(testXuatPdf.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnpdf;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}