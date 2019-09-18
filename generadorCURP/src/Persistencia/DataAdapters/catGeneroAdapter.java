/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DataAdapters;

import Beans.Genero;
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
 * Método general de selección a la tabla catGenero
 *
 * @return resultset
 */
public class catGeneroAdapter {

    private final JDBCMySQL conn = new JDBCMySQL();
    private final Connection c = conn.connectionDB();

    public List<Genero> Select() {

        try {
            List<Genero> rsGenero = new ArrayList<>();
            PreparedStatement verificarStmt
                    = c.prepareStatement("SELECT"
                            + "   ID   "
                            + "   ,Clave"
                            + "   FROM catGenero");

            ResultSet rs = verificarStmt.executeQuery();

            while (rs.next()) {
                Genero genero = new Genero(rs.getString("Clave"), rs.getInt("ID"));
                /*cur.setValue(rs.getInt("valor"));*/
                //cur.setName(rs.getString("nombre"));
                rsGenero.add(genero);

            }

            verificarStmt.close();
            rs.close();

            return rsGenero;
        } catch (SQLException ex) {
            Logger.getLogger(catGeneroAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            conn.disconnection(c);
        }
        return null;
    }
}
