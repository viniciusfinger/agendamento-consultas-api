
insert into status (name) values ('Online'),('Busy'),('Offine');

--User: admin  Password: 12345
insert into patient (username, password, enabled, status_id) values ('admin', '$2a$10$pmPLtjIzArn7UN3/WTZStOuV8Nk1dIFgyZ8MDVWf1ob4kGTPVwKGy', true, 1);
insert into authorities values ('admin','ADMIN');