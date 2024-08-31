<%@ page import="abc.restaurant.Model.Oder" %>
<%@ page import="abc.restaurant.Model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 30px;
        }
        .form-group {
            margin-bottom: 1rem;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-primary">Edit Order</h2>
        <% 
            Oder oder = (Oder) request.getAttribute("oder");
            if (oder == null) {
                out.println("<div class='alert alert-danger'>Order not found.</div>");
                return;
            }
        %>
      <form action="oder" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= oder.getOderId() %>">
    
    <div class="form-group">
        <label for="foodNamewithQT">Food Name with Quantity:</label>
        <input type="text" id="foodNamewithQT" name="foodNamewithQT" class="form-control" value="<%= oder.getFoodNamewithQT() %>" required>
    </div>
    
    <div class="form-group">
        <label for="userIdp">User ID:</label>
        <input type="number" id="userIdp" name="userIdp" class="form-control" value="<%= oder.getUserIdp() %>" required>
    </div>
    
    <div class="form-group">
        <label for="type">Type:</label>
        <input type="text" id="type" name="type" class="form-control" value="<%= oder.getType() %>" required>
    </div>
    
    <div class="form-group">
        <label for="totalPrice">Total Price:</label>
        <input type="number" id="totalPrice" name="totalPrice" class="form-control" step="0.01" value="<%= oder.getTotalPrice() %>" required>
    </div>
    
    <div class="form-group">
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" class="form-control" value="<%= oder.getStatus() %>" required>
    </div>
    
    <div class="form-group">
        <label for="datetime">Date & Time:</label>
        <input type="text" id="datetime" name="datetime" class="form-control" value="<%= oder.getDatetime() %>" required>
    </div>
    
    <button type="submit" class="btn btn-primary">Update Order</button>
    <a href="oder?action=list" class="btn btn-secondary">Cancel</a>
</form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
