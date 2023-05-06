$(document).ready(function () {
  fetchNews();
});

function fetchNews() {
  $.ajax({
    url: "/api/get-news",
    type: "get",
    dataType: "json",
    contentType: "application/json",
  })
    .done(function (data) {
      findResults(data.newses);
    })
    .fail(function (jqxhr, textStatus, errorThrown) {
      displayErrorInformation(jqxhr.responseText);
    });
}
function findResults(newses) {
  newses.forEach(function (news) {
    fillRow(news);
  });
}
function fillRow(news) {
  let date = new Intl.DateTimeFormat("en-US", {
    weekday: "short",
    month: "long",
    year: "numeric",
  }).format(new Date(news.createDate));
  $("#informations_wrapper").append(
    '<div class="information_basis">' +
      '<div class="information">' +
      '<div class="information_title">' +
      `<h3>${news.title}</h3>` +
      "</div>" +
      '<div class="information_date">' +
      "<p>Created:&nbsp;</p>" +
      `<span>${date}</span>` +
      "</div>" +
      '<div class="information_content">' +
      news.content +
      "</div>" +
      "</div>" +
      "</div>"
  );
}
