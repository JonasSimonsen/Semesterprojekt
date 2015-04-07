/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.User;
import data.DataManager;
import java.sql.SQLException;

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
        int tempPhoneNumber;
        String tempOrganization;

        tempUsername = request.getParameter("username");
        tempPassword = request.getParameter("password");
        tempFirstName = request.getParameter("first-name");
        tempLastName = request.getParameter("last-name");
        tempEmail = request.getParameter("email");
        tempPhoneNumber = Integer.parseInt(request.getParameter("phone"));
        tempOrganization = request.getParameter("organization");
        
        User user = new User(1, tempUsername, tempPassword, tempFirstName, tempLastName, tempEmail, tempPhoneNumber, tempOrganization, 1); 
        DataManager dm = new DataManager();
        
        try {
            dm.createNewUser(user);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("LOL");
        }
        

        RequestDispatcher rd = request.getRequestDispatcher("users_new.jsp");
        rd.forward(request, response);
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
