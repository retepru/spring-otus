insert into authors (`name`) values ('������� dataT');
insert into authors (`name`) values ('����������� dataT');
insert into styles (`name`) values ('������������ ����� dataT');
insert into books (`name`, `author_id`, `style_id`) values ('����� ��� dataT', 1, 1);
insert into books (`name`, `author_id`, `style_id`) values ('����� � ���', 2, 1);

insert into comments (`text`, `book_id`) values ('������ ������� dataT', 1);
insert into comments (`text`, `book_id` ) values ('2 ������� dataT', 2);


-- insert into comments (`text`) values ('������ ������� dataT');
-- insert into comments (`text`) values ('2 ������� dataT');
-- insert into BOOKS_COMMENTS values (1, 1);
-- insert into BOOKS_COMMENTS values (1, 2);