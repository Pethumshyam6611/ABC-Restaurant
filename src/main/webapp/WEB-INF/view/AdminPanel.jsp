<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #d1f56d; /* Yellow-green background */
            color: #333; /* Dark text for contrast */
            font-family: 'Arial', sans-serif;
        }
        .container {
            margin-top: 50px;
        }
        h1 {
            margin-bottom: 30px;
            font-size: 2.5rem;
            color: #343a40; /* Dark grey color for the header */
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        .card-deck {
            margin-top: 20px;
        }
        .card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            margin: 15px;
            color: #343a40; /* Dark grey text */
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.3);
        }
        .card-body {
            padding: 2rem;
            text-align: center;
        }
        .card-title {
            font-size: 1.5rem;
            margin-bottom: 1rem;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        a.text-decoration-none {
            text-decoration: none;
        }
        a.text-decoration-none:hover {
            text-decoration: none;
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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
    <a class="navbar-brand" href="#">Admin Panel</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="oder?action=downloadPdf" class="btn btn-primary mr-2">Download Annual Sales Report</a>
            </li>
            <li class="nav-item">
                <a href="reservations?action=generatePDF" class="btn btn-primary mr-2">Download Reservations Report</a>
            </li>
            <li class="nav-item">
                <a href="logout" class="btn btn-danger">Logout</a>
            </li>
        </ul>
    </div>
</nav>

    <div class="container">
        <h1>Admin Panel Dashboard</h1>
        <!-- First Row: 3 Cards -->
        <div class="row">
            <div class="col-md-4">
                <a href="menu?action=list" class="card text-decoration-none">
                    <div class="card-body">
                        <h2 class="card-title">Menu Manager</h2>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="user?action=list" class="card text-decoration-none">
                    <div class="card-body">
                        <h2 class="card-title">User Manager</h2>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="facility?action=list" class="card text-decoration-none">
                    <div class="card-body">
                        <h2 class="card-title">Facility Manager</h2>
                    </div>
                </a>
            </div>
        </div>

        <!-- Second Row: 3 Cards -->
        <div class="row">
            <div class="col-md-4">
                <a href="offer?action=list" class="card text-decoration-none">
                    <div class="card-body">
                        <h2 class="card-title">Offer Manager</h2>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="reservations?action=list" class="card text-decoration-none">
                    <div class="card-body">
                        <h2 class="card-title">Reservation Manager</h2>
                    </div>
                </a>
            </div>
             <div class="col-md-4">
                <a href="oder?action=list" class="card text-decoration-none">
                    <div class="card-body">
                        <h2 class="card-title">Order Manager</h2>
                    </div>
                </a>
            </div>
        </div>

        <!-- Third Row: 4 Cards -->
        <div class="row">
           
            <div class="col-md-4">
                <a href="payments?action=list" class="card text-decoration-none">
                    <div class="card-body">
                        <h2 class="card-title">Payment Manager</h2>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="gallery?action=list" class="card text-decoration-none">
                    <div class="card-body">
                        <h2 class="card-title">Gallery Manager</h2>
                    </div>
                </a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
