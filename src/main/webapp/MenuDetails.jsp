<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="abc.restaurant.Model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Item Details</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Menu Item Details</h1>
    <%
        Menu menu = (Menu) request.getAttribute("menu");
    %>
    <div class="card">
        <% if (menu.getImage() != null && !menu.getImage().isEmpty()) { %>
            <img src="<%= menu.getImage() %>" class="card-img-top" alt="<%= menu.getProductName() %>">
        <% } %>
        <div class="card-body">
            <h5 class="card-title"><%= menu.getProductName() %></h5>
            <p class="card-text"><strong>Category:</strong> <%= menu.getCategory() %></p>
            <p class="card-text"><strong>Description:</strong> <%= menu.getDescription() %></p>
            <p class="card-text"><strong>Price:</strong> $<%= menu.getPrice() %></p>
            <a href="update-menu.jsp?productId=<%= menu.getProductID() %>" class="btn btn-warning">Edit</a>
            <a href="menuController?type=delete&productId=<%= menu.getProductID() %>" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this item?')">Delete</a>
            <a href="MenuDashboard.jsp" class="btn btn-secondary">Back to Menu Dashboard</a>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
