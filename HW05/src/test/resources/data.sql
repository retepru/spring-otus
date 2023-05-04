insert into authors (`name`) values ('Шолохов');
insert into authors values (default, 'Достоевский');
insert into styles (`name`) values ('Исторический роман');
insert into books (`name`, `id_author`, `id_style`) values ('Тихий дон', 1, 1);
-- insert into books (`name`, `id_author`, `id_style`) values ('Война и мир', 1, 1);
-- select * from authors;

-- test
-- insert into TMP_ONE (id, `name`) values (1, 'Шолохов');
-- insert into TMP_TWO (id, ID_TMP_ONE, `name`) values (1, 1, 'Тихий дон');
-- insert into TMP_TWO (id, ID_TMP_ONE, `name`) values (2, NULL, 'Война и мир');