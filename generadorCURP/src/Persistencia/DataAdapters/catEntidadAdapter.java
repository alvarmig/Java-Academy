/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DataAdapters;

import Beans.Entidad;
import Persistencia.JDBCMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class catEntidadAdapter {

    private final JDBCMySQL conn = new JDBCMySQL();
    private final Connection c = conn.connectionDB();

    public List<Entidad> Select() {

        try {
            List<Entidad> rsEntidad = new ArrayList<>();
            PreparedStatement verificarStmt
                    = c.prepareStatement("SELECT"
                            + "   ID   "
                            + "   ,Descripcion"
                            + "   FROM catEntidad");

            ResultSet rs = verificarStmt.executeQuery();

            while (rs.next()) {
                Entidad entidad = new Entidad(rs.getString("ID"), rs.getString("Descripcion"));
                rsEntidad.add(entidad);
            }

            verificarStmt.close();
            rs.close();

            return rsEntidad;
        } catch (SQLException ex) {
            Logger.getLogger(catGeneroAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            conn.disconnection(c);
        }
        return null;
    }
}
