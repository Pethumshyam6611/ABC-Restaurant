package abc.restaurant.Controller;

import abc.restaurant.Model.Oder;
import abc.restaurant.Services.OderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet controller for order management operations.
 */
@WebServlet("/oder")
public class OderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OderService oderService;

    @Override
    public void init() throws ServletException {
        oderService = OderService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            listOders(request, response);
        } else if (action.equals("new")) {
            showNewForm(request, response);
        } else if (action.equals("edit")) {
            showEditForm(request, response);
        } else if (action.equals("delete")) {
            deleteOder(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("new")) {
            insertOder(request, response);
        } else if (action.equals("update")) {
            updateOder(request, response);
        }
    }

    private void listOders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Oder> oderList = oderService.getAllOdersWithUsers();
            request.setAttribute("oderList", oderList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/oderList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error retrieving order list: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/oderForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oderId = Integer.parseInt(request.getParameter("id"));
        Oder existingOder = oderService.getOderById(oderId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/EditOder.jsp");
        request.setAttribute("oder", existingOder);
        dispatcher.forward(request, response);
    }

    private void insertOder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodNamewithQT = request.getParameter("foodNamewithQT");
        int userIdp = Integer.parseInt(request.getParameter("userIdp"));
        String type = request.getParameter("type");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        String status = request.getParameter("status");
        String datetime = request.getParameter("datetime");

        Oder newOder = new Oder(0, foodNamewithQT, userIdp, type, totalPrice, status, datetime);
        oderService.addOder(newOder);
        response.sendRedirect("oder?action=list");
    }

    private void updateOder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            request.setAttribute("errorMessage", "Order ID is missing.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        int oderId;
        try {
            oderId = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid order ID format.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        String foodNamewithQT = request.getParameter("foodNamewithQT");
        int userIdp;
        try {
            userIdp = Integer.parseInt(request.getParameter("userIdp"));
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid user ID format.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        String type = request.getParameter("type");
        double totalPrice;
        try {
            totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid total price format.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        String status = request.getParameter("status");
        String datetime = request.getParameter("datetime");

        Oder oder = new Oder(oderId, foodNamewithQT, userIdp, type, totalPrice, status, datetime, null);
        oderService.updateOder(oder);
        response.sendRedirect("oder?action=list");
    }

    private void deleteOder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oderId = Integer.parseInt(request.getParameter("id"));
        oderService.deleteOder(oderId);
        response.sendRedirect("oder?action=list");
    }
}
