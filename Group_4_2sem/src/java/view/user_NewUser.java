/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonassimonsen
 */
@WebServlet(name = "user_NewUser", urlPatterns = {"/user_NewUser"})
public class user_NewUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tempUsername;
        String tempPassword;
        String tempFirstName;
        String tempLastName;
        String tempEmail;
        String tempPhoneNumber;
        String tempOrganization;
        String tempType;
        String tempInternalUser;
        String tempExternalUser;
        
        
        tempUsername = request.getAttribute("username").toString();
        tempPassword = request.getAttribute("password").toString();
        tempFirstName = request.getAttribute("first-name").toString();
        tempLastName = request.getAttribute("last-name").toString();
        tempEmail = request.getAttribute("email").toString();
        tempPhoneNumber = request.getAttribute("phone").toString();
        tempOrganization = request.getAttribute("organization").toString();
        tempInternalUser = request.getAttribute("internal-user").toString();
        tempExternalUser = request.getAttribute("external-user").toString();
        
        
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
