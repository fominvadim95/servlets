$(document).ready(function () {

    var id;
    $("a.delete").click(function () {
        id = $(this).attr("id");
    });

    var frm = $('#deletion');

    frm.submit(function (event) {
        event.preventDefault();
        $.ajax({
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: {"id": id},
            success: function () {
                $("#confirm").modal('hide');
                $('#' + id).parent().parent().hide();
            }
        });
    });


    $("a.edit").click(function () {
        var id = $(this).attr("id");
        window.location = "/players?option=showEditingPage&id=" + id;
    });

    $("#add").submit(function (event) {
        event.preventDefault();
        var name = $("#name").val();
        var country = $("#country").val();
        var age = $("#age").val();
        var cost = $("#cost").val();
        var position = $("#position").val();
        var player = {"name": name, "country": country, "age": age, "cost": cost, "position": position};

        $.ajax({
            url: "/players?option=add", data: player, async: true,
            success: function (result) {
                window.location = "/players?option=getAll"
            }, error: function () {
                $("#error").text("Required fields not filled");
                $("#error").css("color", "red");
            }
        });
    });

    $("#edit").submit(function (event) {
        event.preventDefault();
        var id = $("#id").val();
        var name = $("#name").val();
        var country = $("#country").val();
        var age = $("#age").val();
        var cost = $("#cost").val();
        var position = $("#position").val();
        var player = {"id": id, "name": name, "country": country, "age": age, "cost": cost, "position": position};

        $.ajax({
            url: "/players?option=edit", data: player, async: true,
            success: function (result) {
                window.location = "/players?option=getAll"
            }, error: function () {
                $("#error").text("Required fields not filled");
                $("#error").css("color", "red");
            }
        });
    });
});
