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
    <title>Form</title>
</head>
<body>
    <form action="/produtos" method="post">
        <div>
            <label for="titulo">Titulo</label>
            <input id="titulo" type="text" name="titulo">
        </div>
        <div>
            <label for="descricao">Descrição</label>
            <textarea id="descricao" name="descricao" rows="10" cols="20"></textarea>
        </div>
        <div>
            <label for="paginas">Paginas</label>
            <input type="text" id="paginas" name="paginas">
        </div>
        <h3>Preços:</h3>
        <c:forEach items="${tipos}" var="tipo" varStatus="status">
            <div>
                <label for="${tipo}">${tipo}</label>
                <input type="text" id="${tipo}" name="precos[${status.index}].valor">
                <input type="hidden" name="precos[${status.index}].tipo" value="${tipo}">
            </div>
        </c:forEach>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
