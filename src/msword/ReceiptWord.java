package msword;

import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hwpf.HWPFDocument;

public class ReceiptWord extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    class TThread1 extends Thread {
 
        public void run() {
            String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator");
            HWPFDocument doc = null;
            try (FileInputStream fis = new FileInputStream(dir + "receipt_template.doc")) {
                doc = new HWPFDocument(fis);
                fis.close();
            } catch (Exception ex) {
                System.err.println("Error template!");
            }
 
            try {
                doc.getRange().replaceText("$ФИОплательщика", jTextField1.getText());
                doc.getRange().replaceText("$Лицевойсчет", jTextField2.getText());
            } catch (Exception ex) {
                System.err.println("Error replaceText!");
            }
 
            try (FileOutputStream fos = new FileOutputStream(dir + "receipt.doc")) {
                doc.write(fos);
                fos.close();
                Desktop.getDesktop().open(new File(dir + "receipt.doc"));
            } catch (Exception ex) {
                System.err.println("Error getDesktop!");
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
 
    Thread tThread1;


    public ReceiptWord() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Квитанция ");
        getContentPane().setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(350, 170, 200, 20);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(370, 120, 150, 20);

        jButton1.setText("в WORD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 380, 120, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/msword/receipt.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, 0, 1080, 440);

        setSize(new java.awt.Dimension(678, 458));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new TThread1().start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceiptWord().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
