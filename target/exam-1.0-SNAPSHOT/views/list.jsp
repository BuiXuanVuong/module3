<%--
  Created by IntelliJ IDEA.
  User: Media
  Date: 10/11/2020
  Time: 10:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<center>
    <h1>Home</h1>
    <h2>
        <a href="/home?action=create">Add New </a>
    </h2>
</center>

<center>
    <form method="post" action="/home?action=search">
        <input type="text" name="name" id="name" >
        <input type="submit" value="Search">
    </form>

</center>

<div align="center">
    <table border="1">
        <caption><h2>List Category</h2></caption>
        <tr>
            <th>Category</th>
        </tr>
        <c:forEach items="${listCategory}" var="item1">
            <tr>
                <td><c:out value="${item1.code}"></c:out></td>
            </tr>
        </c:forEach>

    </table>

    <table border="1">
        <caption><h2>List</h2></caption>
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Action</th>
        </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td><c:out value="${item.id}"></c:out></td>
                <td><c:out value="${item.productName}"></c:out></td>


<%--                <td><c:out value="${item.categoryId}"></c:out></td>--%>

                <c:forEach items="${listCategory}" var="category">
                    <c:if test="${item.categoryId == category.id}">
                        <td><c:out value="${category.code}"></c:out></td>
                    </c:if>
                </c:forEach>


                <td><c:out value="${item.price}"></c:out></td>
                <td><c:out value="${item.quantity}"></c:out></td>
                <td><c:out value="${item.color}"></c:out></td>
                <td>
                    <a href="/home?action=edit&id=${item.id}">Edit</a>
                    <a href="/home?action=delete&id=${item.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
