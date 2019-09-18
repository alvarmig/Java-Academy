/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DataAdapters;

import Persistencia.JDBCMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class catCURPAdapter {

    private final JDBCMySQL conn = new JDBCMySQL();
    private final Connection c = conn.connectionDB();

    public boolean Insert(String curp, String apellidoPaterno, String apellidoMaterno, String nombre1, String nombre2, String nombre3, String id_entidad, int id_genero) {
        try {
            int success = 0;

            PreparedStatement verificarStmt;

            verificarStmt = c.prepareStatement("INSERT INTO catCURP(CURP, ApellidoPaterno, ApellidoMaterno, Nombre1, Nombre2, Nombre3, id_Entidad, id_Genero ) VALUES (?,?,?,?,?,?,?,?);");

            verificarStmt.setString(1, curp);
            verificarStmt.setString(2, apellidoPaterno);
            verificarStmt.setString(3, apellidoMaterno);
            verificarStmt.setString(4, nombre1);
            verificarStmt.setString(5, nombre2);
            verificarStmt.setString(6, nombre3);
            verificarStmt.setString(7, id_entidad);
            verificarStmt.setInt(8, id_genero);

            success = verificarStmt.executeUpdate();

            verificarStmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(catCURPAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.disconnection(c);
        }
        return false;
    }
}
