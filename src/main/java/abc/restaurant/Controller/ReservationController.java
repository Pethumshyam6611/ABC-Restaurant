package abc.restaurant.Controller;

import abc.restaurant.Model.Reservation;
import abc.restaurant.Services.ReservationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        }else if (action.equals("accept")) {
        	acceptReservation(request, response);
        }else if (action.equals("generatePDF")) {
        	generatePdf(request, response);
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
            List<Reservation> reservationList = reservationService.getAllReservationsWithUsers();
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
        String message = request.getParameter("message");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
        String status = request.getParameter("status");

        Reservation newReservation = new Reservation();
        newReservation.setUserId(userId);
        newReservation.setMessage(message);
        newReservation.setDate(date);
        newReservation.setTime(time);
        newReservation.setNumberOfPeople(numberOfPeople);
        newReservation.setStatus(status);

        try {
            reservationService.addReservation(newReservation);

            // Determine where to redirect based on a request parameter
            String source = request.getParameter("source");

            if ("mainPage".equals(source)) {
                // Redirect to main page with a success message
                request.getSession().setAttribute("successMessage", "Your table booking is successful!");
                response.sendRedirect("mainPage"); // Redirect to the main page
            } else {
                // Redirect to reservation list page
                response.sendRedirect("reservations?action=list");
            }
        } catch (Exception e) { // Catch general exceptions
            request.setAttribute("errorMessage", "Error adding reservation: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String message = request.getParameter("message");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
        String status = request.getParameter("status");

        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        reservation.setUserId(userId);
        reservation.setMessage(message);
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
    private void acceptReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            request.setAttribute("errorMessage", "Reservation ID is missing.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        int reservationId;
        try {
            reservationId = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid reservation ID format.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Reservation reservation = reservationService.getReservationById(reservationId);
        if (reservation != null && "pending".equalsIgnoreCase(reservation.getStatus())) {
            reservation.setStatus("confirmed");
            reservationService.updateReservation(reservation);
        }

        response.sendRedirect("reservations?action=list");
    }
    private void generatePdf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Reservation_Report.pdf");

        try {
            List<Reservation> reservationList = reservationService.getAllReservationsWithUsers();
            Document document = new Document(PageSize.A4); // Set page size to A4
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            // Add a big header
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Paragraph header = new Paragraph("Reservation Report", headerFont);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            document.add(new Paragraph(" ")); // Add space below the header

            // Add download date
            Font dateFont = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD);
            Paragraph dateParagraph = new Paragraph("Date: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()), dateFont);
            dateParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(dateParagraph);
            document.add(new Paragraph(" ")); // Add space below the date

            // Create tables for Pending and Confirmed Reservations
            PdfPTable pendingReservationsTable = new PdfPTable(6); // 6 columns
            PdfPTable confirmedReservationsTable = new PdfPTable(6); // 6 columns
            setTableColumnWidths(pendingReservationsTable, new float[]{1, 2, 1, 1, 1, 1});
            setTableColumnWidths(confirmedReservationsTable, new float[]{1, 2, 1, 1, 1, 1});
            addTableHeader(pendingReservationsTable);
            addTableHeader(confirmedReservationsTable);

            // Add rows to tables and calculate counts
            int pendingCount = addRows(pendingReservationsTable, reservationList, "pending");
            int confirmedCount = addRows(confirmedReservationsTable, reservationList, "confirmed");

            // Add the reservation count at the top of the page
            Font totalFont = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD);
            Paragraph reservationCountParagraph = new Paragraph("Total Reservations: " + (confirmedCount + pendingCount), totalFont);
            reservationCountParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(reservationCountParagraph);
            document.add(new Paragraph(" ")); // Space between total and tables

            // Add tables to document
            document.add(new Paragraph("Pending Reservations", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));
            document.add(new Paragraph(" ")); // Space between header and table
            document.add(pendingReservationsTable);

            document.add(new Paragraph(" ")); // Space between tables

            document.add(new Paragraph("Confirmed Reservations", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));
            document.add(new Paragraph(" ")); // Space between header and table
            document.add(confirmedReservationsTable);

            document.close();

        } catch (SQLException | DocumentException e) {
            throw new ServletException("Error generating PDF", e);
        }
    }

    private void setTableColumnWidths(PdfPTable table, float[] columnWidths) throws DocumentException {
        try {
            table.setWidths(columnWidths);
        } catch (DocumentException e) {
            throw new DocumentException("Error setting table column widths", e);
        }
    }

    private void addTableHeader(PdfPTable table) {
        String[] headers = {"Reservation ID", "User ID", "Date", "Time", "Number of People", "Status"};
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

        // Set header background color to green
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Paragraph(header, headerFont));
            cell.setBackgroundColor(BaseColor.GREEN);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8);
            table.addCell(cell);
        }
    }

    private int addRows(PdfPTable table, List<Reservation> reservationList, String statusFilter) {
        int count = 0;
        for (Reservation reservation : reservationList) {
            if (statusFilter.equalsIgnoreCase(reservation.getStatus())) {
                table.addCell(String.valueOf(reservation.getReservationId()));
                table.addCell(String.valueOf(reservation.getUserId()));
                table.addCell(reservation.getDate());
                table.addCell(reservation.getTime());
                table.addCell(String.valueOf(reservation.getNumberOfPeople()));
                table.addCell(reservation.getStatus());
                count++;
            }
        }
        return count;
    }

    private int getReservationCount(List<Reservation> reservationList, String statusFilter) {
        int count = 0;
        for (Reservation reservation : reservationList) {
            if (statusFilter.equalsIgnoreCase(reservation.getStatus())) {
                count++;
            }
        }
        return count;
    }
    
    

}
