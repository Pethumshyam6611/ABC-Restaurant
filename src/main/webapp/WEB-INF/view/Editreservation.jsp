<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Reservation</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="my-4">Edit Reservation</h1>
    <form action="reservations?action=update" method="post">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="${reservation.reservationId}"/>
        <div class="form-group">
            <label for="userId">User ID</label>
            <input type="number" class="form-control" id="userId" name="userId" value="${reservation.userId}" required>
        </div>
        <div class="form-group">
            <label for="serviceType">Message</label>
            <input type="text" class="form-control" id="message" name="message" value="${reservation.message}" required>
        </div>
        <div class="form-group">
            <label for="date">Date</label>
            <input type="text" class="form-control" id="date" name="date" value="${reservation.date}" required>
        </div>
        <div class="form-group">
            <label for="time">Time</label>
            <input type="text" class="form-control" id="time" name="time" value="${reservation.time}" required>
        </div>
        <div class="form-group">
            <label for="numberOfPeople">Number of People</label>
            <input type="number" class="form-control" id="numberOfPeople" name="numberOfPeople" value="${reservation.numberOfPeople}" required>
        </div>
        <div class="form-group">
            <label for="status">Status</label>
            <input type="text" class="form-control" id="status" name="status" value="${reservation.status}" required>
        </div>
        <button type="submit" class="btn btn-primary">Update Reservation</button>
        <a href="reservations?action=list" class="btn btn-secondary">Back to List</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
