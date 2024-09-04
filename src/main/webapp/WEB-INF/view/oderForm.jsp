<%@ page import="abc.restaurant.Model.Oder" %>
<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 50px;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 0.5rem;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            margin-bottom: 20px;
            color: #007bff;
        }
        .form-control {
            border-radius: 0.25rem;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-secondary {
            background-color: #6c757d;
            border: none;
        }
        .btn-secondary:hover {
            background-color: #5a6268;
        }
        .btn {
            border-radius: 0.25rem;
        }
        .form-group label {
            font-weight: bold;
        }
        .form-group input {
            border-radius: 0.25rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Order Form</h2>
        <form action="oder" method="post">
        <input type="hidden" name="source" value="addForm">
            <input type="hidden" name="action" value="new">
            <div class="form-group">
                <label for="foodNamewithQT">Food Name with Quantity</label>
                <input type="text" class="form-control" id="foodNamewithQT" name="foodNamewithQT" required>
            </div>
            <div class="form-group">
                <label for="userIdp">User ID</label>
                <input type="number" class="form-control" id="userIdp" name="userIdp" required>
            </div>
            <div class="form-group">
                <label for="type">Type</label>
                <input type="text" class="form-control" id="type" name="type" required>
            </div>
            <div class="form-group">
                <label for="totalPrice">Total Price</label>
                <input type="number" step="0.01" class="form-control" id="totalPrice" name="totalPrice" required>
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <input type="text" class="form-control" id="status" name="status" required>
            </div>
            <div class="form-group">
                <label for="datetime">Date & Time</label>
                <input type="datetime-local" class="form-control" id="datetime" name="datetime" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="oders?action=list" class="btn btn-secondary">Back to List</a>
            </div>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
