function editBook(book) {
    let rootId = document.getElementById("root");
    rootId.innerHTML = '';

    let formBook = document.createElement('form');
    formBook.setAttribute('id', 'formEditBook');
    formBook.onsubmit = function (event) {
        event.preventDefault();
        saveBook(event);
    }

    let divBook = document.createElement('div');
    let labelNameBook = document.createElement('label');
    labelNameBook.textContent = "Name book:";
    labelNameBook.setAttribute('for', 'bookName');

    let inputNameBook = document.createElement('input');
    inputNameBook.value = book.name;
    inputNameBook.setAttribute('name', 'name');
    inputNameBook.setAttribute('type', 'text');

    let inputIdBook = document.createElement('input');
    inputIdBook.value = book.id;
    inputIdBook.setAttribute('name', 'id');
    inputIdBook.setAttribute('type', 'hidden');

    divBook.append(labelNameBook);
    divBook.append(inputNameBook);
    divBook.append(inputIdBook);

    // Author
    let divAuthor = document.createElement('div');
    let authors = JSON.parse(getAuthorList());
    let selectAuthor = styleSelect(authors, "authorId", book.author != null ? book.author.id : null);
    let labelAuthor = document.createElement('label');
    labelAuthor.textContent = "Author:";
    labelAuthor.setAttribute('for', 'author')

    divAuthor.append(labelAuthor);
    divAuthor.append(selectAuthor);

    // Style
    let divStyle = document.createElement('div');
    let styles = JSON.parse(getStyleList());
    let selectStyle = styleSelect(styles, "styleId", book.style != null ? book.style.id : null);
    let labelStyle = document.createElement('label');
    labelStyle.textContent = "Style:";
    labelStyle.setAttribute('for', 'style')
    divStyle.append(labelStyle);
    divStyle.append(selectStyle);

    let submitBook = document.createElement('input');
    submitBook.setAttribute('type', 'submit');
    submitBook.value = "Send";

    // submitBook.onsubmit = function() {
    //     saveBook();
    // }

    formBook.append(divBook);
    formBook.append(divAuthor);
    formBook.append(divStyle);
    formBook.append(submitBook);

    rootId.append(formBook);
}