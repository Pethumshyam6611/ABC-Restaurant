<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Reservation</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="my-4">Edit Reservation</h2>
        <form action="reservations?action=update" method="post">
            <input type="hidden" name="id" value="${reservation.reservationId}">
            <div class="form-group">
                <label for="userId">User ID</label>
                <input type="text" class="form-control" id="userId" name="userId" value="${reservation.userId}" required>
            </div>
            <div class="form-group">
                <label for="serviceType">Service Type</label>
                <input type="text" class="form-control" id="serviceType" name="serviceType" value="${reservation.serviceType}" required>
            </div>
            <div class="form-group">
                <label for="date">Date</label>
                <input type="date" class="form-control" id="date" name="date" value="${reservation.date}" required>
            </div>
            <div class="form-group">
                <label for="time">Time</label>
                <input type="time" class="form-control" id="time" name="time" value="${reservation.time}" required>
            </div>
            <div class="form-group">
                <label for="numberOfPeople">Number of People</label>
                <input type="number" class="form-control" id="numberOfPeople" name="numberOfPeople" value="${reservation.numberOfPeople}" required>
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <input type="text" class="form-control" id="status" name="status" value="${reservation.status}" required>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="reservations?action=list" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
