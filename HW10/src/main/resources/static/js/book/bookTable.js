function bookTable(books) {
    let rootId = document.getElementById("root");
    rootId.innerHTML = '';

    if (books == null) {
        rootId.innerHTML('Books not found');
    }

    let table = document.createElement('table');

    let thead = document.createElement('thead');
    let trThead = document.createElement('tr');

    ["id", "Book name", "Author", "Edit", "Delete"]
        .forEach((item) => {
            let tdThead = document.createElement('td');
            tdThead.textContent = item;
            trThead.append(tdThead);
        })

    thead.append(trThead);
    table.append(thead);

    let tbody = document.createElement('tbody');

    books.forEach((book) => {
        let tr = document.createElement('tr');
        tr.setAttribute('id', 'bookId'+book.id);
        // id
        let tdId = document.createElement('td').textContent = book.id;
        // Name
        let tdName = document.createElement('td');
        tdName.textContent = book.name;
        // Author
        let tdAuthor = document.createElement('td');
        tdAuthor.textContent = book.author.name;
        // Edit
        let tdEdit = document.createElement('td');
        let buttonEdit = document.createElement('button');
        buttonEdit.textContent = "Edit";
        buttonEdit.onclick = function() {
            editBook(book);
        }
        tdEdit.append(buttonEdit);
        // Delete
        let tdDelete = document.createElement('td');
        let buttonDelete = document.createElement('button');
        buttonDelete.textContent = "Delete";
        buttonDelete.onclick = function() {
            deleteBook(book.id);
        }
        tdDelete.append(buttonDelete);

        tr.append(tdId);
        tr.append(tdName);
        tr.append(tdAuthor);
        tr.append(tdEdit);
        tr.append(tdDelete);
        tbody.append(tr);
    })
    table.append(tbody);
    rootId.append(table);
}