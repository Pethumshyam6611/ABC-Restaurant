<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Payment</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Add New Payment</h2>
    <form action="payments" method="post">
        <input type="hidden" name="action" value="new"/>

        <div class="form-group">
            <label for="userId">Oder ID</label>
            <input type="number" class="form-control" id="oderId" name="oderId" required>
        </div>

        <div class="form-group">
            <label for="amount">Amount</label>
            <input type="number" step="0.01" class="form-control" id="amount" name="amount" required>
        </div>

        <div class="form-group">
            <label for="paymentDate">Payment Date</label>
            <input type="date" class="form-control" id="paymentDateTime" name="paymentDateTime" required>
        </div>

        <div class="form-group">
            <label for="paymentStatus">Method</label>
            <select class="form-control" id="method" name="method" required>
                <option value="Card Payment">Card Payment</option>
                <option value="Cash on Dilivery">Cash On Dilivery</option>
                <option value="Failed">Failed</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Add Payment</button>
        <a href="payments?action=list" class="btn btn-secondary btn-block">Back to List</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
