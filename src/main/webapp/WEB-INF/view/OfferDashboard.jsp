<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Offer Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Offer Dashboard</h2>
        <a href="offer?action=add" class="btn btn-primary mb-3">Add New Offer</a>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="offer" items="${offer}">
                    <tr>
                        <td>${offer.offerId}</td>
                        <td>${offer.title}</td>
                        <td>${offer.description}</td>
                        <td>${offer.price}</td>
                        <td><img src="${offer.offerImg}" alt="Offer Image" style="width: 100px; height: auto;"></td>
                        <td>
                            <a href="offer?action=edit&id=${offer.offerId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="offer?action=delete&id=${offer.offerId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this offer?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
