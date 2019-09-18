/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "FormServlet", urlPatterns = "/calculateServlet")
public class FormServlet extends HttpServlet {

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
            out.println("<title>Servlet calculateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(" <form name=\"bmiForm\" action=\"calculateServlet\" method=\"POST\">       ");
            out.println("     <table>                                                               ");
            out.println("         <tr>                                                              ");
            out.println("             <td>Your Weight (kg) :</td>                                   ");
            out.println("             <td><input type=\"text\" name=\"weight\"/></td>               ");
            out.println("         </tr>                                                             ");
            out.println("         <tr>                                                              ");
            out.println("             <td>Your Height (m) :</td>                                    ");
            out.println("             <td><input type=\"text\" name=\"height\"/></td>               ");
            out.println("         </tr>                                                             ");
            out.println("         <th><input type=\"submit\" value=\"Submit\" name=\"find\"/></th>  ");
            out.println("         <th><input type=\"reset\" value=\"Reset\" name=\"reset\" /></th>  ");
            out.println("     </table>                                                              ");
            out.println("     <h2>${bmi}</h2>                                                       ");
            out.println(" </form>                                                                   ");
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
        processRequest(request, response);
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
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        try {
            double bmi = calculateBMI(
                    Double.parseDouble(weight),
                    Double.parseDouble(height));

            request.setAttribute("bmi", bmi);
            response.setHeader("Test", "Success");
            response.setHeader("BMI", String.valueOf(bmi));

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("calcularBMI.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("calcularBMI.jsp");
        }
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
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

}
