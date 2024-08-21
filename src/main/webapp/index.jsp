<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            text-align: center;
            margin-top: 50px;
        }
        .btn-lg {
            margin: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="mb-4">Hello World!</h2>

        <!-- Buttons for navigating to the menu pages -->
        <a href="menu?action=list" class="btn btn-primary btn-lg">View Menu</a>
        <a href="menu?action=add" class="btn btn-primary btn-lg">Add Menu</a>
        
        
        <br>
        
        <a href="user?action=list" class="btn btn-primary btn-lg">View Users</a>
        <a href="user?action=add" class="btn btn-primary btn-lg">Add User</a>
  
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
