/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Tblusuario;
import Controllers.LoginController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Proyectos
 */
public class testServlet extends HttpServlet {

    LoginController logincontroller = new LoginController();
    int[] arreglo = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"POST\">");
            out.println("<h1>Listado de calificaciones: " + Arrays.toString(arreglo) + "</h1>");
            out.println(obtenerPromedio());
            out.println("<input type=\"button\" value=\"Agregar\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comando = request.getParameter("cmdPromedio");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if ("Calcular Promedio".equals(comando)) {
                out.println("<h1>Listado de calificaciones: " + Arrays.toString(arreglo) + "</h1>");
                out.println(obtenerPromedio());
            } else {
                out.println("<h1>LA FUNCIÓN NO EXISTE</h1>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Tblusuario Tblusuario = new Tblusuario();
        Tblusuario.setEmail(request.getParameter("cmdNombre"));
        Tblusuario.setPassword(request.getParameter("cmdPassword"));

        String mensaje = "USUARIO  NO AUTORIZADO";

        logincontroller.Select(Tblusuario);

//        if (cmdUsuario.equals(valorUsuario) && cmdPassword.equals(valorContrasena)) {
//            mensaje = "USUARIO AUTORIZADO";
//        }
        request.setAttribute("respuesta", mensaje);
        request.getRequestDispatcher("/index.htm").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public double obtenerPromedio() {
        int total = 0;

        for (int numero : arreglo) {
            total += numero;
        }

        return (double) total / arreglo.length;
    }

}
