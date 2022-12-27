/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main;

import config.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Riqqi
 */
public class PanelTransJual extends javax.swing.JPanel {

   /**
    * Creates new form PanelTransJual
    */
   CRUD crud;
   DefaultTableModel dt;

   public PanelTransJual() {
      initComponents();
      crud = new CRUD();
   }

   //   --FUNCTION TRANSJUAL--
   public void refreshTableTransJual() {
      dt = (DefaultTableModel) tabelTransJual.getModel();
      ResultSet transJual = crud.ambilData("SELECT trans_jual.no_trans_jual, trans_jual.no_pln, pelanggan.nama AS pelanggan, trans_jual.harga, trans_jual.bayar, trans_jual.id_akun, trans_jual.tgl, akun.nama AS admin FROM `trans_jual` INNER JOIN akun ON trans_jual.id_akun = akun.id_akun INNER JOIN pelanggan ON trans_jual.no_pln = pelanggan.no_pln;");
      try {
         int no = 1;
         dt.getDataVector().clear();
         dt.fireTableDataChanged();
         while (transJual.next()) {
            String tgl = transJual.getString("tgl");
            String noPln = transJual.getString("no_pln");
            String pelanggan = transJual.getString("pelanggan");
            String nominal = transJual.getString("harga");
            String bayar = transJual.getString("bayar");
            String admin = transJual.getString("admin");
            dt.addRow(new Object[]{no++, tgl, noPln + "(" + pelanggan + ")", nominal, bayar, admin});
         }
         tabelTransJual.setModel(dt);
         reset();
      } catch (SQLException ex) {
         Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void reset() {

   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      cbPelanggan = new javax.swing.JComboBox();
      jLabel5 = new javax.swing.JLabel();
      bReset = new javax.swing.JButton();
      bTambah = new javax.swing.JButton();
      jScrollPane2 = new javax.swing.JScrollPane();
      tabelTransJual = new javax.swing.JTable();
      cbNominal = new javax.swing.JComboBox();

      cbPelanggan.setBorder(javax.swing.BorderFactory.createTitledBorder("Pelanggan"));

      jLabel5.setText("Bayar :");

      bReset.setText("Reset");

      bTambah.setText("Tambah");

      tabelTransJual.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "No", "Tanggal", "No_PLN", "Nominal", "Bayar", "Akun"
         }
      ));
      jScrollPane2.setViewportView(tabelTransJual);

      cbNominal.setBorder(javax.swing.BorderFactory.createTitledBorder("Nominal"));

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(cbPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(bReset)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(bTambah))
                  .addComponent(cbNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(jLabel5))
            .addGap(35, 35, 35)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(cbPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(cbNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jLabel5)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(bReset)
                     .addComponent(bTambah)))
               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton bReset;
   private javax.swing.JButton bTambah;
   private javax.swing.JComboBox cbNominal;
   private javax.swing.JComboBox cbPelanggan;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTable tabelTransJual;
   // End of variables declaration//GEN-END:variables
}