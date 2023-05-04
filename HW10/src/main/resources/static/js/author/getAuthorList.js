function getAuthorList() {
    let jqxhr = $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/author",
        data: "",
        dataType: "json",
        success: function (result) {
            console.log("success date");
        },
        error: function (e) {
            console.log("error" + e);
        },
        async: false // в true надо использовать callback функцию
    });

    return jqxhr.responseText;
}