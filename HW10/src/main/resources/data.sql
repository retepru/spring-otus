insert into authors (`name`) values ('������� data');
insert into authors (`name`) values ('����������� data');
insert into styles (`name`) values ('������������ ����� data');
insert into books (`name`, `author_id`, `style_id`) values ('����� ��� data', 1, 1);
insert into books (`name`, `author_id`, `style_id`) values ('����� � ��� data', 2, 1);

insert into comments (`text`, `book_id`) values ('������ ������� data', 1);
insert into comments (`text`, `book_id` ) values ('2 ������� data', 1);

-- insert into comments (`text`) values ('������ ������� import');
-- insert into comments (`text`) values ('2 ������� import');
-- insert into BOOKS_COMMENTS (`BOOK_ID`, `COMMENTS_ID`) values (1, 1);
-- insert into BOOKS_COMMENTS values (1, 1, 1);
-- insert into BOOKS_COMMENTS values (1, 2);
-- select * from authors;

-- test
-- insert into TMP_TWO (`name`) values  ('���');
-- insert into TMP_TREE (`name`) values ('���');
--
-- insert into TMP_ONE (id, TMP_TWO_ID, TMP_TREE_ID, `name`) values (1, 1, 1, '����');