-- create database mystore;

-- use mystore;

/* 
create table orders (
	order_id char(8) not null,
	name varchar(32) not null,
    email varchar(64) not null,
    express boolean default false,
    constraint pk_order_id primary key(order_id)
);
*/

/*
create table lineitems (
	item_id int not null auto_increment,
    order_id char(8) not null,
    name varchar(64) not null,
    quantity int not null, 
    unit_price decimal (8,2) not null,
    constraint pk_item_id primary key(item_id),
    constraint fk_order_id foreign key(order_id) references orders(order_id)
);
*/

select o.name, o.email, l.item_name, l.quantity
from orders o
join lineitems l
on o.order_id = l.order_id
where o.order_id = '3e6afc57';

select * from orders;
select * from lineitems;
delete from orders;
