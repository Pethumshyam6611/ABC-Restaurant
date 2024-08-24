package abc.restaurant.Controller;

import abc.restaurant.Model.Reservation;
import abc.restaurant.Services.ReservationService;

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
 * Servlet controller for reservation management operations.
 */
@WebServlet("/reservations")
public class ReservationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationService reservationService;

    @Override
    public void init() throws ServletException {
        reservationService = ReservationService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            listReservations(request, response);
        } else if (action.equals("new")) {
            showNewForm(request, response);
        } else if (action.equals("edit")) {
            showEditForm(request, response);
        } else if (action.equals("delete")) {
            deleteReservation(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("new")) {
            insertReservation(request, response);
        } else if (action.equals("update")) {
            updateReservation(request, response);
        }
    }

    private void listReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Reservation> reservationList = reservationService.getAllReservations();
            request.setAttribute("reservationList", reservationList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/reservationList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error retrieving reservation list: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/reservationForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("id"));
        Reservation existingReservation = reservationService.getReservationById(reservationId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/Editreservation.jsp");
        request.setAttribute("reservation", existingReservation);
        dispatcher.forward(request, response);
    }

    private void insertReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String serviceType = request.getParameter("serviceType");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
        String status = request.getParameter("status");

        Reservation newReservation = new Reservation();
        newReservation.setUserId(userId);
        newReservation.setServiceType(serviceType);
        newReservation.setDate(date);
        newReservation.setTime(time);
        newReservation.setNumberOfPeople(numberOfPeople);
        newReservation.setStatus(status);

        reservationService.addReservation(newReservation);
        response.sendRedirect("reservations?action=list");
    }

    private void updateReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String serviceType = request.getParameter("serviceType");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
        String status = request.getParameter("status");

        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        reservation.setUserId(userId);
        reservation.setServiceType(serviceType);
        reservation.setDate(date);
        reservation.setTime(time);
        reservation.setNumberOfPeople(numberOfPeople);
        reservation.setStatus(status);

        reservationService.updateReservation(reservation);
        response.sendRedirect("reservations?action=list");
    }

    private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("id"));

        reservationService.deleteReservation(reservationId);
        response.sendRedirect("reservations?action=list");
    }
}
