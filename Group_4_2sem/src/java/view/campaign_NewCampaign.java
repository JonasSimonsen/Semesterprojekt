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
import model.Campaign2;

/**
 *
 * @author jonassimonsen
 */
@WebServlet(name = "campaign_NewCampaign", urlPatterns = {"/campaign_NewCampaign"})
public class campaign_NewCampaign extends HttpServlet {
    
    
    private int tempPlanNumber;
    private String tempSubmitDate;
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
    private int tempDirectMail;
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
        
        tempPlanNumber = Integer.parseInt(request.getParameter("plan_number"));
        tempSubmitDate = request.getParameter("submit_date");
        tempContactName = request.getParameter("contact_name");
        tempCompanyName = request.getParameter("company_name");
        tempAddress = request.getParameter("company_address");
        tempEmail = request.getParameter("contact_email");
        tempPhone = request.getParameter("contact_phone");
    
        tempProgramDate = request.getParameter("program_date");
        tempStartTime = request.getParameter("start_time");
        tempEndTime = request.getParameter("end_time");
        tempEstimatedOfAttendess = Integer.parseInt(request.getParameter("attendum"));
        tempVenueName = request.getParameter("venue_name");
        tempVenueAddress = request.getParameter("venue_address");
    
        tempFaceToFaceEvent = (Integer.parseInt(request.getParameter("face_to_face")) == 1) ? 1 : 0;
        tempTradeshow = (Integer.parseInt(request.getParameter("tradeshow")) == 1) ? 1 : 0;
        tempMultitouchCampaign = (Integer.parseInt(request.getParameter("multitouch")) == 1) ? 1 : 0;
        tempDoorOpenerCampaign = (Integer.parseInt(request.getParameter("door_opener")) == 1) ? 1 : 0;
        tempThirdPartyCampaign = (Integer.parseInt(request.getParameter("third_party")) == 1) ? 1 : 0;
        tempDirectMail = (Integer.parseInt(request.getParameter("direct_mail")) == 1) ? 1 : 0;
        tempBlitzCampaign = (Integer.parseInt(request.getParameter("blitz")) == 1) ? 1 : 0;
        tempProgramDescription = request.getParameter("program_desc");
    
        tempDellStorageSC4000Series = (Integer.parseInt(request.getParameter("storage_sc4000")) == 1) ? 1 : 0;
        tempDellStoragePS4210Series = (Integer.parseInt(request.getParameter("storage_ps4210")) == 1) ? 1 : 0;
        tempDellStorageSolution = (Integer.parseInt(request.getParameter("storage_solutions")) == 1) ? 1 : 0;
        tempFlashAtThePriceOfDisk = (Integer.parseInt(request.getParameter("storage_flash")) == 1) ? 1 : 0;
        tempFluidCacheForSAN = (Integer.parseInt(request.getParameter("storage_fluid_cache")) == 1) ? 1 : 0;
        tempDateProtection = (Integer.parseInt(request.getParameter("storage_data_protection")) == 1) ? 1 : 0;
        tempTheLastGenerationOfDellPowerEdgeServers = (Integer.parseInt(request.getParameter("server_newgen")) == 1) ? 1 : 0;
        tempWindowsServer2003Migration = (Integer.parseInt(request.getParameter("server_win2003")) == 1) ? 1 : 0;
        tempX86ServerTransition = (Integer.parseInt(request.getParameter("server_x86")) == 1) ? 1 : 0;
        tempPowerEdgeVRTX = (Integer.parseInt(request.getParameter("server_vrtx")) == 1) ? 1 : 0;
        tempSoftwareDefinedNetworking =(Integer.parseInt(request.getParameter("networking_sdn")) == 1) ? 1 : 0;
        tempUserCentricNetworking = (Integer.parseInt(request.getParameter("networking_user_centric")) == 1) ? 1 : 0;
        tempCloudClientComputing = (Integer.parseInt(request.getParameter("solutions_cloud")) == 1) ? 1 : 0;
        tempConvergedInfrastructureHardware = (Integer.parseInt(request.getParameter("solutions_converged")) == 1) ? 1 : 0;
        tempDellConvergedBladeDataCenter = (Integer.parseInt(request.getParameter("solutions_blade")) == 1) ? 1 : 0;
        tempOptimizedEnteprise = (Integer.parseInt(request.getParameter("solutions_futureready")) == 1) ? 1 : 0;
        tempPowerEdgeFXArchitecture = (Integer.parseInt(request.getParameter("solutions_powereedge")) == 1) ? 1 : 0;
        tempSoftwareDefinedStorage = (Integer.parseInt(request.getParameter("solutions_sds")) == 1) ? 1 : 0;
        tempIsThereASoftwareComponentToYourCampaign = request.getParameter("campaign_component");
    
        tempSMB = (Integer.parseInt(request.getParameter("target_smb")) == 1) ? 1 : 0;
        tempLE = (Integer.parseInt(request.getParameter("target_le")) == 1) ? 1 : 0;
        tempPUB = (Integer.parseInt(request.getParameter("target_pub")) == 1) ? 1 : 0;
    
        tempTotalProjectedCostOfProgram = Double.parseDouble(request.getParameter("cost"));
        tempTotalMDFRequestingFromDell = Double.parseDouble(request.getParameter("mdf_req"));
        tempPreferredMethodOfReimbursement = request.getParameter("reimbursement");
        tempParticipatingTechnologyPartner = request.getParameter("partners");
        tempTotalTechnologyPartner = Double.parseDouble(request.getParameter("mdf_contr"));
        tempEstimatedOfOpportunitues = Integer.parseInt(request.getParameter("opportunities"));
        tempEstimatedRevenueFromProgram = Integer.parseInt(request.getParameter("est_renevue"));
        
        
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
       
        Campaign2 campaign = new Campaign2(tempPlanNumber, tempSubmitDate, tempContactName, tempCompanyName, tempAddress, tempEmail, tempPhone, tempProgramDate, tempStartTime, tempEndTime, tempEstimatedOfAttendess, tempVenueName, tempVenueAddress, tempFaceToFaceEvent, tempTradeshow, tempMultitouchCampaign, tempDoorOpenerCampaign, tempThirdPartyCampaign, tempDirectMail, tempBlitzCampaign, tempProgramDescription, tempDellStorageSC4000Series, tempDellStoragePS4210Series, tempDellStorageSolution, tempFlashAtThePriceOfDisk, tempFluidCacheForSAN, tempDateProtection, tempTheLastGenerationOfDellPowerEdgeServers, tempWindowsServer2003Migration, tempX86ServerTransition, tempPowerEdgeVRTX, tempSoftwareDefinedNetworking, tempUserCentricNetworking, tempCloudClientComputing, tempConvergedInfrastructureHardware, tempDellConvergedBladeDataCenter, tempOptimizedEnteprise, tempPowerEdgeFXArchitecture, tempSoftwareDefinedStorage, tempIsThereASoftwareComponentToYourCampaign, tempSMB, tempLE, tempPUB, tempTotalProjectedCostOfProgram, tempTotalMDFRequestingFromDell, tempPreferredMethodOfReimbursement, tempParticipatingTechnologyPartner, tempTotalTechnologyPartner, tempEstimatedOfOpportunitues, tempEstimatedRevenueFromProgram, "NOT READY");
        CampaignDAO cm = new CampaignDAO();

        try {
            cm.submitNewCampaignV2(campaign);
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