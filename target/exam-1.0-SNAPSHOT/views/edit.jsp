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
    <title>Edit</title>
</head>
<body>
<center>
    <h2>Edit</h2>
    <form method="post" action="/home?action=edit">
        <table border="1">
            <caption>
               <h2>
                   Edit
               </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}'/>" />
            </c:if>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="productName" value="<c:out value='${product.productName}'/>"/>
                </td>
            </tr>



            <tr>
                <th>CategoryId</th>
                <td>
                    <input type="text" name="categoryId" value="<c:out value='${product.categoryId}'></c:out>">
                </td>
            </tr>



            <tr>
                <th>Price</th>
                <td>
                    <input type="text" name="price" value="<c:out value='${product.price}'></c:out>">
                </td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td>
                    <input type="text" name="quantity" value="<c:out value='${product.quantity}'></c:out>">
                </td>
            </tr>
            <tr>
                <th>Color</th>
                <td>
                    <input type="text" name="color" value="<c:out value='${product.color}'></c:out>">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</center>


</body>
</html>
