/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import facade.facadeCtrl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DTO.Campaign2;
import exceptions.DatabaseErrorException;

/**
 *
 * @author jonassimonsen
 */
@WebServlet(name = "campaign_NewCampaign", urlPatterns = {"/campaign_NewCampaign"})
public class campaign_NewCampaign extends HttpServlet {

    private int tempPlanNumber = 1;
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
    private int tempHasPOE = 0;
    
    private int tempID;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        s.setMaxInactiveInterval(30 * 60);
        String UN = s.getAttribute("username").toString();
        
        
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

        tempFaceToFaceEvent = (request.getParameter("face_to_face") == null) ? 0 : 1;
        System.out.println(tempFaceToFaceEvent);
        tempTradeshow = (request.getParameter("tradeshow") == null) ? 0 : 1;
        tempMultitouchCampaign = (request.getParameter("multitouch") == null) ? 0 : 1;
        tempDoorOpenerCampaign = (request.getParameter("door_opener") == null) ? 0 : 1;
        tempThirdPartyCampaign = (request.getParameter("third_party") == null) ? 0 : 1;
        tempDirectMail = (request.getParameter("direct_mail") == null) ? 0 : 1;
        tempBlitzCampaign = (request.getParameter("blitz") == null) ? 0 : 1;
        tempProgramDescription = request.getParameter("program_desc");

        tempDellStorageSC4000Series = (request.getParameter("storage_sc4000") == null) ? 0 : 1;
        tempDellStoragePS4210Series = (request.getParameter("storage_ps4210") == null) ? 0 : 1;
        tempDellStorageSolution = (request.getParameter("storage_solutions") == null) ? 0 : 1;
        tempFlashAtThePriceOfDisk = (request.getParameter("storage_flash") == null) ? 0 : 1;
        tempFluidCacheForSAN = (request.getParameter("storage_fluid_cache") == null) ? 0 : 1;
        tempDateProtection = (request.getParameter("storage_data_protection") == null) ? 0 : 1;
        tempTheLastGenerationOfDellPowerEdgeServers = (request.getParameter("server_newgen") == null) ? 0 : 1;
        tempWindowsServer2003Migration = (request.getParameter("server_win2003") == null) ? 0 : 1;
        tempX86ServerTransition = (request.getParameter("server_x86") == null) ? 0 : 1;
        tempPowerEdgeVRTX = (request.getParameter("server_vrtx") == null) ? 0 : 1;
        tempSoftwareDefinedNetworking = (request.getParameter("networking_sdn") == null) ? 0 : 1;
        tempUserCentricNetworking = (request.getParameter("networking_user_centric") == null) ? 0 : 1;
        tempCloudClientComputing = (request.getParameter("solutions_cloud") == null) ? 0 : 1;
        tempConvergedInfrastructureHardware = (request.getParameter("solutions_converged") == null) ? 0 : 1;
        tempDellConvergedBladeDataCenter = (request.getParameter("solutions_blade") == null) ? 0 : 1;
        tempOptimizedEnteprise = (request.getParameter("solutions_futureready") == null) ? 0 : 1;
        tempPowerEdgeFXArchitecture = (request.getParameter("solutions_powereedge") == null) ? 0 : 1;
        tempSoftwareDefinedStorage = (request.getParameter("solutions_sds") == null) ? 0 : 1;
        tempIsThereASoftwareComponentToYourCampaign = request.getParameter("campaign_component");

        tempSMB = (request.getParameter("target_smb") == null) ? 0 : 1;
        tempLE = (request.getParameter("target_le") == null) ? 0 : 1;
        tempPUB = (request.getParameter("target_pub") == null) ? 0 : 1;

        tempTotalProjectedCostOfProgram = Double.parseDouble(request.getParameter("cost"));
        tempTotalMDFRequestingFromDell = Double.parseDouble(request.getParameter("mdf_req"));
        tempPreferredMethodOfReimbursement = request.getParameter("reimbursement");
        tempParticipatingTechnologyPartner = request.getParameter("partners");
        tempTotalTechnologyPartner = Double.parseDouble(request.getParameter("mdf_contr"));
        tempEstimatedOfOpportunitues = Integer.parseInt(request.getParameter("opportunities"));
        tempEstimatedRevenueFromProgram = Integer.parseInt(request.getParameter("est_renevue"));

        Campaign2 campaign = new Campaign2(tempPlanNumber, tempSubmitDate, tempContactName, tempCompanyName, tempAddress, tempEmail, tempPhone, tempProgramDate, tempStartTime, tempEndTime, tempEstimatedOfAttendess, tempVenueName, tempVenueAddress, tempFaceToFaceEvent, tempTradeshow, tempMultitouchCampaign, tempDoorOpenerCampaign, tempThirdPartyCampaign, tempDirectMail, tempBlitzCampaign, tempProgramDescription, tempDellStorageSC4000Series, tempDellStoragePS4210Series, tempDellStorageSolution, tempFlashAtThePriceOfDisk, tempFluidCacheForSAN, tempDateProtection, tempTheLastGenerationOfDellPowerEdgeServers, tempWindowsServer2003Migration, tempX86ServerTransition, tempPowerEdgeVRTX, tempSoftwareDefinedNetworking, tempUserCentricNetworking, tempCloudClientComputing, tempConvergedInfrastructureHardware, tempDellConvergedBladeDataCenter, tempOptimizedEnteprise, tempPowerEdgeFXArchitecture, tempSoftwareDefinedStorage, tempIsThereASoftwareComponentToYourCampaign, tempSMB, tempLE, tempPUB, tempTotalProjectedCostOfProgram, tempTotalMDFRequestingFromDell, tempPreferredMethodOfReimbursement, tempParticipatingTechnologyPartner, tempTotalTechnologyPartner, tempEstimatedOfOpportunitues, tempEstimatedRevenueFromProgram, "NOT READY",tempHasPOE,tempID);
        facadeCtrl facade = new facadeCtrl();

        try {
            int ID = facade.getUserID(UN);
            facade.submitNewCampaignV2(campaign,ID);
        } catch (DatabaseErrorException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("ext_campaigns_submit.jsp");
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
