<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Payment</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .hidden-field {
            display: none;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Add New Payment</h2>
    <form action="payments" method="post" onsubmit="setCurrentDateTime()">
        <input type="hidden" name="action" value="new"/>

        <div class="form-group">
            <label for="oderId">Order ID</label>
            <input type="number" class="form-control" id="oderId" name="oderId" required>
        </div>

        <div class="form-group">
            <label for="amount">Amount</label>
            <input type="number" step="0.01" class="form-control" id="amount" name="amount" required>
        </div>

        <!-- Hidden field for Payment Date and Time -->
        <div class="form-group hidden-field">
            <label for="paymentDateTime">Payment Date and Time</label>
            <input type="datetime-local" class="form-control" id="paymentDateTime" name="paymentDateTime" readonly>
        </div>

        <div class="form-group">
            <label for="method">Method</label>
            <select class="form-control" id="method" name="method" required>
                <option value="Card Payment">Card Payment</option>
                <option value="Cash on Delivery">Cash on Delivery</option>
                <option value="Failed">Failed</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Add Payment</button>
        <a href="payments?action=list" class="btn btn-secondary btn-block">Back to List</a>
    </form>
</div>

<script>
    // Function to set the current date and time to the datetime-local input field just before form submission
    function setCurrentDateTime() {
        var now = new Date();
        var offset = now.getTimezoneOffset();
        now = new Date(now.getTime() - (offset * 60 * 1000));
        var localDatetime = now.toISOString().slice(0, 16);
        document.getElementById('paymentDateTime').value = localDatetime;
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
