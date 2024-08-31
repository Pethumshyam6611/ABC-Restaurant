<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">Our Menu</h1>

        <c:if test="${not empty message}">
            <div class="alert alert-info">
                <p>${message}</p>
            </div>
        </c:if>

        <div class="row">
            <c:forEach var="menu" items="${menu}">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="${menu.image}" class="card-img-top" alt="${menu.productName}">
                        <div class="card-body">
                            <h5 class="card-title">${menu.productName}</h5>
                            <p class="card-text">${menu.description}</p>
                            <p class="card-text"><strong>Price: </strong>${menu.price}</p>
                            <form action="cart?action=add" method="post">
                                <input type="hidden" name="productID" value="${menu.productID}">
                                <button type="submit" class="btn btn-primary btn-block">Add to Cart</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <a href="cart.jsp" class="btn btn-success btn-lg">View Cart</a>
        <a href="index.jsp" class="btn btn-danger btn-lg">Go to Main Menu</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
