$(document).ready(function (){
})

function createLogin(){
    $.ajax({
        url: "/api/quest/add-user",
        method: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            email: $("#email").val(),
            password: $("#password").val(),
            firstName: $("#first_name").val(),
            surname: $("#sur_name").val(),
            city: $("#city").val(),
            phoneNumber: $("#mobile_number").val()
        })
    });
}