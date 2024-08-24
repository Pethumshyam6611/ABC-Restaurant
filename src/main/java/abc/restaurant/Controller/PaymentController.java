package abc.restaurant.Controller;

import abc.restaurant.Model.Payment;
import abc.restaurant.Services.PaymentService;

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
 * Servlet controller for payment management operations.
 */
@WebServlet("/payments")
public class PaymentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PaymentService paymentService;

    @Override
    public void init() throws ServletException {
        paymentService = PaymentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            listPayments(request, response);
        } else if (action.equals("new")) {
            showNewForm(request, response);
        } else if (action.equals("edit")) {
            showEditForm(request, response);
        } else if (action.equals("delete")) {
            deletePayment(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("new")) {
            insertPayment(request, response);
        } else if (action.equals("update")) {
            updatePayment(request, response);
        }
    }

    private void listPayments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Payment> paymentList = paymentService.getAllPayments();
            request.setAttribute("paymentList", paymentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/paymentList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error retrieving payment list: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/paymentForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int paymentId = Integer.parseInt(request.getParameter("id"));
        Payment existingPayment = paymentService.getPaymentById(paymentId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/editPayment.jsp");
        request.setAttribute("payment", existingPayment);
        dispatcher.forward(request, response);
    }

    private void insertPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oderId = Integer.parseInt(request.getParameter("oderId"));
        String paymentDateTime = request.getParameter("paymentDateTime");
        String method = request.getParameter("method");

        Payment newPayment = new Payment();
        newPayment.setOderId(oderId);
        newPayment.setPaymentDateTime(paymentDateTime);
        newPayment.setMethod(method);

        paymentService.addPayment(newPayment);
        response.sendRedirect("payments?action=list");
    }

    private void updatePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int paymentId = Integer.parseInt(request.getParameter("id"));
        int oderId = Integer.parseInt(request.getParameter("oderId"));
        String paymentDateTime = request.getParameter("paymentDateTime");
        String method = request.getParameter("method");

        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        payment.setOderId(oderId);
        payment.setPaymentDateTime(paymentDateTime);
        payment.setMethod(method);

        paymentService.updatePayment(payment);
        response.sendRedirect("payments?action=list");
    }

    private void deletePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int paymentId = Integer.parseInt(request.getParameter("id"));

        paymentService.deletePayment(paymentId);
        response.sendRedirect("payments?action=list");
    }
}
