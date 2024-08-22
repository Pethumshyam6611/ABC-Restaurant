<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Offer Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Offer Dashboard</h1>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">
            <p>${errorMessage}</p>
        </div>
    </c:if>

    <c:if test="${not empty successMessage}">
        <div class="alert alert-success">
            <p>${successMessage}</p>
        </div>
    </c:if>

    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Offer ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Discount Percentage</th>
                <th>Valid From</th>
                <th>Valid To</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="offer" items="${offers}">
                <tr>
                    <td>${offer.offerId}</td>
                    <td>${offer.title}</td>
                    <td>${offer.description}</td>
                    <td>${offer.discountPercentage}</td>
                    <td>${offer.validFrom}</td>
                    <td>${offer.validTo}</td>
                    <td>
                        <img src="${offer.offerImg}" alt="${offer.title}" class="img-thumbnail" width="100"/>
                    </td>
                    <td>
                        <a href="offer?action=edit&id=${offer.offerId}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="offer?action=delete&id=${offer.offerId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this offer?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="offer?action=add" class="btn btn-primary">Add New Offer</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
