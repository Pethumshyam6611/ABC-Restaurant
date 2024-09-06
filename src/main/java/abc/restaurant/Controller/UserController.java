package abc.restaurant.Controller;

import abc.restaurant.Model.User;
import abc.restaurant.Services.UserService;

import javax.mail.MessagingException;
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
        String password = request.getParameter("password"); // Should be hashed before saving
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String phoneStr = request.getParameter("phone");

        try {
            int phone = Integer.parseInt(phoneStr);

            if (userService.isEmailOrPhoneExists(email, phone)) {
                handleDuplicateEntry(request, response, role);
                return;
            }

            User user = new User();
            user.setUsername(username);
            user.setPassword(password); // Hash password before storing
            user.setRole(role);
            user.setEmail(email);
            user.setPhone(phone);

            userService.addUser(user);

            // Send confirmation email with username
            sendConfirmationEmail(email, username);

            if ("Customer".equals(role)) {
                response.sendRedirect("mainPage");
            } else {
                response.sendRedirect("user?action=list");
            }
        } catch (NumberFormatException e) {
            handleException(request, response, "Invalid phone number format.");
        } catch (SQLException e) {
            handleException(request, response, "Error adding user: " + e.getMessage());
        } catch (MessagingException e) {
            handleException(request, response, "Error sending email: " + e.getMessage());
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

    private void sendConfirmationEmail(String to, String username) throws MessagingException {
        String subject = "Welcome to Our Service!";
        
        // HTML body
        String body = "<html><body>"
                + "<div style='font-family: Arial, sans-serif; color: #333;'>"
                + "<h2 style='color: #4CAF50;'>Welcome, " + username + "!</h2>"
                + "<p style='font-size: 16px;'>Thank you for joining us at <strong>ABC Restaurant</strong>. We're thrilled to have you on board.</p>"
                + "<p style='font-size: 16px;'>As a member, you'll enjoy exclusive offers and updates about our latest dishes and events. Stay tuned for exciting news!</p>"
                + "<p style='font-size: 16px;'>If you have any questions or need assistance, feel free to reach out to our support team at any time.</p>"
                + "<p style='font-size: 16px;'>Best regards,<br/>The ABC Restaurant Team</p>"
                + "</div>"
                + "</body></html>";
        
        EmailUtil.sendEmail(to, subject, body);
    }
    private void handleException(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("errorMessage", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
        dispatcher.forward(request, response);
    }

    private void handleDuplicateEntry(HttpServletRequest request, HttpServletResponse response, String role) throws ServletException, IOException {
        if ("Customer".equals(role)) {
            request.getSession().setAttribute("errorMessage", "Email or phone number already in use.");
            response.sendRedirect("mainPage");
        } else {
            request.setAttribute("errorMessage", "Email or phone number already in use.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }
    

}
