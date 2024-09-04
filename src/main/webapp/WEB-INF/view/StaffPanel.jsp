<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Panel</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #d1f56d; /* Yellow-green background */
            color: #fff; /* White text */
            font-family: 'Arial', sans-serif;
        }
        .container {
            margin-top: 50px;
        }
        h1 {
            margin-bottom: 50px;
            font-size: 3rem;
            color: #fff; /* White color for the header */
        }
        .card-deck {
            margin-top: 20px;
        }
        .card {
            background-color: #fff; /* White background for cards */
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            margin: 15px;
            color: #343a40; /* Dark grey text */
        }
        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.2);
        }
        .card-body {
            padding: 1.5rem;
            text-align: center;
        }
        .card-title {
            font-size: 1.8rem;
            margin-bottom: 1rem;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        a.text-decoration-none {
            color: #343a40; /* Dark grey text for links */
            text-decoration: none;
        }
        a.text-decoration-none:hover {
            color: #d1f56d; /* Yellow-green hover effect */
        }
        .navbar {
            background-color: #343a40; /* Dark navbar */
            color: white;
        }
        .navbar-brand, .nav-link {
            color: white !important;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand" href="#">Staff Panel</a>
        <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a href="logout" class="btn btn-danger">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <h1>Staff Panel Dashboard</h1>

        <!-- Card Deck -->
        <div class="card-deck">
            <!-- Reservation Card -->
            <a href="reservations?action=list" class="card text-decoration-none col-md-4">
                <div class="card-body">
                    <h2 class="card-title">Reservation</h2>
                </div>
            </a>
            <!-- Order Card -->
            <a href="oder?action=list" class="card text-decoration-none col-md-4">
                <div class="card-body">
                    <h2 class="card-title">Order List</h2>
                </div>
            </a>
            <!-- Payment Card -->
            <a href="payments?action=list" class="card text-decoration-none col-md-4">
                <div class="card-body">
                    <h2 class="card-title">Payment</h2>
                </div>
            </a>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
