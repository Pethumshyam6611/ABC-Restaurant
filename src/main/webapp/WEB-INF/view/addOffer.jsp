<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Offer</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Add New Offer</h2>

    <form action="offer" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="add"/>
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
        </div>
        <div class="form-group">
            <label for="discountPercentage">Discount Percentage</label>
            <input type="text" class="form-control" id="discountPercentage" name="discountPercentage" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="validFrom">Valid From</label>
            <input type="text" class="form-control" id="validFrom" name="validFrom" required>
        </div>
        <div class="form-group">
            <label for="validTo">Valid To</label>
            <input type="text" class="form-control" id="validTo" name="validTo" required>
        </div>
        <div class="form-group">
            <label for="image">Image</label>
            <input type="file" class="form-control" id="image" name="image" required>
        </div>
        <button type="submit" class="btn btn-primary">Add Offer</button>
    </form>

    <a href="offer?action=list" class="btn btn-secondary mt-3">Back to Offer List</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
