<%--
  Created by IntelliJ IDEA.
  User: sys4
  Date: 24/05/18
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista</title>
</head>
<body>
    <table>
        <tr>
            <td>Titulo</td>
            <td>Descricao</td>
            <td>Páginas</td>
            <c:forEach items="${tipos}" var="tipo">
                <td>${tipo}</td>
            </c:forEach>
        </tr>
        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td>${produto.titulo}</td>
                <td>${produto.descricao}</td>
                <td>${produto.paginas}</td>
                <%--<c:forEach items="${tipos}" var="tipo" varStatus="status">--%>
                    <%--<td>${produto.precos[tipo.numero].valor}</td>--%>
                <%--</c:forEach>--%>
            </tr>
        </c:forEach>
    </table>
</body>
</html>