function authorSelect(authors, name, selectedId) {
    let select  = document.createElement('select');
    select.name = name;
    authors.forEach((author) => {
        let selected = author.id == selectedId;
        let option = new Option(author.name, author.id, selected, selected);
        select.append(option);
    })

    return select;
}