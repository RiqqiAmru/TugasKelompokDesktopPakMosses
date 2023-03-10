/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.CRUD;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author windows
 */
public class PanelProfil extends javax.swing.JPanel {

   int idAkun;
   CRUD crud;
   String namaLama;
   String noHPLama;
   String alamatLama;
   String passLama;
   boolean[] success = new boolean[3];
   boolean[] successPass = new boolean[2];

   /**
    * Creates new form profilku
    */
   public PanelProfil(int idAkun, CRUD crud) {
      this.idAkun = idAkun;
      this.crud = crud;
      initComponents();
      isiForm();
   }

   public void isiForm() {
      try {
         ResultSet akun = crud.ambilData("SELECT * FROM akun WHERE id_akun = '" + idAkun + "'");
         if (akun.first()) {
            namaLama = akun.getString("nama");
            noHPLama = akun.getString("no_hp");
            alamatLama = akun.getString("alamat");
            passLama = akun.getString("password");

            tNama.setText(namaLama);
            tNoHp.setText(noHPLama);
            tAlamat.setText(alamatLama);
         }
      } catch (SQLException ex) {
         Logger.getLogger(PanelProfil.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void reset() {
      tNama.setText(namaLama);
      tNoHp.setText(noHPLama);
      tAlamat.setText(alamatLama);
      Arrays.fill(success, false);
      Arrays.fill(successPass, false);
      crud.validasiOR(success, btnEdit);
      crud.validasiAND(successPass, btnGanti);
      crud.defaultText(tNama, "Nama");
      crud.defaultText(tNoHp, "No HP");
      crud.defaultText(tAlamat, "Alamat");
      crud.defaultText(tPass, "Ganti Password");
      crud.defaultText(tPass1, "Konfirmasi Password");
      tPass.setText("");
      tPass1.setText("");
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      tNama = new javax.swing.JTextField();
      tNoHp = new javax.swing.JTextField();
      tAlamat = new javax.swing.JTextField();
      btnEdit = new javax.swing.JButton();
      lblSaldo = new javax.swing.JLabel();
      btnBatal = new javax.swing.JButton();
      jSeparator1 = new javax.swing.JSeparator();
      tPass = new javax.swing.JPasswordField();
      tPass1 = new javax.swing.JPasswordField();
      chkSee1 = new javax.swing.JCheckBox();
      btnGanti = new javax.swing.JButton();

      addComponentListener(new java.awt.event.ComponentAdapter() {
         public void componentShown(java.awt.event.ComponentEvent evt) {
            formComponentShown(evt);
         }
      });

      tNama.setBorder(javax.swing.BorderFactory.createTitledBorder("Nama"));
      tNama.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusLost(java.awt.event.FocusEvent evt) {
            tNamaFocusLost(evt);
         }
      });

      tNoHp.setBorder(javax.swing.BorderFactory.createTitledBorder("No Hp"));
      tNoHp.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusLost(java.awt.event.FocusEvent evt) {
            tNoHpFocusLost(evt);
         }
      });

      tAlamat.setBorder(javax.swing.BorderFactory.createTitledBorder("Alamat"));
      tAlamat.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusLost(java.awt.event.FocusEvent evt) {
            tAlamatFocusLost(evt);
         }
      });

      btnEdit.setText("EDIT");
      btnEdit.setEnabled(false);
      btnEdit.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditActionPerformed(evt);
         }
      });

      lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
      lblSaldo.setText("Saldo : Rp");

      btnBatal.setText("Batal");
      btnBatal.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBatalActionPerformed(evt);
         }
      });

      tPass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ganti Password"));
      tPass.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusLost(java.awt.event.FocusEvent evt) {
            tPassFocusLost(evt);
         }
      });

      tPass1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Konfirmasi Password"));
      tPass1.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusLost(java.awt.event.FocusEvent evt) {
            tPass1FocusLost(evt);
         }
      });

      chkSee1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            chkSee1ActionPerformed(evt);
         }
      });

      btnGanti.setText("Ganti");
      btnGanti.setEnabled(false);
      btnGanti.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnGantiActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(tPass1)
                           .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(chkSee1)
                           .addComponent(btnGanti)))
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                           .addComponent(tAlamat)
                           .addComponent(tNoHp, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                           .addComponent(tNama, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(btnEdit)
                           .addComponent(btnBatal)
                           .addComponent(lblSaldo))))
                  .addGap(0, 0, Short.MAX_VALUE))
               .addComponent(jSeparator1))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblSaldo))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(btnEdit)
               .addComponent(tNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(btnBatal))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(41, 41, 41)
                  .addComponent(tPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(chkSee1)
                     .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnGanti)))
            .addContainerGap(27, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents

   private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
      crud.refreshSaldo(idAkun, lblSaldo);
      isiForm();
   }//GEN-LAST:event_formComponentShown

   private void tNamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNamaFocusLost
      if (!tNama.getText().equals(namaLama)) {
         success[0] = crud.ValidasiTextHarusDiIsi(tNama, "Nama", btnEdit);
         crud.validasiOR(success, btnEdit);
      }
   }//GEN-LAST:event_tNamaFocusLost

   private void tNoHpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNoHpFocusLost
      if (!tNoHp.getText().equals(noHPLama)) {
         success[1] = crud.ValidasiTextHarusDiIsi(tNoHp, "No HP", btnEdit);
         crud.validasiOR(success, btnEdit);
      }
   }//GEN-LAST:event_tNoHpFocusLost

   private void tAlamatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tAlamatFocusLost
      if (!tAlamat.getText().equals(alamatLama)) {
         success[2] = crud.ValidasiTextHarusDiIsi(tAlamat, "Alamat", btnEdit);
         crud.validasiOR(success, btnEdit);
      }
   }//GEN-LAST:event_tAlamatFocusLost

   private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
      reset();
   }//GEN-LAST:event_btnBatalActionPerformed

   private void tPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tPassFocusLost
      try {
         successPass[0] = crud.ValidasiTextHarusDiIsi(tPass, "Password ", btnGanti);
         String pass = tPass.getText();
         String StringToMD5 = crud.StringToMD5(pass);
         String pass1 = tPass1.getText();
         if (successPass[0]) {
            successPass[0] = crud.validasiPasswordBedaDariPassLama(StringToMD5, passLama, tPass, "Password");
         }
         if (successPass[0]) {
            successPass[0] = crud.validasiPasswordBeda(pass, pass1, tPass1, "Password 1");
         }
         crud.validasiAND(success, btnGanti);
      } catch (NoSuchAlgorithmException ex) {
         Logger.getLogger(PanelProfil.class.getName()).log(Level.SEVERE, null, ex);
      }
   }//GEN-LAST:event_tPassFocusLost

   private void tPass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tPass1FocusLost
      successPass[1] = crud.ValidasiTextHarusDiIsi(tPass1, "Konfirmasi Password ", btnGanti);
      String pass = tPass.getText();
      String pass1 = tPass1.getText();
      if (successPass[1]) {
         successPass[0] = crud.validasiPasswordBeda(pass, pass1, tPass1, "Konfirmasi Password 2");
      }
      crud.validasiAND(success, btnGanti);
   }//GEN-LAST:event_tPass1FocusLost

   private void chkSee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSee1ActionPerformed
      crud.togglePassword(tPass, chkSee1);
      crud.togglePassword(tPass1, chkSee1);
   }//GEN-LAST:event_chkSee1ActionPerformed

   private void btnGantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGantiActionPerformed
      crud.updateData("UPDATE `akun` SET `password`= md5('" + tPass.getText() + "') WHERE id_akun = '" + idAkun + "'");
      JOptionPane.showMessageDialog(null, "Password berhasil diubah");
      isiForm();
      reset();
   }//GEN-LAST:event_btnGantiActionPerformed

   private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
      crud.updateData("UPDATE `akun` SET `nama`='" + tNama.getText() + "',`no_hp`='" + tNoHp.getText() + "',`alamat`='" + tAlamat.getText() + "'WHERE id_akun = '" + idAkun + "'");
      JOptionPane.showMessageDialog(null, "Data Akun Berhasil Di edit");
      isiForm();
      reset();
   }//GEN-LAST:event_btnEditActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnBatal;
   private javax.swing.JButton btnEdit;
   private javax.swing.JButton btnGanti;
   private javax.swing.JCheckBox chkSee1;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JLabel lblSaldo;
   private javax.swing.JTextField tAlamat;
   private javax.swing.JTextField tNama;
   private javax.swing.JTextField tNoHp;
   private javax.swing.JPasswordField tPass;
   private javax.swing.JPasswordField tPass1;
   // End of variables declaration//GEN-END:variables
}
