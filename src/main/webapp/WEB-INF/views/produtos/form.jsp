<%--
  Created by IntelliJ IDEA.
  User: sys4
  Date: 24/05/18
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%--<%@ taglib uri="http://www.springframework.org/tags/" prefix="s" %>--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
    <%--@elvariable id="produto" type="Produto"--%>
    <f:form action="${s:mvcUrl('PC#grava').build()}" method="post" commandName="produto">
        <div>
            <label for="titulo">Titulo</label>
            <input id="titulo" type="text" name="titulo">
            <f:errors path="titulo" />
        </div>
        <div>
            <label for="descricao">Descrição</label>
            <textarea id="descricao" name="descricao" rows="10" cols="20"></textarea>
            <f:errors path="descricao" />
        </div>
        <div>
            <label for="paginas">Paginas</label>
            <input type="number" id="paginas" name="paginas">
            <f:errors path="paginas" />
        </div>
        <div>
            <label for="data">Data de Lançamento</label>
            <input type="date" id="data" name="dataLancamento">
            <f:errors path="dataLancamento" />
        </div>
        <h3>Preços:</h3>
        <c:forEach items="${tipos}" var="tipo" varStatus="status">
            <div>
                <label for="${tipo}">${tipo}</label>
                <input type="text" id="${tipo}" name="precos[${tipo.numero}].valor">
                <input type="hidden" name="precos[${tipo.numero}].tipo" value="${tipo}">
            </div>
        </c:forEach>
        <button type="submit">Cadastrar</button>
    </f:form>
</body>
</html>
