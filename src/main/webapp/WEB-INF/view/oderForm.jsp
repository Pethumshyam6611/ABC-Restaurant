<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Order</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="my-4">Add New Order</h1>
    <form action="oders" method="post">
        <input type="hidden" name="action" value="new"/>
        <div class="form-group">
            <label for="productId">Product ID</label>
            <input type="number" class="form-control" id="productId" name="productId" required>
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
        <button type="submit" class="btn btn-primary">Add Order</button>
        <a href="oders?action=list" class="btn btn-secondary">Back to List</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
