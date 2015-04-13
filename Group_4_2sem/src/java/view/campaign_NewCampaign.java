/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.CampaignDAO;
import model.Campaign;
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
    
    
    private String tempContactName;
    private String tempCompanyName;
    private String tempAddress;
    private String tempEmail;
    private String tempPhone;
    
    private String tempProgramDate;
    private String tempStartTime;
    private String tempEndTime;
    private int tempEstimatedOfAttendess;
    private String tempVenueName;
    private String tempVenueAddress;
    
    private int tempFaceToFaceEvent;
    private int tempTradeshow;
    private int tempMultitouchCampaign;
    private int tempDoorOpenerCampaign;
    private int tempThirdPartyCampaign;
    private int tempBlitzCampaign;
    private String tempProgramDescription;
    
    private int tempDellStorageSC4000Series;
    private int tempDellStoragePS4210Series;
    private int tempDellStorageSolution;
    private int tempFlashAtThePriceOfDisk;
    private int tempFluidCacheForSAN;
    private int tempDateProtection;
    private int tempTheLastGenerationOfDellPowerEdgeServers;
    private int tempWindowsServer2003Migration;
    private int tempX86ServerTransition;
    private int tempPowerEdgeVRTX;
    private int tempSoftwareDefinedNetworking;
    private int tempUserCentricNetworking;
    private int tempCloudClientComputing;
    private int tempConvergedInfrastructureHardware;
    private int tempDellConvergedBladeDataCenter;
    private int tempOptimizedEnteprise;
    private int tempPowerEdgeFXArchitecture;
    private int tempSoftwareDefinedStorage;
    private String tempIsThereASoftwareComponentToYourCampaign;
    
    private int tempSMB;
    private int tempLE;
    private int tempPUB;
    
    private double tempTotalProjectedCostOfProgram;
    private double tempTotalMDFRequestingFromDell;
    private String tempPreferredMethodOfReimbursement;
    private String tempParticipatingTechnologyPartner;
    private double tempTotalTechnologyPartner;
    private int tempEstimatedOfOpportunitues;
    private int tempEstimatedRevenueFromProgram;
    
//    private int tempPlanNumber;
//    private int tempPartnerNumber;
//    private String tempCountry;
//    private String tempDescription;
//    private String tempAudience;
//    private String tempCurrency;
//    private double tempCost;
//    private int tempMdfBudget;
//    private String tempStatus;
//    private String tempQuarter;
//    private String tempStartDate;
//    private String tempEndDate;
//    private String tempObjective;
//    private String tempPoeRequirement;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        tempContactName = request.getParameter("");
        tempCompanyName = request.getParameter("");
        tempAddress = request.getParameter("");
        tempEmail = request.getParameter("");
        tempPhone = request.getParameter("");
    
        tempProgramDate = request.getParameter("");
        tempStartTime = request.getParameter("");
        tempEndTime = request.getParameter("");
        tempEstimatedOfAttendess = Integer.parseInt(request.getParameter(""));
        tempVenueName = request.getParameter("");
        tempVenueAddress = request.getParameter("");
    
        tempFaceToFaceEvent = Integer.parseInt(request.getParameter(""));
        tempTradeshow = Integer.parseInt(request.getParameter(""));
        tempMultitouchCampaign = Integer.parseInt(request.getParameter(""));
        tempDoorOpenerCampaign = Integer.parseInt(request.getParameter(""));
        tempThirdPartyCampaign = Integer.parseInt(request.getParameter(""));
        tempBlitzCampaign = Integer.parseInt(request.getParameter(""));
        tempProgramDescription = request.getParameter("");
    
        tempDellStorageSC4000Series = Integer.parseInt(request.getParameter(""));
        tempDellStoragePS4210Series = Integer.parseInt(request.getParameter(""));
        tempDellStorageSolution = Integer.parseInt(request.getParameter(""));
        tempFlashAtThePriceOfDisk = Integer.parseInt(request.getParameter(""));
        tempFluidCacheForSAN = Integer.parseInt(request.getParameter(""));
        tempDateProtection = Integer.parseInt(request.getParameter(""));
        tempTheLastGenerationOfDellPowerEdgeServers = Integer.parseInt(request.getParameter(""));
        tempWindowsServer2003Migration = Integer.parseInt(request.getParameter(""));
        tempX86ServerTransition = Integer.parseInt(request.getParameter(""));
        tempPowerEdgeVRTX = Integer.parseInt(request.getParameter(""));
        tempSoftwareDefinedNetworking = Integer.parseInt(request.getParameter(""));
        tempUserCentricNetworking = Integer.parseInt(request.getParameter(""));
        tempCloudClientComputing = Integer.parseInt(request.getParameter(""));
        tempConvergedInfrastructureHardware = Integer.parseInt(request.getParameter(""));
        tempDellConvergedBladeDataCenter = Integer.parseInt(request.getParameter(""));
        tempOptimizedEnteprise = Integer.parseInt(request.getParameter(""));
        tempPowerEdgeFXArchitecture = Integer.parseInt(request.getParameter(""));
        tempSoftwareDefinedStorage = Integer.parseInt(request.getParameter(""));
        tempIsThereASoftwareComponentToYourCampaign = request.getParameter("");
    
        tempSMB = Integer.parseInt(request.getParameter(""));
        tempLE = Integer.parseInt(request.getParameter(""));
        tempPUB = Integer.parseInt(request.getParameter(""));
    
        tempTotalProjectedCostOfProgram = Double.parseDouble(request.getParameter(""));
        tempTotalMDFRequestingFromDell = Double.parseDouble(request.getParameter(""));
        tempPreferredMethodOfReimbursement = request.getParameter("");
        tempParticipatingTechnologyPartner = request.getParameter("");
        tempTotalTechnologyPartner = Double.parseDouble(request.getParameter(""));
        tempEstimatedOfOpportunitues = Integer.parseInt(request.getParameter(""));
        tempEstimatedRevenueFromProgram = Integer.parseInt(request.getParameter(""));
        
        
//        tempCountry = request.getParameter("country");
//        tempDescription = request.getParameter("description");
//        tempAudience = request.getParameter("audience");
//        tempCurrency = request.getParameter("currency");
//        tempCost = Double.parseDouble(request.getParameter("cost"));
//        tempStatus = request.getParameter("status");
//        tempQuarter = request.getParameter("quarter");
//        tempStartDate = request.getParameter("start-date");
//        tempEndDate = request.getParameter("end-date");
//        tempObjective = request.getParameter("objective");

//        Campaign campaign = new Campaign(tempPlanNumber, tempPartnerNumber, tempCountry, tempDescription, tempAudience, tempCurrency, tempCost, tempMdfBudget, tempStatus, tempQuarter, tempStartDate, tempEndDate, tempObjective, tempPoeRequirement);
        Campaign campaign = new Campaign(tempContactName, tempCompanyName, tempAddress, tempEmail, tempPhone, tempProgramDate, tempStartTime, tempEndTime, tempEstimatedOfAttendess, tempVenueName, tempVenueAddress, 
                tempFaceToFaceEvent, tempTradeshow, tempMultitouchCampaign, tempDoorOpenerCampaign, tempThirdPartyCampaign, tempBlitzCampaign, tempProgramDescription,
        tempDellStorageSC4000Series, tempDellStoragePS4210Series, tempDellStorageSolution, tempFlashAtThePriceOfDisk, tempFluidCacheForSAN, tempDateProtection, tempTheLastGenerationOfDellPowerEdgeServers, tempWindowsServer2003Migration,
        tempX86ServerTransition, tempPowerEdgeVRTX, tempSoftwareDefinedNetworking, tempUserCentricNetworking, tempCloudClientComputing, tempConvergedInfrastructureHardware, tempDellConvergedBladeDataCenter, tempOptimizedEnteprise, tempPowerEdgeFXArchitecture ,
        tempSoftwareDefinedStorage, tempIsThereASoftwareComponentToYourCampaign, tempSMB, tempLE, tempPUB, tempTotalProjectedCostOfProgram, tempTotalMDFRequestingFromDell, tempPreferredMethodOfReimbursement, tempParticipatingTechnologyPartner,
        tempTotalTechnologyPartner, tempEstimatedOfOpportunitues, tempEstimatedRevenueFromProgram)
        CampaignDAO cm = new CampaignDAO();

        try {
            cm.submitNewCampaign(campaign);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("campaigns_submit.jsp");
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