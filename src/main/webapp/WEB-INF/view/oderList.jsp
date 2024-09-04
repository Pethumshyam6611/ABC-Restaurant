<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="abc.restaurant.Model.Oder" %>
<%@ page import="abc.restaurant.Model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order List</title>
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
        .add-order-btn {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<!-- Fetch role from session -->
    <div class="container">
        <div class="row mb-4">
            <div class="col-md-12">
                <h2 class="text-primary">Order List</h2> 
                <a href="oder?action=new" class="btn btn-primary add-order-btn">Add New Order</a>
                
            </div>
        </div>
		 
        <%
            // Get the list of orders
            List<Oder> oderList = (List<Oder>) request.getAttribute("oderList");
            List<Oder> pendingOrders = new ArrayList<>();
            List<Oder> acceptedOrders = new ArrayList<>();

            // Separate orders based on their status
            if (oderList != null) {
                for (Oder oder : oderList) {
                    if ("pending".equalsIgnoreCase(oder.getStatus())) {
                        pendingOrders.add(oder);
                    } else if ("accepted".equalsIgnoreCase(oder.getStatus())) {
                        acceptedOrders.add(oder);
                    }
                }
            }
        %>

        <%-- Display Pending Orders --%>
        <h3>Pending Orders</h3>
        <% if (pendingOrders.isEmpty()) { %>
            <div class="alert alert-warning">No pending orders found.</div>
        <% } else { %>
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Food Name with Quantity</th>
                            <th>User ID</th>
                            <th>Type</th>
                            <th>Total Price</th>
                            <th>Status</th>
                            <th>Date & Time</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Oder oder : pendingOrders) { 
                            User user = oder.getUserDetails();
                        %>
                        <tr>
                            <td><%= oder.getOderId() %></td>
                            <td><%= oder.getFoodNamewithQT() %></td>
                            <td><%= oder.getUserIdp() %></td>
                            <td><%= oder.getType() %></td>
                            <td><%= oder.getTotalPrice() %></td>
                            <td><%= oder.getStatus() %></td>
                            <td><%= oder.getDatetime() %></td>
                            <td><%= user != null ? user.getUsername() : "N/A" %></td>
                            <td><%= user != null ? user.getEmail() : "N/A" %></td>
                            <td><%= user != null ? user.getPhone() : "N/A" %></td>
                            <td class="btn-actions">
                                <a href="oder?action=accept&id=<%= oder.getOderId() %>" class="btn btn-success btn-sm" onclick="return confirm('Are you sure you want to accept this order?')">Accept Order</a>
                                <a href="oder?action=edit&id=<%= oder.getOderId() %>" class="btn btn-warning btn-sm">Edit</a>
                                <a href="oder?action=delete&id=<%= oder.getOderId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        <% } %>

        <%-- Display Accepted Orders --%>
        <h3>Accepted Orders</h3>
        <% if (acceptedOrders.isEmpty()) { %>
            <div class="alert alert-warning">No accepted orders found.</div>
        <% } else { %>
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Food Name with Quantity</th>
                            <th>User ID</th>
                            <th>Type</th>
                            <th>Total Price</th>
                            <th>Status</th>
                            <th>Date & Time</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Oder oder : acceptedOrders) { 
                            User user = oder.getUserDetails();
                        %>
                        <tr>
                            <td><%= oder.getOderId() %></td>
                            <td><%= oder.getFoodNamewithQT() %></td>
                            <td><%= oder.getUserIdp() %></td>
                            <td><%= oder.getType() %></td>
                            <td><%= oder.getTotalPrice() %></td>
                            <td><%= oder.getStatus() %></td>
                            <td><%= oder.getDatetime() %></td>
                            <td><%= user != null ? user.getUsername() : "N/A" %></td>
                            <td><%= user != null ? user.getEmail() : "N/A" %></td>
                            <td><%= user != null ? user.getPhone() : "N/A" %></td>
                            <td class="btn-actions">
                                <a href="oder?action=edit&id=<%= oder.getOderId() %>" class="btn btn-warning btn-sm">Edit</a>
                                <a href="oder?action=delete&id=<%= oder.getOderId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
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
