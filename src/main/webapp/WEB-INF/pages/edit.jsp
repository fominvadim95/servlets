<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editing / Addition</title>
    <%@include file="meta.jsp"%>
</head>
<body>
<div class="text-center">
    <h3>Editing / Addition</h3>
    <h5 id="error"></h5>
</div>
<br>
<form id="edit" action="/players?option=edit" method="POST" role="form">
    <input type="hidden" name="id" id="id" value="${player.id}"/>
    <div class="form-group">
        <input type="text" class="form-control" name="name" id="name" value="${player.name}">
    </div>
    <div class="form-group">
        <input type="text" class="form-control" name="country" id="country" value="${player.country}">
    </div>
    <div class="form-group">
        <input type="number" min="18" max="44" step="1" class="form-control" name="age" id="age" value="${player.age}">
    </div>
    <div class="form-group">
        <input type="number" min="10" max="500" step="10" class="form-control" name="cost" id="cost"
               value="${player.cost}">
    </div>
    <div class="form-group">
        <select id="position" class="form-control" name="position">
            <c:forEach var="position" items="${positions}">
                <c:choose>
                    <c:when test="${position eq player.position}">
                        <option selected>${position}</option>
                    </c:when>
                    <c:otherwise>
                        <option>${position}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <button id="save" type="submit" class="btn btn-default">
        <span class="glyphicon glyphicon-floppy-disk"></span>
        Save
    </button>
</form>

<%@include file="footer.jsp"%>

</body>
</html>
