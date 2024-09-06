package abc.restaurant.Controller;

import abc.restaurant.Model.User;
import abc.restaurant.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/customer-login")
public class CustomerLoginController extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.authenticateUser(username, password);
            if (user != null && "Customer".equals(user.getRole())) {
                
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("userId", user.getUserId());
                request.getSession().setAttribute("username", user.getUsername());
                response.sendRedirect("mainPage");
            } else {
                
                request.getSession().setAttribute("errorMessage", "Invalid username or password");
                response.sendRedirect("mainPage");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp"); 
        }
    }
}
