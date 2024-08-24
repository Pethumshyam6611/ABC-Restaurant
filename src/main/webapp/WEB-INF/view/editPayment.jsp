<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Payment</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Edit Payment</h2>
        <form action="payments?action=update" method="post">
            <input type="hidden" name="id" value="${payment.paymentId}">

            <div class="form-group">
                <label for="userId">Oder ID</label>
                <input type="number" class="form-control" id="oderId" name="oderId" value="${payment.oderId}" required>
            </div>

            <div class="form-group">
                <label for="paymentDate">Payment Date</label>
                <input type="date" class="form-control" id="paymentDateTime" name="paymentDateTime" value="${payment.paymentDateTime}" required>
            </div>

            <div class="form-group">
                <label for="paymentStatus">Status</label>
                <select class="form-control" id="method" name="method" required>
                    <option value="Card Payment" ${payment.method == 'Pending' ? 'selected' : ''}>Card Payment</option>
                    <option value="Cash on Dilivery" ${payment.method == 'Completed' ? 'selected' : ''}>Cash on Dilivery</option>
                    <option value="Failed" ${payment.method == 'Failed' ? 'selected' : ''}>Failed</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Update Payment</button>
            <a href="payments?action=list" class="btn btn-secondary btn-block">Cancel</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
