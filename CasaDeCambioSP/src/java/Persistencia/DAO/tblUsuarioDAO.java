/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DAO;

import Beans.Tblusuario;
import Helpers.SecurityHelper;
import Persistencia.JDBCMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Miguel
 */
public class tblUsuarioDAO {

    JDBCMySQL conexion = new JDBCMySQL();
    JdbcTemplate jdbctemplate = new JdbcTemplate(conexion.Conectar());
    ModelAndView modelandview = new ModelAndView();

    @RequestMapping("login.htm")
    public boolean autenticarUsuario(Tblusuario usuario) {
        try {
            String query = "SELECT email, password  "
                    + " FROM tblusuario  "
                    + " WHERE email = ?  "
                    + " AND password = ? ";

            List datos = this.jdbctemplate.queryForList(query, usuario.getEmail(),
                    SecurityHelper.encrypt(usuario.getPassword(), usuario.getKeyPassword()));
            System.out.println(datos);
            if (1 == datos.size()) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            Logger.getLogger(tblUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @RequestMapping("registro.htm")
    public boolean registrarUsuario(Tblusuario usuario) {

        if (!validarUsuario(usuario)) {
            try {
                byte[] key = SecurityHelper.generateKey();
                String query = "INSERT INTO tblusuario (email, usuario, password, keyPassword )"
                        + " VALUES(?, ?, ?, ? ) ;";

                int registroAfectado = this.jdbctemplate.update(query, usuario.getEmail(), usuario.getUsuario(),
                        SecurityHelper.encrypt(usuario.getPassword(), key), key);

                if (1 == registroAfectado) {
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(tblUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @RequestMapping("login.htm")
    public Tblusuario obtenerKeyUsuario(Tblusuario usuario) {
        return (Tblusuario) jdbctemplate.queryForObject("SELECT * FROM tblusuario WHERE usuario = '".concat(usuario.getUsuario()).concat("'"), new UsuarioRowMapper());
    }

    @RequestMapping("registro.htm")
    public Boolean validarUsuario(Tblusuario usuario) {
        Byte key = null;
        String query = "SELECT email "
                + " FROM tblusuario "
                + " WHERE email = ? "
                + " OR usuario = ? ";

        List datos = this.jdbctemplate.queryForList(query, usuario.getEmail(), usuario.getUsuario());

        if (1 == datos.size()) {
            return true;
        }
        return false;
    }

    class UsuarioRowMapper implements RowMapper {

        @Override
        public Tblusuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tblusuario usuario = new Tblusuario();
            usuario.setEmail(rs.getString("email"));
            usuario.setKeyPassword(rs.getBytes("keyPassword"));
            usuario.setPassword(rs.getBytes("password"));
            usuario.setUsuario(rs.getString("usuario"));
            return usuario;
        }
    }
}
