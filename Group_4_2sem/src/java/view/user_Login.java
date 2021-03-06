/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import exceptions.DatabaseErrorException;
import facade.facadeCtrl;
import interfaces.Interface_CtrlFacade;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonassimonsen
 */
@WebServlet(name = "user_Login", urlPatterns = {"/user_Login"})
public class user_Login extends HttpServlet {

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

        HttpSession s = request.getSession();
        s.setMaxInactiveInterval(30 * 60);

        String UN = request.getParameter("username");
        String PW = request.getParameter("password");
        Interface_CtrlFacade ctrl = new facadeCtrl();

        try {
            if (ctrl.getUser(UN, PW)) {
                int type = ctrl.getUserType(UN);
                s.setAttribute("username", UN);
                s.setAttribute("user_type", type);

                if (type == 1) {
                    RequestDispatcher rd = request.getRequestDispatcher("int_dashboard.jsp");
                    rd.forward(request, response);
                } else if (type == 0) {
                    RequestDispatcher rd = request.getRequestDispatcher("ext_dashboard.jsp");
                    rd.forward(request, response);
                }

            } else {
                out.print("Sorry username or password error");
                RequestDispatcher rd = request.getRequestDispatcher("login_failed.jsp");
                rd.forward(request, response);

            }
        } catch (DatabaseErrorException | ClassNotFoundException ex) {
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
        processRequest(request, response);
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
