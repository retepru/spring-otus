function deleteBook(id) {
    let jqxhr = $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/book/" + id,
        data: "",
        dataType: "json",
        success: function (result) {
            console.log(result);
        },
        error: function (e) {
            console.log("error deleteBook: " + e);
        },
        async: false // в true надо использовать callback функцию
    });

    bookTable(JSON.parse(jqxhr.responseText));
}