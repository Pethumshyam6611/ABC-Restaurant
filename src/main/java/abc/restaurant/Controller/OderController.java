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
@WebServlet("/oders")
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
            List<Oder> oderList = oderService.getAllOders();
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
        int productId = Integer.parseInt(request.getParameter("productId"));
        int userIdp = Integer.parseInt(request.getParameter("userIdp"));
        String type = request.getParameter("type");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        String status = request.getParameter("status");

        Oder newOder = new Oder();
        newOder.setProductId(productId);
        newOder.setUserIdp(userIdp);
        newOder.setType(type);
        newOder.setTotalPrice(totalPrice);
        newOder.setStatus(status);

        oderService.addOder(newOder);
        response.sendRedirect("oders?action=list");
    }

    private void updateOder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oderId = Integer.parseInt(request.getParameter("id"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int userIdp = Integer.parseInt(request.getParameter("userIdp"));
        String type = request.getParameter("type");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        String status = request.getParameter("status");

        Oder oder = new Oder();
        oder.setOderId(oderId);
        oder.setProductId(productId);
        oder.setUserIdp(userIdp);
        oder.setType(type);
        oder.setTotalPrice(totalPrice);
        oder.setStatus(status);

        oderService.updateOder(oder);
        response.sendRedirect("oders?action=list");
    }

    private void deleteOder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oderId = Integer.parseInt(request.getParameter("id"));

        oderService.deleteOder(oderId);
        response.sendRedirect("oders?action=list");
    }
}
