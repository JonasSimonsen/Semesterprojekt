/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.CampaignDAO;
import data.DatabaseInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.persistence.Table;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Campaign;

/**
 *
 * @author jonassimonsen
 */
@WebServlet(name = "campaign_ViewCampaign", urlPatterns = {"/campaign_ViewCampaign"})
public class campaign_ViewCampaign extends HttpServlet {

    private int PLANNO;
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
        PLANNO = Integer.getInteger(request.getParameter("id"));
        Campaign campaign;
        CampaignDAO cm = new CampaignDAO();
        try {
            campaign = cm.getSpecificCampaign(PLANNO);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
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

        String planno=request.getParameter("id");
        try {
            Class.forName(DatabaseInfo.driver);
                    Connection con=DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);               
                    PreparedStatement ps=con.prepareStatement("select * from PARTNERPLAN where PLANNO=?");
                     
                    RequestDispatcher rd = request.getRequestDispatcher("campaigns_viewspecific.jsp");
                    rd.forward(request, response);
 
              }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
                }
       }
    
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
