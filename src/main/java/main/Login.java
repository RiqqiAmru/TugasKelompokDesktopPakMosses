/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import config.CRUD;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Riqqi
 */
public class Login extends javax.swing.JFrame {

   /**
    * Creates new form Login
    */
   CRUD crud;
   boolean[] succes = new boolean[2];

   public Login() {
      initComponents();
      btnRegister.setVisible(false);
      crud = new CRUD();
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
    btnLogin = new javax.swing.JButton();
    chkSee = new javax.swing.JCheckBox();
    btnRegister = new javax.swing.JButton();
    tPass = new javax.swing.JPasswordField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("LOGIN");

    jLabel1.setText("LOGIN SISTEM PENJUALAN PULSA KIOS RISMA");

    tNama.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nama"));
    tNama.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    tNama.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tNamaFocusLost(evt);
      }
    });

    btnLogin.setText("LOGIN");
    btnLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLoginActionPerformed(evt);
      }
    });

    chkSee.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        chkSeeActionPerformed(evt);
      }
    });

    btnRegister.setText("REGISTER");
    btnRegister.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegisterActionPerformed(evt);
      }
    });

    tPass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Password"));
    tPass.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tPassFocusLost(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(btnLogin)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegister))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(tPass)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(chkSee))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(tNama, javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(chkSee))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnLogin)
          .addComponent(btnRegister))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
      try {
         String pass = tPass.getText();
         String StringToMD5 = crud.StringToMD5(pass);
         ResultSet akun = crud.ambilData("SELECT * FROM akun WHERE nama = '" + tNama.getText() + "' and password = '" + StringToMD5 + "'");
         if (akun.next()) {
            int idAkun = Integer.parseInt(akun.getString("id_akun"));
            MainMenu menu = new MainMenu(idAkun);
            menu.setVisible(true);
            System.out.println("berhasil login");
            this.dispose();
         } else {
            crud.textError(tNama, "Nama Tidak Terdaftar");
            crud.textError(tPass, "Password Tidak Terdaftar");
            btnRegister.setVisible(true);
         }
      } catch (NoSuchAlgorithmException | SQLException ex) {
         JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR);
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void chkSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSeeActionPerformed
      crud.togglePassword(tPass, chkSee);
    }//GEN-LAST:event_chkSeeActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
      Register register = new Register();
      register.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnRegisterActionPerformed

  private void tNamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNamaFocusLost
      succes[0] = crud.ValidasiTextHarusDiIsi(tNama, "Nama", btnLogin, succes);
      if (succes[0]) {
         ResultSet akun = crud.ambilData("SELECT * FROM  akun WHERE nama = '" + tNama.getText() + "'");
         succes[0] = crud.validasiDataTabel(tNama, "Nama", akun);
         if (!(succes[0])) {
            btnRegister.setVisible(true);
         } else {
            btnRegister.setVisible(false);
         }
      }
      crud.validasi(succes, btnLogin);

  }//GEN-LAST:event_tNamaFocusLost

  private void tPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tPassFocusLost
      succes[1] = crud.ValidasiTextHarusDiIsi(tPass, "Password ", btnLogin, succes);
      if (succes[1]) {
         try {
            String pass = tPass.getText();
            String StringToMD5 = crud.StringToMD5(pass);
            ResultSet akun = crud.ambilData("SELECT * FROM  akun WHERE nama = '" + tNama.getText() + "' and password ='" + StringToMD5 + "'");
            succes[1] = crud.validasiDataTabel(tPass, "Password", akun);
         } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
         }
      }
      crud.validasi(succes, btnLogin);
  }//GEN-LAST:event_tPassFocusLost

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
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Login().setVisible(true);
         }
      });
   }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnLogin;
  private javax.swing.JButton btnRegister;
  private javax.swing.JCheckBox chkSee;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField tNama;
  private javax.swing.JPasswordField tPass;
  // End of variables declaration//GEN-END:variables
}
