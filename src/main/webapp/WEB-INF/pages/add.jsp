<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editing / Addition</title>
    <%@include file="meta.jsp" %>
</head>
<body>
<div class="text-center">
    <h3>Editing / Addition</h3>
    <h5 id="error"></h5>
</div>
<br>
<form id="add" action="/players?option=add" method="POST" role="form">
    <div class="form-group">
        <input type="text" class="form-control" name="name" id="name" placeholder="Name">
    </div>
    <div class="form-group">
        <input type="text" class="form-control" name="country" id="country" placeholder="Country">
    </div>
    <div class="form-group">
        <input type="number" min="18" max="44" step="1" class="form-control" name="age" id="age" placeholder="Age">
    </div>
    <div class="form-group">
        <input type="number" min="10" max="500" step="10" class="form-control" name="cost" id="cost" placeholder="Cost">
    </div>
    <div class="form-group">
        <select id="position" class="form-control" name="position">
            <option>CB</option>
            <option>FB</option>
            <option>CM</option>
            <option>FM</option>
            <option>F</option>
            <option>G</option>
        </select>
    </div>
    <button id="save" type="submit" class="btn btn-default">
        <span class="glyphicon glyphicon-floppy-disk"></span>
        Save
    </button>
</form>

<%@include file="footer.jsp" %>

</body>
</html>
