package abc.restaurant.Controller;

import abc.restaurant.Model.Oder;
import abc.restaurant.Model.User;
import abc.restaurant.Services.OderService;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        } else if (action.equals("accept")) {
            acceptOder(request, response);
        } else if (action.equals("downloadPdf")) {
            generatePdf(request, response);
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
        String source = request.getParameter("source");

        Oder newOder = new Oder(0, foodNamewithQT, userIdp, type, totalPrice, status, datetime);
        oderService.addOder(newOder);
        
        // Redirect based on the source parameter
        if ("addForm".equals(source)) {
            response.sendRedirect("oder?action=list");
        } else {
            response.sendRedirect("mainPage");
        }
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

    private void acceptOder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        Oder oder = oderService.getOderById(oderId);
        if (oder != null && "pending".equalsIgnoreCase(oder.getStatus())) {
            oder.setStatus("Accepted");
            oderService.updateOder(oder);
        }

        response.sendRedirect("oder?action=list");
    }
    
    
    private void generatePdf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Annual_Sales_Report.pdf");

        try {
            List<Oder> oderList = oderService.getAllOdersWithUsers();
            Document document = new Document(PageSize.A3); // Set page size to vertical (A3)
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            // Add a big header
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Paragraph header = new Paragraph("Annual Sales Report", headerFont);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            document.add(new Paragraph(" ")); // Add space below the header

            // Add download date
            Font dateFont = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD);
            Paragraph dateParagraph = new Paragraph("Date: " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()), dateFont);
            dateParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(dateParagraph);
            document.add(new Paragraph(" ")); // Add space below the date

            // Calculate total price for all orders and counts
            double pendingTotalPrice = 0.0;
            double acceptedTotalPrice = 0.0;
            int pendingOrderCount = 0;
            int acceptedOrderCount = 0;

            // Create tables for Pending and Accepted Orders
            PdfPTable pendingOrdersTable = new PdfPTable(9); // 9 columns
            PdfPTable acceptedOrdersTable = new PdfPTable(9); // 9 columns
            setTableColumnWidths(pendingOrdersTable, new float[]{1, 2, 1, 1, 1, 1, 2, 2, 2});
            setTableColumnWidths(acceptedOrdersTable, new float[]{1, 2, 1, 1, 1, 1, 2, 2, 2});
            addTableHeader(pendingOrdersTable);
            addTableHeader(acceptedOrdersTable);

            // Add rows to tables and calculate total prices and counts
            pendingTotalPrice = addRows(pendingOrdersTable, oderList, "pending");
            pendingOrderCount = getOrderCount(oderList, "pending");
            acceptedTotalPrice = addRows(acceptedOrdersTable, oderList, "accepted");
            acceptedOrderCount = getOrderCount(oderList, "accepted");

            // Add the total price and order count at the top of the page
            Font totalFont = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD);
            Paragraph totalParagraph = new Paragraph("Total Price: Rs. " + String.format("%.2f", (pendingTotalPrice + acceptedTotalPrice)), totalFont);
            totalParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(totalParagraph);

            Paragraph orderCountParagraph = new Paragraph("Total Orders: " + (pendingOrderCount + acceptedOrderCount), totalFont);
            orderCountParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(orderCountParagraph);
            document.add(new Paragraph(" ")); // Space between total and tables

            // Add tables to document
            document.add(new Paragraph("Pending Orders", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));
            document.add(new Paragraph(" ")); // Space between header and table
            document.add(pendingOrdersTable);

            document.add(new Paragraph(" ")); // Space between tables

            document.add(new Paragraph("Accepted Orders", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));
            document.add(new Paragraph(" ")); // Space between header and table
            document.add(acceptedOrdersTable);

            // Add bar chart
            document.newPage();
            Paragraph chartTitle = new Paragraph("Sales by Date", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
            document.add(chartTitle);
            document.add(new Paragraph(" ")); // Space before chart
            
            // Create chart and convert to image
            BufferedImage chartImage = createSalesBarChart(oderList);
            ByteArrayOutputStream chartStream = new ByteArrayOutputStream();
            ImageIO.write(chartImage, "png", chartStream);
            Image pdfChartImage = Image.getInstance(chartStream.toByteArray());
            pdfChartImage.setAlignment(Image.ALIGN_CENTER);
            document.add(pdfChartImage);

            document.close();

        } catch (SQLException | DocumentException | IOException e) {
            throw new ServletException("Error generating PDF", e);
        }
    }

    private BufferedImage createSalesBarChart(List<Oder> oderList) {
        // Group orders by date and calculate total sales per date
        Map<String, Double> salesByDate = new HashMap<>();
        for (Oder oder : oderList) {
            String date = oder.getDatetime().split(" ")[0]; // Extract date from datetime
            salesByDate.put(date, salesByDate.getOrDefault(date, 0.0) + oder.getTotalPrice());
        }

        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Double> entry : salesByDate.entrySet()) {
            dataset.addValue(entry.getValue(), "Sales", entry.getKey());
        }

        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Sales by Date", // Chart title
            "Date", // X-axis label
            "Total Sales (Rs.)", // Y-axis label
            dataset, // Dataset
            PlotOrientation.VERTICAL, // Plot orientation
            true, // Include legend
            true, // Tooltips
            false // URLs
        );

        // Customize chart appearance
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        return chart.createBufferedImage(800, 600);
    }
    private void setTableColumnWidths(PdfPTable table, float[] columnWidths) throws DocumentException {
        try {
            table.setWidths(columnWidths);
        } catch (DocumentException e) {
            throw new DocumentException("Error setting table column widths", e);
        }
    }

    private void addTableHeader(PdfPTable table) {
        String[] headers = {"Order ID", "Food Name with Quantity", "User ID", "Type", "Total Price", "Status", "Date & Time", "Username", "Email"};
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

    private double addRows(PdfPTable table, List<Oder> oderList, String statusFilter) {
        double totalPrice = 0.0;
        for (Oder oder : oderList) {
            if (statusFilter.equalsIgnoreCase(oder.getStatus())) {
                table.addCell(String.valueOf(oder.getOderId()));
                table.addCell(oder.getFoodNamewithQT());
                table.addCell(String.valueOf(oder.getUserIdp()));
                table.addCell(oder.getType());
                double price = oder.getTotalPrice();
                table.addCell(String.format("%.2f", price));
                table.addCell(oder.getStatus());
                table.addCell(oder.getDatetime());
                User user = oder.getUserDetails();
                table.addCell(user != null ? user.getUsername() : "N/A");
                table.addCell(user != null ? user.getEmail() : "N/A");
                totalPrice += price;
            }
        }
        return totalPrice;
    }

    private int getOrderCount(List<Oder> oderList, String statusFilter) {
        int count = 0;
        for (Oder oder : oderList) {
            if (statusFilter.equalsIgnoreCase(oder.getStatus())) {
                count++;
            }
        }
        return count;
    }}
