CREATE SEQUENCE country_seq START 1;
create table country (
    id numeric(5) primary key,
    name varchar(100) not null,
    country_code varchar(5) not null UNIQUE
);

CREATE SEQUENCE client_seq START 1;
create table client (
    id numeric(20) primary key,
    name varchar(100) not null,
    birthday date not null,
    country_id numeric(5) references country(id)
);

CREATE SEQUENCE contact_seq START 1;
create table contact (
    id numeric(20) primary key,
    type varchar(30) not null,
    contact_value varchar(200),
    country_id numeric(5) references country(id),
    phone_number numeric(20),
    extension numeric(5),
    client_id numeric(20) not null references client(id)
);

CREATE SEQUENCE address_seq START 1;
create table address (
    id numeric(20) primary key,
    type varchar(30) not null,
    address varchar(300),
    number varchar(10),
    complement varchar(50),
    city varchar(100),
    country_id numeric(5) references country(id),
    zipcode varchar(30),
    client_id numeric(20) not null references client(id)
);

-- Insert into country table
insert into country (id, name, country_code) 
  values(nextval('country_seq'), 'Brazil', '+55');
insert into country (id, name, country_code) 
  values(nextval('country_seq'), 'Poland', '+48');
insert into country (id, name, country_code) 
  values(nextval('country_seq'), 'Ukraine', '+380');
insert into country (id, name, country_code) 
  values(nextval('country_seq'), 'USA', '+1');

-- Insert into client table
insert into client (id, name, birthday, country_id)
  values (nextval('client_seq'), 'Vinicius Antonio Gai', to_date('19881112','YYYYMMDD'), 1);
insert into client (id, name, birthday, country_id)
  values (nextval('client_seq'), 'Frédéric Chopin', to_date('18100301','YYYYMMDD'), 2);
insert into client (id, name, birthday, country_id)
  values (nextval('client_seq'), 'Jerzy Kosiński', null, 2);
insert into client (id, name, birthday, country_id)
  values (nextval('client_seq'), 'Marie Bashkirtseff', null, 3);
insert into client (id, name, birthday, country_id)
  values (nextval('client_seq'), 'Angelo', null, null);
insert into client (id, name, birthday, country_id)
  values (nextval('client_seq'), 'Will Smith', to_date('19680925','YYYYMMDD'), 4);

-- Insert into Address
insert into address(id, type, address, number, complement, zipcode, city, country_id, client_id)
  values (nextval('address_seq'), 'HOME', 'Ul. Grzegorzecka', '456', '10', '31559', 'Krakow', 2, 1);
insert into address(id, type, address, number, complement, zipcode, city, country_id, client_id)
  values (nextval('address_seq'), 'HOME', 'Rua Zuma de sa fernandes', '180', null, '8149000', 'Sao Paulo', 1, 1);
insert into address(id, type, address, number, complement, zipcode, city, country_id, client_id)
  values (nextval('address_seq'), 'WORK', 'Puszkarska', '7K', '7th floor', '30644', 'Krakow', 2, 1);

-- Insert into contact
insert into contact (id, type, contact_value, country_id, phone_number, extension, client_id) 
  values (nextval('contact_seq'), 'EMAIL', 'mypresentation@presentation.com', null, null, null, 1);
insert into contact (id, type, contact_value, country_id, phone_number, extension, client_id) 
  values (nextval('contact_seq'), 'CELLPHONE', null, 2, 456465484, null, 1);