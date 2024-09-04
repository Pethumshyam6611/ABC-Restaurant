<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Facility Dashboard</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">Facility Dashboard</h1>

        <c:if test="${not empty message}">
            <div class="alert alert-info">
                <p>${message}</p>
            </div>
        </c:if>

  <a href="facility?action=add" class="btn btn-primary btn-lg">Add New Facility</a>
  <br>
  <br>
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Facility Image</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="facility" items="${facilities}">
                    <tr>
                        <td>${facility.facilityId}</td>
                        <td>${facility.facilityName}</td>
                        <td>${facility.description}</td>
                        <td><img src="${facility.facilityImg}" alt="${facility.facilityName}" class="img-thumbnail mt-2" width="100"/></td>
                        <td>
                    
                            <a href="facility?action=edit&id=${facility.facilityId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="facility?action=delete&id=${facility.facilityId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this facility?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

      
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
