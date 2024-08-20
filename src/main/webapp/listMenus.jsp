<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu List</title>
</head>
<body>
    <h2>Menu List</h2>
    <a href="menu?action=add">Add New Menu Item</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="menu" items="${menus}">
                <tr>
                    <td>${menu.productID}</td>
                    <td>${menu.category}</td>
                    <td>${menu.productName}</td>
                    <td>${menu.description}</td>
                    <td>${menu.price}</td>
                    <td><img src="${menu.image}" alt="${menu.productName}" width="100"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
