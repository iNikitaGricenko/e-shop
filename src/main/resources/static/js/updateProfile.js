$(document).ready(function() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8088/api/user',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            $("#ProfileImage").attr("src", "/"+data.photo);
            $("#ProfileLogin").attr("value", data.login);
            $("#FirstName").attr("value", data.firstName);
            $("#SecondName").attr("value", data.secondName);
            $("#MiddleName").attr("value", data.middleName);
            $("#MainPhone").attr("value", data.phone);
            $("#City").attr("value", data.city);
            $("#RegisterDate").type = 'date';
            $("#RegisterDate").attr("value", data.registerDate);
            $("#RegisterDate").type = 'text';
        }
    })
})