/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Riqqi
 */
public class CRUD {

   protected String driver = "com.mysql.cj.jdbc.Driver";
   protected String url = "jdbc:mysql://localhost:3306/pulsa_ali";
   protected String user = "root";
   protected String pass = "";
   protected Connection cn;
   protected Statement st;

   public CRUD() {
      koneksi();
   }

//    ---DATABASE---
   public void koneksi() {

      try {
         Class.forName(driver);
         cn = DriverManager.getConnection(url, user, pass);
         st = cn.createStatement();
         System.out.println("koneksi berhasil");
      } catch (ClassNotFoundException | SQLException ex) {
         Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

   public ResultSet ambilData(String query) {
      ResultSet rs = null;
      try {
         rs = st.executeQuery(query);
      } catch (SQLException ex) {
         Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
      }
      return rs;
   }

   public void insertData(String query) {
      try {
         st.executeUpdate(query);
      } catch (SQLException ex) {
         Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void updateData(String query) {
      insertData(query);
   }

//    ---FUNCTIONAL---
   public void textError(javax.swing.JTextField j, String text) {
      j.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), text, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0)));
   }

   public void textSucces(javax.swing.JTextField j, String text) {
      j.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)), text, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 255, 0)));

   }

   public void defaultText(javax.swing.JTextField ara, String text) {
      ara.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), text));

   }

   public void togglePassword(javax.swing.JPasswordField p, javax.swing.JCheckBox c) {
      if (c.isSelected()) {
         p.setEchoChar((char) 0);
      } else {
         p.setEchoChar('*');
      }
   }

   public String StringToMD5(String Password) throws NoSuchAlgorithmException {
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.update(Password.getBytes(), 0, Password.length());
      return new BigInteger(1, m.digest()).toString(16);
   }

   public String integerToRupiah(int nominal) {
      DecimalFormat IDR = (DecimalFormat) DecimalFormat.getCurrencyInstance();
      DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

      formatRp.setCurrencySymbol("Rp.");
      formatRp.setMonetaryDecimalSeparator('.');
      formatRp.setGroupingSeparator('.');
      IDR.setDecimalFormatSymbols(formatRp);
      return IDR.format(nominal);
   }

//  ---VALIDASI---
   public void validasi(boolean[] t, javax.swing.JButton a) {
      boolean hasil = true;
      for (boolean succes : t) {
         hasil = succes & hasil;
         a.setEnabled(hasil);
      }
   }

   public boolean ValidasiTextHarusDiIsi(javax.swing.JTextField j, String text, javax.swing.JButton b, boolean[] bool) {
      if (j.getText().isBlank()) {
         textError(j, text + " Harus Di Isi");
         return false;
      } else {
         textSucces(j, text);
         return true;
      }
   }

   public boolean validasiDataTabel(javax.swing.JTextField j, String text, ResultSet query) {
      try {
         if (query.next()) {
            textSucces(j, text);
            return true;
         } else {
            textError(j, text + " Salah");
            return false;
         }
      } catch (SQLException ex) {
         Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
         return false;
      }
   }

   public boolean validasiDataSudahTerdaftar(javax.swing.JTextField j, String text, ResultSet query) {
      try {
         if (query.next()) {
            textError(j, text + " sudah terdaftar");
            return false;
         } else {
            textSucces(j, text);
            return true;
         }
      } catch (SQLException ex) {
         Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
         return false;
      }
   }

   public boolean validasiPasswordBeda(String pass1, String pass2, javax.swing.JTextField j, String text) {
      if (pass1.equals(pass2)) {
         textSucces(j, text);
         return true;

      } else {
         textError(j, text + " Incorrect");
         return false;
      }

   }
}
