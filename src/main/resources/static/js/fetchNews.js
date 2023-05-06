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
    '<div class="flex w-full basis-1/3">' +
      '<div class="relative flex flex-col w-[80%] my-[24px] mx-auto bg-[#eebb12] rounded-[0.8rem] p-[1.2rem] shadow-xl">' +
      '<div class="flex justify-between items-center">' +
      "<p class='select-none text-[1.2rem] font-[700] text-[#13131C]'>Created: </p>" +
      `<h3 class='select-none text-[1.6rem] font-[700] text-[#13131C]'>${news.title}</h3>` +
      "</div>" +
      '<div class="information_date">' +
      `<span class="select-none text-[1.2rem] font-[700] text-[#13131C]">${date}</span>` +
      "</div>" +
      '<div class="mt-[0.8rem] text-[1.4rem]">' +
      news.content +
      "</div>" +
      "</div>" +
      "</div>"
  );
}
