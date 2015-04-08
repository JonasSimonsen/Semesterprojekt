/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.CampaignDAO;
import entity.Campaign;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonassimonsen
 */
@WebServlet(name = "campaign_NewCampaign", urlPatterns = {"/campaign_NewCampaign"})
public class campaign_NewCampaign extends HttpServlet {

    
    private int tempPlanNumber;
    private int tempPartnerNumber;
    private String tempCountry;
    private String tempDescription;
    private String tempAudience;
    private String tempCurrency;
    private int tempCost;
    private int tempMdfBudget;
    private String tempStatus;
    private String tempQuarter;
    private String tempStartDate;
    private String tempEndDate;
    private String tempObjective;
    private String tempPoeRequirement;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        tempPlanNumber = Integer.parseInt(request.getParameter("plan-number"));
        tempPartnerNumber = Integer.parseInt(request.getParameter("partner-number"));
        tempCountry = request.getParameter("country");
        tempDescription = request.getParameter("description");
        tempAudience = request.getParameter("audience");
        tempCurrency = request.getParameter("currency");
        tempCost = Integer.getInteger(request.getParameter("cost"));
        tempMdfBudget = Integer.getInteger(request.getParameter("mdf-budget"));
        tempStatus = request.getParameter("status");
        tempQuarter = request.getParameter("quarter");
        tempStartDate = request.getParameter("startdate");
        tempEndDate = request.getParameter("enddate");
        tempObjective = request.getParameter("objective");
        tempPoeRequirement = request.getParameter("poe-requirement");

        Campaign campaign = new Campaign(tempPlanNumber, tempPartnerNumber, tempCountry, tempDescription, tempAudience, tempCurrency, tempCost, tempMdfBudget, tempStatus, tempQuarter, tempStartDate, tempEndDate, tempObjective, tempPoeRequirement);
        CampaignDAO cm = new CampaignDAO();

        try {
            cm.submitNewCampaign(campaign);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("campaign_new.jsp");
        rd.forward(request, response);
        
        }
    }