<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Offer</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Edit Offer</h2>

    <form action="offer" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${offer.offerId}">

        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title" value="${offer.title}" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3" required>${offer.description}</textarea>
        </div>
        <div class="form-group">
            <label for="discountPercentage">Discount Percentage</label>
            <input type="number" class="form-control" id="discountPercentage" name="discountPercentage" step="0.01" value="${offer.discountPercentage}" required>
        </div>
        <div class="form-group">
            <label for="validFrom">Valid From</label>
            <input type="date" class="form-control" id="validFrom" name="validFrom" value="${offer.validFrom}" required>
        </div>
        <div class="form-group">
            <label for="validTo">Valid To</label>
            <input type="date" class="form-control" id="validTo" name="validTo" value="${offer.validTo}" required>
        </div>
        <div class="form-group">
            <label for="image">Image</label>
            <input type="file" class="form-control" id="image" name="image">
            <img src="${offer.offerImg}" alt="${offer.title}" class="img-thumbnail mt-2" width="100"/>
        </div>
        <button type="submit" class="btn btn-primary">Update Offer</button>
        <a href="offer?action=list" class="btn btn-secondary">Cancel</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
