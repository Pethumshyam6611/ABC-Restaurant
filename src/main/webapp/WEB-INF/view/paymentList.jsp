<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Payment List</h2>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>
        
                <a href="payments?action=new" class="btn btn-primary">Add New Payment</a>
         <br>
         <br>       
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Payment ID</th>
                    <th>Order ID</th>
                    <th>Payment Date & Time</th>
                    <th>Method</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="payment" items="${paymentList}">
                    <tr>
                        <td>${payment.paymentId}</td>
                        <td>${payment.oderId}</td>
                        <td>${payment.paymentDateTime}</td>
                        <td>${payment.method}</td>
                        <td>
                            <a href="payments?action=edit&id=${payment.paymentId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="payments?action=delete&id=${payment.paymentId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="index.jsp" class="btn btn-danger btn-lg">Go to Main Menu</a>
    </div>
</body>
</html>
