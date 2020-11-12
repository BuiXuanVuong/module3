<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Media
  Date: 10/11/2020
  Time: 10:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<center>
    <h2><a href="/home?action=listAll">List All Users</a></h2>
</center>
<div align="center">
    <form action="/home?action=create" method="post">
        <table border="1">
            <caption>
                <h2>Add New</h2>
            </caption>
            <tr>
                <th>ProductName</th>
                <td>
                    <input type="text" name="productName" id="productName">
                </td>
            </tr>
            <tr>
                <th>CategoryId</th>
                <td>
                    <input type="text" name="categoryId" id="categoryId">
                </td>
            </tr>
            <tr>
                <th>Price</th>
                <td>
                    <input type="text" name="price" id="price">
                </td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td>
                    <input type="text" name="quantity" id="quantity">
                </td>
            </tr>
            <tr>
                <th>Color</th>
                <td>
                    <input type="text" name="color" id="color">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
