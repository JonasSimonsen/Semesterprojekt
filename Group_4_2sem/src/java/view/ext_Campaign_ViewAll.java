/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import facade.facadeCtrl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DTO.Campaign;
import exceptions.DatabaseErrorException;
import interfaces.Interface_CtrlFacade;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonassimonsen
 */
@WebServlet(name = "ext_Campaign_ViewAll", urlPatterns = {"/ext_Campaign_ViewAll"})
public class ext_Campaign_ViewAll extends HttpServlet {

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
        
        HttpSession s = request.getSession();
        s.setMaxInactiveInterval(30 * 60);
        String UN = s.getAttribute("username").toString();
        
        System.out.println(UN);

        Campaign campaign = null;
        Interface_CtrlFacade ctrl = new facadeCtrl();
        ArrayList<Campaign> campaignList = new ArrayList<Campaign>();
        
        
        try {
            int ID = ctrl.getUserID(UN);
            System.out.println(ID);
                campaignList = ctrl.getCampaignsExternal(ID);
            } catch (DatabaseErrorException | ClassNotFoundException ex) {
                Logger.getLogger(ext_Campaign_ViewAll.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            s.setAttribute("campList", campaignList);
        }

        RequestDispatcher rd = request.getRequestDispatcher("ext_campaigns_search.jsp");
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
