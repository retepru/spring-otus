insert into authors (`name`) values ('Шолохов dataT');
insert into authors (`name`) values ('Достоевский dataT');
insert into styles (`name`) values ('Исторический роман dataT');
insert into books (`name`, `author_id`, `style_id`) values ('Тихий дон dataT', 1, 1);
insert into books (`name`, `author_id`, `style_id`) values ('Война и мир', 2, 1);

insert into comments (`text`, `book_id`) values ('Первый коммент dataT', 1);
insert into comments (`text`, `book_id` ) values ('2 коммент dataT', 2);


-- insert into comments (`text`) values ('Первый коммент dataT');
-- insert into comments (`text`) values ('2 коммент dataT');
-- insert into BOOKS_COMMENTS values (1, 1);
-- insert into BOOKS_COMMENTS values (1, 2);