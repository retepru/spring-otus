function styleSelect(styles, name, selectedId) {
    let select  = document.createElement('select');
    select.name = name;
    styles.forEach((style) => {
        let selected = style.id == selectedId;
        let option = new Option(style.name, style.id, selected, selected);
        select.append(option);
    })

    return select;
}