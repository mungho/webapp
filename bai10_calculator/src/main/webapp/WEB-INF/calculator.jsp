<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/08/2025
  Time: 8:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <h1>Simple Calculator</h1>
    <table>
        <tr>
            <td><p>First Operand</p></td>
            <td><input name="firstOperand" type="number"></td>
        </tr>
        <tr>
            <td><p>Operator</p></td>
            <td>
                <select name="operator">
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><p>Second Operand</p></td>
            <td><input name="secondOperand" type="number"></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Calculator</button></td>
        </tr>
    </table>
</form>
</body>
</html>
