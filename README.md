 sql-1


create database store;
 Q1
create table countries(

    code int primary key ,
    name varchar(20) not null ,
    continent_name varchar(20) not null

);
  create table users(
     id int not null primary key ,
     full_name varchar(20) ,
     email varchar(20)not null unique ,
     gender char(1) not null  check (gender='m'or gender='f' ),
     date_of_birth varchar(15) not null ,
     created_at datetime not null ,
     country_code int not null ,
  foreign key (country_code) references countries(code)
  );
create table orders(
    id int not null primary key ,
    user_id int not null ,
    foreign key (user_id) references users(id),
    status varchar(6)not null check ( status='start' or status='finish'),
    created_at datetime not null

);
create table order_products(
    order_id int not null ,
    foreign key (order_id)references orders(id),
    product_id int not null ,
    foreign key (product_id)references products(id) ,
    quantity int not null default 0
);
create table products(
    id int not null primary key ,
   name varchar(10) not null ,
   price int not null default 0,
   status varchar(10) not null check ( status='valid' or status='expired' ) ,
   created_at datetime
);


insert into countries values (1,'ksa', 'asui');
 insert into  users values (1,'jamelah','jamelah@com','f','22/10/1919','2022-08-15 06:34:07',3248);
 insert into  orders values (4,1,'start','2022-08-15 06:34:07');
insert into products values (1,'iphone',222,'valid','2022-08-15 06:34:07');
 insert into order_products values (15,8,355);

update countries set name='uks' where code='1';
delete from products  where id='1';
