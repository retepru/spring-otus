-- используется при     hibernate: #  ddl-auto: none
insert into authors (`name`) values ('Шолохов import');
insert into authors (`name`) values ('Достоевский import');
insert into styles (`name`) values ('Исторический роман import');
insert into books (`name`, `author_id`, `style_id`) values ('Тихий дон import', 1, 1);
insert into books (`name`, `style_id`) values ('дон import', 1);
-- insert into books (`name`, `author_id`, `style_id`) values ('дон import', 0, 0); -- ошибка

insert into comments (`text`, `book_id`) values ('Первый коммент import', 1);
insert into comments (`text`, `book_id` ) values ('2 коммент import', 1);
