<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="abc.restaurant.Model.Reservation" %>
<%@ page import="abc.restaurant.Model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 30px;
        }
        .table {
            background-color: #ffffff;
            border-radius: 0.5rem;
            overflow: hidden;
        }
        .table thead th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
            text-align: center;
        }
        .table tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .table tbody tr:hover {
            background-color: #e9ecef;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-warning {
            background-color: #ffc107;
            border: none;
        }
        .btn-warning:hover {
            background-color: #e0a800;
        }
        .btn-danger {
            background-color: #dc3545;
            border: none;
        }
        .btn-danger:hover {
            background-color: #c82333;
        }
        .btn-actions {
            display: flex;
            justify-content: center;
            gap: 0.5rem;
        }
        .text-primary {
            color: #007bff !important;
        }
        .btn-sm {
            font-size: 0.875rem;
            padding: 0.25rem 0.5rem;
        }
        .table th, .table td {
            vertical-align: middle;
        }
        .alert {
            margin-top: 20px;
        }
        .add-reservation-btn {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row mb-4">
            <div class="col-md-12">
                <h2 class="text-primary">Reservation List</h2>              
                <a href="reservations?action=new" class="btn btn-primary add-reservation-btn">Add Reservation</a>
                 
            </div>
        </div>

        <%-- Get the list of reservations --%>
        <%
            List<Reservation> reservationList = (List<Reservation>) request.getAttribute("reservationList");
            List<Reservation> confirmedReservations = new ArrayList<>();
            List<Reservation> pendingReservations = new ArrayList<>();

            // Separate reservations based on their status
            if (reservationList != null) {
                for (Reservation reservation : reservationList) {
                    if ("confirmed".equalsIgnoreCase(reservation.getStatus())) {
                        confirmedReservations.add(reservation);
                    } else if ("pending".equalsIgnoreCase(reservation.getStatus())) {
                        pendingReservations.add(reservation);
                    }
                }
            }
        %>
		        <%-- Display Pending Reservations --%>
        <h3>Pending Reservations</h3>
        <% if (pendingReservations.isEmpty()) { %>
            <div class="alert alert-warning">No pending reservations found.</div>
        <% } else { %>
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Reservation ID</th>
                            <th>User ID</th>
                            <th>Message</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Number of People</th>
                            <th>Status</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Reservation reservation : pendingReservations) { 
                            User user = reservation.getUserDetails();
                        %>
                        <tr>
                            <td><%= reservation.getReservationId() %></td>
                            <td><%= reservation.getUserId() %></td>
                            <td><%= reservation.getMessage() %></td>
                            <td><%= reservation.getDate() %></td>
                            <td><%= reservation.getTime() %></td>
                            <td><%= reservation.getNumberOfPeople() %></td>
                            <td><%= reservation.getStatus() %></td>
                            <td><%= user != null ? user.getUsername() : "N/A" %></td>
                            <td><%= user != null ? user.getEmail() : "N/A" %></td>
                            <td><%= user != null ? user.getPhone() : "N/A" %></td>
                            <td class="btn-actions">
                            	<a href="reservations?action=accept&id=<%= reservation.getReservationId() %>" class="btn btn-success btn-sm">Accept</a>
                                <a href="reservations?action=edit&id=<%= reservation.getReservationId() %>" class="btn btn-warning btn-sm">Edit</a>
                                <a href="reservations?action=delete&id=<%= reservation.getReservationId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this reservation?')">Delete</a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        <% } %>
        <%-- Display Confirmed Reservations --%>
        <h3>Confirmed Reservations</h3>
        <% if (confirmedReservations.isEmpty()) { %>
            <div class="alert alert-warning">No confirmed reservations found.</div>
        <% } else { %>
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Reservation ID</th>
                            <th>User ID</th>
                            <th>Message</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Number of People</th>
                            <th>Status</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Reservation reservation : confirmedReservations) { 
                            User user = reservation.getUserDetails();
                        %>
                        <tr>
                            <td><%= reservation.getReservationId() %></td>
                            <td><%= reservation.getUserId() %></td>
                            <td><%= reservation.getMessage() %></td>
                            <td><%= reservation.getDate() %></td>
                            <td><%= reservation.getTime() %></td>
                            <td><%= reservation.getNumberOfPeople() %></td>
                            <td><%= reservation.getStatus() %></td>
                            <td><%= user != null ? user.getUsername() : "N/A" %></td>
                            <td><%= user != null ? user.getEmail() : "N/A" %></td>
                            <td><%= user != null ? user.getPhone() : "N/A" %></td>
                            <td class="btn-actions">
                            	
                                <a href="reservations?action=edit&id=<%= reservation.getReservationId() %>" class="btn btn-warning btn-sm">Edit</a>
                                <a href="reservations?action=delete&id=<%= reservation.getReservationId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this reservation?')">Delete</a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        <% } %>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
