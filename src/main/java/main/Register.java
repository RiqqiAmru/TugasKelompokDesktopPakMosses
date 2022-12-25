/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import config.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Riqqi
 */
public class Register extends javax.swing.JFrame {

  CRUD crud;
  Login login;
  public boolean success[] = new boolean[5];

  /**
   * Creates new form Register
   */
  public Register() {
    initComponents();
    crud = new CRUD();
    crud.validasi(success, btnRegister);
  }

//    ini function
  public void reset() {
    tNama.setText("");
    tNoHP.setText("");
    tAlamat.setText("");
    tPass.setText("");
    tPass1.setText("");
    crud.defaultText(tNama, "Nama");
    crud.defaultText(tAlamat, "Alamat");
    crud.defaultText(tNoHP, "No HP");
    crud.defaultText(tPass, "Password");
    crud.defaultText(tPass1, "Konfirmasi Password");
    tNama.requestFocus();
    Arrays.fill(success, false);
    btnRegister.setEnabled(false);
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
    jLabel1 = new javax.swing.JLabel();
    tNama = new javax.swing.JTextField();
    tNoHP = new javax.swing.JTextField();
    tAlamat = new javax.swing.JTextField();
    tPass = new javax.swing.JPasswordField();
    chkSee = new javax.swing.JCheckBox();
    tPass1 = new javax.swing.JPasswordField();
    btnKembali = new javax.swing.JButton();
    btnReset = new javax.swing.JButton();
    btnRegister = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("REGISTER");

    jLabel1.setText("DAFTAR AKUN BARU");

    tNama.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nama"));
    tNama.setNextFocusableComponent(tNoHP);
    tNama.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tNamaFocusLost(evt);
      }
    });

    tNoHP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "No HP"));
    tNoHP.setNextFocusableComponent(tAlamat);
    tNoHP.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tNoHPFocusLost(evt);
      }
    });

    tAlamat.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Alamat"));
    tAlamat.setNextFocusableComponent(tPass);
    tAlamat.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tAlamatFocusLost(evt);
      }
    });

    tPass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Password"));
    tPass.setNextFocusableComponent(tPass1);
    tPass.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tPassFocusLost(evt);
      }
    });

    chkSee.setNextFocusableComponent(btnKembali);
    chkSee.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        chkSeeActionPerformed(evt);
      }
    });

    tPass1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Konfirmasi Password"));
    tPass1.setNextFocusableComponent(chkSee);
    tPass1.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tPass1FocusLost(evt);
      }
    });

    btnKembali.setText("KEMBALI");
    btnKembali.setNextFocusableComponent(btnReset);
    btnKembali.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnKembaliActionPerformed(evt);
      }
    });

    btnReset.setText("RESET");
    btnReset.setNextFocusableComponent(btnRegister);
    btnReset.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnResetActionPerformed(evt);
      }
    });

    btnRegister.setText("REGISTER");
    btnRegister.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegisterActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btnRegister))
          .addComponent(tAlamat))
        .addGap(37, 37, 37))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(tNoHP, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
              .addComponent(tNama))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(tPass1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
              .addComponent(tPass))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(chkSee))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnReset))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(157, 157, 157)
            .addComponent(jLabel1)))
        .addContainerGap(10, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(6, 6, 6)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(chkSee)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(7, 7, 7)
        .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnKembali)
          .addComponent(btnReset)
          .addComponent(btnRegister))
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

    private void chkSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSeeActionPerformed
    crud.togglePassword(tPass, chkSee);
    crud.togglePassword(tPass1, chkSee);
    }//GEN-LAST:event_chkSeeActionPerformed

    private void tNamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNamaFocusLost

    success[0] = crud.ValidasiTextHarusDiIsi(tNama, "Nama ", btnRegister, success);
    if (success[0]) {
      ResultSet ambilData = crud.ambilData(" akun WHERE nama = '" + tNama.getText() + "'");
      success[0] = crud.ValidasiDataTerdaftarDatabase(tNama, "Nama ", ambilData);
      crud.validasi(success, btnRegister);
    }
    }//GEN-LAST:event_tNamaFocusLost

    private void tNoHPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNoHPFocusLost
    success[1] = crud.ValidasiTextHarusDiIsi(tNoHP, "NO HP ", btnRegister, success);
    crud.validasi(success, btnRegister);
    }//GEN-LAST:event_tNoHPFocusLost

    private void tAlamatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tAlamatFocusLost
    success[2] = crud.ValidasiTextHarusDiIsi(tAlamat, "Alamat ", btnRegister, success);
    crud.validasi(success, btnRegister);
    }//GEN-LAST:event_tAlamatFocusLost

    private void tPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tPassFocusLost
    success[3] = crud.ValidasiTextHarusDiIsi(tPass, "Password ", btnRegister, success);
    String pass = tPass.getText();
    String pass1 = tPass1.getText();
    if (success[3]) {
      crud.validasiPasswordBeda(pass, pass1, tPass1, "Password");
    }
    crud.validasi(success, btnRegister);
    }//GEN-LAST:event_tPassFocusLost

    private void tPass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tPass1FocusLost
    success[4] = crud.ValidasiTextHarusDiIsi(tPass1, "Konfirmasi Password ", btnRegister, success);
    String pass = tPass.getText();
    String pass1 = tPass1.getText();
    if (success[4]) {
      crud.validasiPasswordBeda(pass, pass1, tPass1, "Konfirmasi Password");
    }
    crud.validasi(success, btnRegister);
    }//GEN-LAST:event_tPass1FocusLost

  private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
    Login L = new Login();
    L.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_btnKembaliActionPerformed

  private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
    reset();
  }//GEN-LAST:event_btnResetActionPerformed

  private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
  }//GEN-LAST:event_btnRegisterActionPerformed

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
      java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Register().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnKembali;
  private javax.swing.JButton btnRegister;
  private javax.swing.JButton btnReset;
  private javax.swing.JCheckBox chkSee;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField tAlamat;
  private javax.swing.JTextField tNama;
  private javax.swing.JTextField tNoHP;
  private javax.swing.JPasswordField tPass;
  private javax.swing.JPasswordField tPass1;
  // End of variables declaration//GEN-END:variables
}
