import { createToast } from "./shared.js";

$(document).ready(function () {
  const form = document.getElementById("register");
  form.addEventListener("submit", function (e) {
    e.preventDefault();
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
        phoneNumber: $("#mobile_number").val(),
      }),
      success: function ({ message }) {
        createToast(message);
        console.log(message);
      },
      error: function ({ responseJSON: { message } }, textStatus, errorThrown) {
        createToast(message);
        console.log(message);
      },
    });
  });
});
