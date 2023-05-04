function saveBook(event) {
    // let formEditBook = document.getElementById("formEditBook");
    let formData = event.target;

    let tmp = formData.elements.id;

    let jqxhr = $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/book/" + formData.elements.id.value,
        data: JSON.stringify(formDateToArray(formData)),
        // data: { name: "John", id: "1", authorId: "1", styleId: "1"},
        // data: formDateToArray(formData),
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

function formDateToArray(formData) {
    let formDataBook = new FormData(formData);

    let data = {
        id : formDataBook.get("id"),
        name : formDataBook.get("name"),
        author : {
            id : formDataBook.get("authorId")
        },
        style : {
            id : formDataBook.get("styleId")
        }
    }
    return data;
}