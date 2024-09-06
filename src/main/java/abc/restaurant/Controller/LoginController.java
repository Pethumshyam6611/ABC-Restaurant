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

@WebServlet({"/login", "/admin-panel", "/staff-panel", "/logout"})
public class LoginController extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.authenticateUser(username, password);
            if (user != null) {
                
                request.getSession().setAttribute("user", user);
                
                
                if ("Admin".equals(user.getRole())) {
                    response.sendRedirect("admin-panel");
                } else if ("Staff".equals(user.getRole())) {
                    response.sendRedirect("staff-panel");
                } else {
                   
                    request.setAttribute("errorMessage", "Invalid role");
                    request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
                }
            } else {
                
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp"); 
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        User user = (User) request.getSession().getAttribute("user");

        switch (path) {
            case "/login":
                
                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
                break;
            case "/admin-panel":
                if (user != null && "Admin".equals(user.getRole())) {
                    request.getRequestDispatcher("/WEB-INF/view/AdminPanel.jsp").forward(request, response);
                } else {
                    response.sendRedirect("login"); 
                }
                break;
            case "/staff-panel":
                if (user != null && "Staff".equals(user.getRole())) {
                    request.getRequestDispatcher("/WEB-INF/view/StaffPanel.jsp").forward(request, response);
                } else {
                    response.sendRedirect("login"); 
                }
                break;
            case "/logout":
               
                if (user != null) {
                    request.getSession().invalidate();

                   
                    String fromPage = request.getParameter("fromPage");
                    if ("mainPage".equals(fromPage)) {
                        response.sendRedirect("mainPage"); 
                    } else {
                        response.sendRedirect("login"); 
                    }
                } else {
                    response.sendRedirect("login"); 
                }
                break;
            default:
                response.sendRedirect("error.jsp"); 
                break;
        }
    }
}
