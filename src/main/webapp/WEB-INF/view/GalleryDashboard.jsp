<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gallery Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Gallery Dashboard</h2>
        <a href="gallery?action=add" class="btn btn-primary mb-3">Add New Image</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Image</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="gallery" items="${galleries}">
                    <tr>
                        <td>${gallery.galleryId}</td>
                        <td><img src="${gallery.galleryImg}" alt="Gallery Image" width="100"></td>
                        <td>
                            <a href="gallery?action=delete&id=${gallery.galleryId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this image?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
