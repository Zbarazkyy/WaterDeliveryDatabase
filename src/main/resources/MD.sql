DROP DATABASE MD;

CREATE DATABASE MD;

USE MD;

CREATE TABLE users
(user_id INT auto_increment primary key,
user_name VARCHAR (20) NOT NULL UNIQUE, 
password VARCHAR (20) NOT NULL, 
admin TINYINT NOT NULL ); 

INSERT INTO users 
( user_name, password, admin)
VALUES
( 'Pavel', 'MyPassword', 1),
( 'Max', '12345', 0);

CREATE TABLE clients
(client_id INT auto_increment primary key,
f_name VARCHAR (30) NOT NULL,
l_name VARCHAR (30) NOT NULL,
address_city VARCHAR (25) NOT NULL,
address_street VARCHAR (50) NOT NULL,
address_house VARCHAR (20) NOT NULL,
address_flat VARCHAR (25),
address_notes VARCHAR (100),
phone_1 INT NOT NULL UNIQUE,
phone_2 INT,
phone_3 INT,
user_id INT NOT NULL,

foreign key (user_id) references users (user_id)
);

INSERT INTO clients 
(f_name, l_name, address_city, address_street, address_house, address_flat, address_notes, phone_1, user_id)
VALUES
('Павел', 'Збаразький', 'Буча', 'Новое Шоссе', '11', 'частный дом', 'злая собака, магнитный ключ', '0674406029', 1), 
('Катерина', 'Ломова', 'Ирпень', 'Ярослава', '24', '25', 'код двери 2534', '0673470000', 2), 
('Константин', 'Носенко', 'Киев', 'Я.Луковецького', '25', 'частный дом', 'позвонить за 2 часа', '0675997497', 1);


CREATE TABLE items
(item_id INT auto_increment primary key,
item VARCHAR (50) NOT NULL,
item_price INT NOT NULL
);

INSERT INTO items 
( item, item_price)
VALUES
('Бутыль с водой', 55),
('Пустой бутыль', 150),
('Помпа для воды', 170);

CREATE TABLE orders
(order_id INT,
item_id INT NOT NULL,
client_id INT NOT NULL,
quantity INT NOT NULL,
orders_date date NOT NULL,
user_id INT NOT NULL,

foreign key (user_id) references users (user_id),
foreign key (item_id) references items (item_id),
foreign key (client_id) references clients (client_id),

primary key (order_id, item_id)  
);

INSERT INTO orders 
( order_id, item_id, client_id,  quantity, orders_date, user_id )
VALUES
(1,1,1,2, now(), 1),
(1,2,1,2, now(), 1),
(2,3,3,10, now(), 2),
(3,1,2,3, now(), 2);



