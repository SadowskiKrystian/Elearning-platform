$(document).ready(function () {
    fetchNews();
});

function fetchNews(){
    $.ajax({
        url: "/api/get-news",
        type: "get",
        dataType: "json",
        contentType: "application/json"
    })
        .done(function (data) {
          findResults(data.newses);
        })
        .fail(function(jqxhr, textStatus, errorThrown){
            displayErrorInformation(jqxhr.responseText);
        });
}
function findResults(newses){
    newses.forEach(function (news){
        fillRow(news);
    });
}
function fillRow(news){
    $('#informations_wrapper').append(
        '<div class="information">' +
            '<div class="information_title">' + news.title +
            '</div>' +
            '<div class="information_content">' + news.content +
            '</div>' +
            '<div class="information_date">' + news.createDate +
            '</div>' +
        '</div>'
    );
}