insert into authors (`name`) values ('�������');
insert into authors values (default, '�����������');
insert into styles (`name`) values ('������������ �����');
insert into books (`name`, `id_author`, `id_style`) values ('����� ���', 1, 1);
-- insert into books (`name`, `id_author`, `id_style`) values ('����� � ���', 1, 1);
-- select * from authors;

-- test
-- insert into TMP_ONE (id, `name`) values (1, '�������');
-- insert into TMP_TWO (id, ID_TMP_ONE, `name`) values (1, 1, '����� ���');
-- insert into TMP_TWO (id, ID_TMP_ONE, `name`) values (2, NULL, '����� � ���');