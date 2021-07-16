--Create status of patients and healthcare professionals
insert into status (name) values ('Online'),('Busy'),('Offine');

--User: admin  Password: 12345
insert into patient (username, password, enabled, status_id) values ('admin', '$2a$10$pmPLtjIzArn7UN3/WTZStOuV8Nk1dIFgyZ8MDVWf1ob4kGTPVwKGy', true, 1);
insert into authorities values ('admin','ADMIN');

insert into healthcare_professional (crm, name, rating, status_id) values ('123458', 'Eliza da Silva', 4, 1);
insert into healthcare_professional (crm, name, rating, status_id) values ('123456', 'Jonas da Silva', 5, 1);
insert into healthcare_professional (crm, name, rating, status_id) values ('123457', 'Eduardo da Silva', 5, 1);

insert into health_insurance (cnpj, name, price) values ('000940294', 'Medteste', 200);
insert into health_insurance (cnpj, name, price) values ('000940394', 'SaudeConv', 350);
insert into health_insurance (cnpj, name, price) values ('000940291', 'MeuMed', 150);

--Create association between healthcare professionals and health insurances
insert into public.healthcare_professional_health_insurance values (1,1);
insert into public.healthcare_professional_health_insurance values (2,1);
insert into public.healthcare_professional_health_insurance values (3,3);
insert into public.healthcare_professional_health_insurance values (4,2);
