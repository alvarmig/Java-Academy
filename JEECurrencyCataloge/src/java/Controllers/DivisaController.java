/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Divisa;
import Persistence.JDBCMySQL;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Proyectos
 */
//Siempre agregar un nuevo bean en dispatcher servlet para agregar los controladores
@Controller
public class DivisaController {

    JDBCMySQL conexion = new JDBCMySQL();
    JdbcTemplate jdbctemplate = new JdbcTemplate(conexion.Conectar());
    ModelAndView modelandview = new ModelAndView();

    @RequestMapping("index.htm")
    public ModelAndView Listar() {

        //        By default, the JDBCTemplate does its own PreparedStatement internally, if you just use the .update(String sql, Object ... args) form.
        //        Spring, and your database, will manage the compiled query for you, so you don't have to worry about opening, closing, resource protection, etc.
        //        One of the saving graces of Spring.
        List datos = this.jdbctemplate.queryForList("SELECT * FROM catDivisa");
        modelandview.addObject("lista", datos);
        modelandview.setViewName("index");
        return modelandview;

    }

    @RequestMapping(value = "insert.htm", method = RequestMethod.GET)
    public ModelAndView Insert() {
        modelandview.addObject(new Divisa());
        modelandview.setViewName("insert");

        return modelandview;
    }

    @RequestMapping(value = "insert.htm", method = RequestMethod.POST)
    public ModelAndView Insert(Divisa divisa) {
        String query = "INSERT INTO catdivisa (nombre, valor) VALUES(?,?)";
        this.jdbctemplate.update(query, divisa.getNombre(), divisa.getValor());

        return new ModelAndView("redirect:/index.htm");
    }

}
