<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-5">Order List</h2>
    <a href="oders?action=new" class="btn btn-primary mb-3">Add New Order</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Product ID</th>
                <th>User ID</th>
                <th>Type</th>
                <th>Total Price</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="oder" items="${oderList}">
                <tr>
                    <td><c:out value="${oder.oderId}"/></td>
                    <td><c:out value="${oder.productId}"/></td>
                    <td><c:out value="${oder.userIdp}"/></td>
                    <td><c:out value="${oder.type}"/></td>
                    <td><c:out value="${oder.totalPrice}"/></td>
                    <td><c:out value="${oder.status}"/></td>
                    <td>
                        <a href="oders?action=edit&id=<c:out value="${oder.oderId}"/>"
                           class="btn btn-warning btn-sm">Edit</a>
                        <a href="oders?action=delete&id=<c:out value="${oder.oderId}"/>"
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this order?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
