package view;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.User;
import data.UserDAO;
import java.sql.SQLException;

@WebServlet(name = "user_NewUser", urlPatterns = {"/user_NewUser"})
public class user_NewUser extends HttpServlet {

    private String tempUsername;
    private String tempPassword;
    private String tempFirstName;
    private String tempLastName;
    private String tempEmail;
    private int tempPhoneNumber;
    private String tempOrganization;

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
        
        // Create new user from requested parameters
        User user = new User(1, tempUsername, tempPassword, tempFirstName, tempLastName, tempEmail, tempPhoneNumber, tempOrganization, 1);
        
        UserDAO dm = new UserDAO();
        
        // Pass user object to the data accessor object
        try {
            dm.createNewUser(user);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("users_new.jsp");
        rd.forward(request, response);
    }
}
