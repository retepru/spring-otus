insert into authors (`name`) values ('Шолохов data');
insert into authors (`name`) values ('Достоевский data');
insert into styles (`name`) values ('Исторический роман data');
insert into books (`name`, `author_id`, `style_id`) values ('Тихий дон data', 1, 1);
insert into books (`name`, `author_id`, `style_id`) values ('Война и мир data', 2, 1);

insert into comments (`text`, `book_id`) values ('Первый коммент data', 1);
insert into comments (`text`, `book_id` ) values ('2 коммент data', 1);

-- insert into comments (`text`) values ('Первый коммент import');
-- insert into comments (`text`) values ('2 коммент import');
-- insert into BOOKS_COMMENTS (`BOOK_ID`, `COMMENTS_ID`) values (1, 1);
-- insert into BOOKS_COMMENTS values (1, 1, 1);
-- insert into BOOKS_COMMENTS values (1, 2);
-- select * from authors;

-- test
-- insert into TMP_TWO (`name`) values  ('Два');
-- insert into TMP_TREE (`name`) values ('три');
--
-- insert into TMP_ONE (id, TMP_TWO_ID, TMP_TREE_ID, `name`) values (1, 1, 1, 'один');