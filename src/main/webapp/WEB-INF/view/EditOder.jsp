<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Edit Order</h2>
        <form action="oders?action=update" method="post">
            <input type="hidden" name="id" value="${oder.oderId}">

            <div class="form-group">
                <label for="productId">Product ID</label>
                <input type="number" class="form-control" id="productId" name="productId" value="${oder.productId}" required>
            </div>

            <div class="form-group">
                <label for="userIdp">User ID</label>
                <input type="number" class="form-control" id="userIdp" name="userIdp" value="${oder.userIdp}" required>
            </div>

            <div class="form-group">
                <label for="type">Type</label>
                <input type="text" class="form-control" id="type" name="type" value="${oder.type}" required>
            </div>

            <div class="form-group">
                <label for="totalPrice">Total Price</label>
                <input type="number" step="0.01" class="form-control" id="totalPrice" name="totalPrice" value="${oder.totalPrice}" required>
            </div>

            <div class="form-group">
                <label for="status">Status</label>
                <select class="form-control" id="status" name="status" required>
                    <option value="Pending" ${oder.status == 'Pending' ? 'selected' : ''}>Pending</option>
                    <option value="Completed" ${oder.status == 'Completed' ? 'selected' : ''}>Completed</option>
                    <option value="Cancelled" ${oder.status == 'Cancelled' ? 'selected' : ''}>Cancelled</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Update Order</button>
            <a href="oders?action=list" class="btn btn-secondary btn-block">Cancel</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
