<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            color: #343a40;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 100px;
            text-align: center;
        }
        .btn-lg {
            margin: 15px;
            padding: 15px 30px;
        }
        h2 {
            margin-bottom: 30px;
            font-size: 2.5rem;
            color: #007bff;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-primary:focus, .btn-primary.focus {
            box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, 0.5);
        }
        .card {
            margin-top: 20px;
            border: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .card-body {
            padding: 2rem;
        }
        .card-title {
            font-size: 1.5rem;
            margin-bottom: 1rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h2 class="card-title">Welcome to the Dashboard!</h2>
                
                <!-- Buttons for navigating to the menu pages -->
                <a href="menu?action=list" class="btn btn-primary btn-lg">View Menu</a>
                <a href="menu?action=add" class="btn btn-primary btn-lg">Add Menu</a>
                
                <br>
                
                <a href="user?action=list" class="btn btn-primary btn-lg">View Users</a>
                <a href="user?action=add" class="btn btn-primary btn-lg">Add User</a>
                
                <br>
                
                <a href="facility?action=list" class="btn btn-primary btn-lg">View Facilities</a>
                <a href="facility?action=add" class="btn btn-primary btn-lg">Add Facilities</a>
                
                <br>
                
                <a href="offer?action=list" class="btn btn-primary btn-lg">View offer</a>
                <a href="offer?action=add" class="btn btn-primary btn-lg">Add offer</a>
                
                 <br>
                
                <a href="reservations?action=list" class="btn btn-primary btn-lg">View offer</a>
                <a href="reservations?action=new" class="btn btn-primary btn-lg">Add offer</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
