function getBookList() {
    let jqxhr = $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/book",
        data: "",
        dataType: "json",
        success: function (result) {
            console.log("success date");
        },
        error: function (e) {
            console.log("error" + e);
        },
        async: false // � true ���� ������������ callback �������
    });

    return jqxhr.responseText;
}