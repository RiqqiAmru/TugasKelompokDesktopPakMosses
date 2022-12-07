/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import config.CRUD;
import java.sql.SQLException;

/**
 *
 * @author Riqqi
 */
public class Coba {

    public static void main(String[] args) throws SQLException {
        CRUD crud = new CRUD();
        crud.setNamaTabel("barang");

        crud.koneksi();

    }

}
