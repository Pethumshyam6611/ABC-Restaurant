<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="my-4">Reservation List</h2>
        <a href="reservations?action=new" class="btn btn-primary mb-3">Add New Reservation</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>User ID</th>
                    <th>Service Type</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Number of People</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="reservation" items="${reservationList}">
                    <tr>
                        <td>${reservation.reservationId}</td>
                        <td>${reservation.userId}</td>
                        <td>${reservation.serviceType}</td>
                        <td>${reservation.date}</td>
                        <td>${reservation.time}</td>
                        <td>${reservation.numberOfPeople}</td>
                        <td>${reservation.status}</td>
                        <td>
                            <a href="reservations?action=edit&id=${reservation.reservationId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="reservations?action=delete&id=${reservation.reservationId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this reservation?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
