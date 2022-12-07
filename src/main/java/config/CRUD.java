/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riqqi
 */
public class CRUD {

    protected String driver = "com.mysql.cj.jdbc.Driver";
    protected String url = "jdbc:mysql://localhost:3306/pa_sumber_hasil";
    protected String user = "root";
    protected String pass = "";
    protected Connection cn;
    protected Statement st;

    protected String namaTabel;
    protected int jumlahKolom;
    protected DefaultTableModel dt;
    protected JTable tabel;

    public String getNamaTabel() {
        return namaTabel;
    }

    public void setNamaTabel(String namaTabel) {
        this.namaTabel = namaTabel;
    }

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

    public ResultSet ambilSemuaData() {
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT * FROM " + namaTabel);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet ambilDataYang(String query) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT * FROM " + namaTabel + " " + query);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
