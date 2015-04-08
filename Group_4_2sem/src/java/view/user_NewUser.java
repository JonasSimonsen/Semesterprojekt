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

    String tempUsername;
    String tempPassword;
    String tempFirstName;
    String tempLastName;
    String tempEmail;
    int tempPhoneNumber;
    String tempOrganization;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        tempUsername = request.getParameter("username");
        tempPassword = request.getParameter("password");
        tempFirstName = request.getParameter("first-name");
        tempLastName = request.getParameter("last-name");
        tempEmail = request.getParameter("email");
        tempPhoneNumber = Integer.parseInt(request.getParameter("phone"));
        tempOrganization = request.getParameter("organization");

        User user = new User(1, tempUsername, tempPassword, tempFirstName, tempLastName, tempEmail, tempPhoneNumber, tempOrganization, 1);
        UserDAO dm = new UserDAO();

        try {
            dm.createNewUser(user);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("users_new.jsp");
        rd.forward(request, response);
    }
}
