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

@WebServlet({"/login", "/admin-panel", "/staff-panel"})
public class LoginController extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.authenticateUser(username, password);
            if (user != null) {
                // Authentication successful
                request.getSession().setAttribute("user", user); // Set user in session
                
                if ("Admin".equals(user.getRole())) {
                    response.sendRedirect("admin-panel");
                } else if ("Staff".equals(user.getRole())) {
                    response.sendRedirect("staff-panel");
                } else if ("Customer".equals(user.getRole())) {
                    // Pass user ID to index.jsp via session
                    request.getSession().setAttribute("userId", user.getUserId());
                    request.getSession().setAttribute("username", user.getUsername());
                    response.sendRedirect("mainPage"); // Redirect to index.jsp for customers
                } else {
                    request.setAttribute("errorMessage", "Invalid role");
                    request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
                }
            } else {
                // Authentication failed
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp"); // Redirect to an error page
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        User user = (User) request.getSession().getAttribute("user");

        if ("/login".equals(path)) {
            // Allow access to the login page
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        } else if ("/admin-panel".equals(path)) {
            if (user != null && "Admin".equals(user.getRole())) {
                request.getRequestDispatcher("/WEB-INF/view/AdminPanel.jsp").forward(request, response);
            } else {
                response.sendRedirect("login"); // Redirect to login if not authorized
            }
        } else if ("/staff-panel".equals(path)) {
            if (user != null && "Staff".equals(user.getRole())) {
                request.getRequestDispatcher("/WEB-INF/view/StaffPanel.jsp").forward(request, response);
            } else {
                response.sendRedirect("login"); // Redirect to login if not authorized
            }
        } else {
            response.sendRedirect("error.jsp"); // Redirect to an error page if path is unknown
        }
    }
}

