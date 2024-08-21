<meta http-equiv="refresh" content="2">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Dashboard</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">Menu Dashboard</h1>


        <c:if test="${not empty message}">
            <div class="alert alert-info">
                <p>${message}</p>
            </div>
        </c:if>





        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Product ID</th>
                    <th>Category</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
              
                <c:forEach var="menu" items="${menu}">
                    <tr>
                        <td>${menu.productID}</td>
                        <td>${menu.category}</td>
                        <td>${menu.productName}</td>
                        <td>${menu.description}</td>
                        <td>${menu.price}</td>
                        <td>
                            <img src="${menu.image}" alt="${menu.productName}" class="img-thumbnail" width="100"/>
                        </td>
                        <td>
                          <a href="menu?action=view&id=${menu.productID}" class="btn btn-primary btn-sm">View</a>
<a href="menu?action=edit&id=${menu.productID}" class="btn btn-warning btn-sm">Edit</a>
<a href="menu?action=delete&id=${menu.productID}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a>
                        </td>
                    </tr>
                    
                </c:forEach>
            </tbody>
        </table>

        <a href="menu?action=add" class="">Add New Menu Item</a>
    </div>

    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
