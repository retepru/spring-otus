-- ������������ ���     hibernate: #  ddl-auto: none
insert into authors (`name`) values ('������� import');
insert into authors (`name`) values ('����������� import');
insert into styles (`name`) values ('������������ ����� import');
insert into books (`name`, `author_id`, `style_id`) values ('����� ��� import', 1, 1);
insert into books (`name`, `style_id`) values ('��� import', 1);
-- insert into books (`name`, `author_id`, `style_id`) values ('��� import', 0, 0); -- ������

insert into comments (`text`, `book_id`) values ('������ ������� import', 1);
insert into comments (`text`, `book_id` ) values ('2 ������� import', 1);
