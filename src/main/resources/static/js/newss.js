$(document).ready(function () {
    findNewses();
});

function findNewses(){
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
    $('#articule').append(
        '<div id="information">' +
            '<div id="title">' + news.title +
            '</div>' +
            '<div id="content">' + news.content +
            '</div>' +
            '<div id="date">' + news.createDate +
            '</div>' +
        '</div>'
    );
}