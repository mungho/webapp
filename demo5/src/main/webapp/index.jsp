<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/08/2025
  Time: 8:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discount Calculator</title>
</head>
<body>
<h1>Discount Caculator</h1>
<form action="${pageContext.request.contextPath}/discount-calculator" method="post">
    <input type="text" name="productDescription" placeholder="Product Description">
    <input type="number" name="listPrice" placeholder="List Price">
    <input type="number" name="discountPercent" placeholder="Discount Percent">
    <button type="submit">Calculate</button>
</form>
</body>
</html>
