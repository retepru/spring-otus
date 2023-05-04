function getStyleList() {
    let jqxhr = $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/style",
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