/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Tblusuario;
import Persistencia.JDBCMySQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Miguel
 */
public class LoginController {

    JDBCMySQL conexion = new JDBCMySQL();
    JdbcTemplate jdbctemplate = new JdbcTemplate(conexion.Conectar());
    ModelAndView modelandview = new ModelAndView();

    @RequestMapping("index.htm")
    public ModelAndView Select(Tblusuario Tblusuario) {
        String query = "SELECT email, password  "
                + " FROM tblusuario  "
                + " WHERE email = ?  "
                + " AND password = ? ";

        this.jdbctemplate.queryForList(query, Tblusuario.getEmail(), Tblusuario.getPassword());

        return new ModelAndView("redirect:/inde.htm");

    }
}
