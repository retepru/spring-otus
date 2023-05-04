$(document).ready(function(event) {
    $("#getBooks").click(function (event) {
        console.log("click button books")
        event.preventDefault();
        let json = getBookList();
        console.log(JSON.parse(json));
        bookTable(JSON.parse(json));
        }
    );
})