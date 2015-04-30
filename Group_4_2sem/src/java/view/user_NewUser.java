package view;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DTO.User;
import exceptions.DatabaseErrorException;
import facade.facadeCtrl;
import interfaces.Interface_CtrlFacade;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "user_NewUser", urlPatterns = {"/user_NewUser"})
public class user_NewUser extends HttpServlet {

    private String tempUsername;
    private String tempPassword;
    private String tempFirstName;
    private String tempLastName;
    private String tempEmail;
    private int tempPhoneNumber;
    private String tempOrganization;
    private String tempInternal, tempExternal;
    private int type;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from form
        tempUsername = request.getParameter("username");
        tempPassword = request.getParameter("password");
        tempFirstName = request.getParameter("first-name");
        tempLastName = request.getParameter("last-name");
        tempEmail = request.getParameter("email");
        tempPhoneNumber = Integer.parseInt(request.getParameter("phone"));
        tempOrganization = request.getParameter("organization");
        tempInternal = request.getParameter("user-type-internal");
        tempExternal = request.getParameter("user-type-external");

        if ("1".equals(tempInternal)) {
            type = 1;
        } else if ("1".equals(tempExternal)) {
            type = 0;
        }

        // Create new user from requested parameters
        User user = new User(1, tempUsername, tempPassword, tempFirstName, tempLastName, tempEmail, tempPhoneNumber, tempOrganization, type);

        Interface_CtrlFacade ctrl = new facadeCtrl();

        // Pass user object to the data accessor object
        try {
            ctrl.createNewUser(user);
        } catch (DatabaseErrorException | ClassNotFoundException ex) {
            Logger.getLogger(user_NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher("int_users_new.jsp");
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
