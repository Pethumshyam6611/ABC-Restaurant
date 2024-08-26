package abc.restaurant.Controller;

import abc.restaurant.Model.User;
import abc.restaurant.Services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet controller for user management operations.
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            listUsers(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        } else if (action.equals("edit")) {
            showEditForm(request, response);
        } else if (action.equals("delete")) {
            deleteUser(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("add")) {
            addUser(request, response);
        } else if (action.equals("update")) {
            updateUser(request, response);
        } else if (action.equals("login")) {
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> userList = userService.getAllUsers();
            request.setAttribute("userList", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/userList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error retrieving user list: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/addUser.jsp");
        dispatcher.forward(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setEmail(email);
        user.setPhone(phone);

        try {
            userService.addUser(user);
            response.sendRedirect("user?action=list");
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error adding user: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !id.trim().isEmpty()) {
            try {
                int userId = Integer.parseInt(id);
                User user = userService.getUserById(userId);
                if (user != null) {
                    request.setAttribute("user", user);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/editUser.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "User not found.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid user ID format.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("errorMessage", "Error retrieving user: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("user?action=list");
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));

        if (id != null) {
            try {
                int userId = Integer.parseInt(id);
                User user = new User();
                user.setUserId(userId);
                user.setUsername(username);
                user.setPassword(password);
                user.setRole(role);
                user.setEmail(email);
                user.setPhone(phone);

                userService.updateUser(user);
                response.sendRedirect("user?action=list");
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid user ID format.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("errorMessage", "Error updating user: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("user?action=list");
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            try {
                int userId = Integer.parseInt(id);
                userService.deleteUser(userId);
                response.sendRedirect("user?action=list");
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid user ID format.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("errorMessage", "Error deleting user: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("user?action=list");
        }
    }

   

}
