/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.CampaignDAO;
import control.DatabaseInfo;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Campaign2;

/**
 *
 * @author ZARDOZ
 */
@WebServlet(name = "campaign_SavePOE", urlPatterns = {"/campaign_SavePOE"})
@MultipartConfig
public class campaign_SavePOE extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        // gets values of text fields

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(campaign_SavePOE.class.getName()).log(Level.SEVERE, null, ex);
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
        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = request.getPart("fIlE_UpLoAd-N1C3-F1Le-4-h4X"); // Retrieves <input type="file" name="file">
        String fileName = filePart.getSubmittedFileName();
        InputStream fileContent = filePart.getInputStream();
        int ZIPNO = 0;

        InputStream inputStream = null; // input stream of the upload file

        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        Connection connection = null; // connection to the database
        String message = null;  // message will be sent back to client

        try {
            // connects to the database
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen

            
            int PLANNO = Integer.parseInt(request.getParameter("id"));

            // constructs SQL statement
            String query = "INSERT INTO CAMPSTORAGE (ZIPNO, ZIPFILE, CAMPNO) values (?, ?, (SELECT CAMPNO FROM CAMPAIGN WHERE CAMPNO=?))";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ZIPNO);
            statement.setBlob(2, inputStream);
            statement.setInt(3, PLANNO);

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(campaign_SavePOE.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                // closes the database connection
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);

            RequestDispatcher rd = request.getRequestDispatcher("campaigns_viewspecific.jsp");
            rd.forward(request, response);
        }
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
