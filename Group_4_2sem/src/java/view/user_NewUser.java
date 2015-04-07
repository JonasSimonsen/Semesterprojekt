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
        
        String message = "Hello World";
        
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
        
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    

}
