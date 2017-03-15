<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Players</title>
    <%@include file="meta.jsp" %>
</head>
<body>
<div class="container">
    <div class="text-center">
        <h3>Players</h3>
    </div>
    <br>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Country</th>
            <th>Age</th>
            <th>Cost</th>
            <th>Position</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="player" items="${players}">
            <tr>
                <td>${player.id}</td>
                <td>${player.name}</td>
                <td>${player.country}</td>
                <td>${player.age}</td>
                <td>${player.cost}</td>
                <td>${player.position}</td>
                <td><a class="edit" id="${player.id}" href="#">edit</a></td>
                <td><a class="delete" id="${player.id}" href="#" data-toggle="modal"
                       data-target="#confirm">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="row">
    <div class="col-md-4 col-md-offset-3">
        <form id="findForm" class="form-inline"  role="form">
            <div class="form-group">
                <input type="text" name="country" class="form-control" id="country" placeholder="country">
            </div>
            <button type="button" class="btn btn-default" id="find">
                <span class="glyphicon glyphicon-search"></span>
                Find
            </button>
        </form>
    </div>

    <div class="col-md-4">
        <button id="add" type="button" class="btn btn-default"
                onclick="window.location = '/players?option=showAddingPage'">
            <span class="glyphicon glyphicon-plus"></span>
            Add player
        </button>
    </div>
</div>


<!-- Modal window-->
<div class="modal fade" id="confirm" role="dialog">
    <div class="modal-dialog modal-md">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span>
                </button>
                <h4 class="modal-title">Confirmation</h4>
            </div>
            <div class="modal-body">
                <p>Do you indeed want to delete this player?</p>
            </div>
            <div class="modal-footer">
                <form action="/players?option=delete" method="POST"
                      id="deletion" role="form">
                    <button type="submit" class="btn btn-default">Yes</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                </form>
            </div>
        </div>

    </div>
</div>

<%@include file="footer.jsp" %>

<script>
    $("#find").click(function () {
        var country = $("#country").val();
        window.location = "/players?option=getByCountry&country=" + country;
    });
</script>
</body>
</html>
