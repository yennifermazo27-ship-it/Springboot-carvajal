create database carvajal;
use carvajal;

create table categorias (
  id int auto_increment primary key,
  nombre varchar(100)
);
 
create table productos (
  id int auto_increment primary key,
  nombre varchar(150),
  precio decimal(10,2),
  cantidad_en_stock int,
  categoria_id int,
  foreign key (categoria_id) references categorias(id)
);


create table lista_deseos (
  id int auto_increment primary key,
  producto_id int,
  fecha_agregado timestamp default current_timestamp
);

create table historial (
  id int auto_increment primary key,
  producto_id int,
  accion varchar(10),
  fecha_accion timestamp default current_timestamp
);

insert into categorias (nombre) values
('Papeleria'), ('Archivo'), ('Escritura'), ('Oficina'), ('Herramientas'), ('Adhesivos');


insert into productos (nombre, precio, cantidad_en_stock, categoria_id) values
('Cuaderno Profesional', 8500, 50, 1),
('Resma de Papel', 22000, 30, 1),
('Carpeta AZ', 15000, 20, 2),
('Boligrafo x10', 12000, 100, 3),
('Sello Automatico', 35000, 0, 4),
('Tijeras Metalicas', 9500, 15, 5),
('Cinta Pegante x12', 18000, 0, 6),
('Marcadores x4', 11000, 40, 3);

select*from productos;
select*from categorias;
