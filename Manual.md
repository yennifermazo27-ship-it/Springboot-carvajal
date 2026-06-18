# Carvajal 

Aplicación backend desarrollada con **Java + Spring Boot** que permite gestionar una lista de deseos de productos para el modelo E-commerce de Carvajal.


##  Requisitos previos

Antes de ejecutar el proyecto asegúrate de tener instalado:

| Herramienta | Versión recomendada |
|-------------|-------------------|
| Java JDK | 21 |
| Maven | 3.9+ |
| MySQL | 8.0+ |
| Postman | Cualquier versión |



## Configuración de la base de datos

### 1. Crear la base de datos

Abre MySQL Workbench o tu cliente de preferencia y ejecuta el siguiente script:


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

### 2. Insertar datos de ejemplo

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



##  Configuración del proyecto

### Credenciales de base de datos

Abre el archivo `src/main/resources/application.yaml` y ajusta las credenciales según tu entorno:

spring:
  application:
    name: carvajal
  datasource:
    url: jdbc:mysql://localhost:3306/carvajal
    username: root
    password: 1234
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect

server:
  port: 8080
  
---

##  Manual de despliegue

### Opción 1 — Desde Visual Studio

1. Abre Visual Studio
2. Selecciona **File → Open** y elige la carpeta del proyecto
3. Espera que Maven descargue las dependencias automáticamente
4. Abre el archivo `CarvajalApplication.java`
5. Haz clic en el botón ▶️ **Run**
6. El servidor inicia en `http://localhost:8080`

### Opción 2 — Desde la terminal

```
# 1. Entrar a la carpeta del proyecto
cd carvajal

# 2. Compilar el proyecto
mvn clean install

# 3. Ejecutar el proyecto
mvn spring-boot:run
```

---

##  Endpoints disponibles

Base URL: `http://localhost:8080`

### Productos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/productos` | Ver catálogo completo con stock |



### Lista de deseos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/lista-deseos` | Agregar producto a lista de deseos |
| PUT | `/api/lista-deseos/{id}` | Actualizar cantidad de un deseo |
| DELETE | `/api/lista-deseos/{id}` | Eliminar producto de lista de deseos |


---

##  Estructura del proyecto


src/main/java/com/yennifer/carvajal/
├── CarvajalApplication.java
├── controller/
│   ├── ProductoController.java
│   └── ListaDeseosController.java
|   |__ CategoriaController.java
├── dto/
│   ├── GlobalHttpResponse.java
│   ├── CategoriaDTO.java
│   ├── ProductoDTO.java
│   ├── ListaDeseosDTO.java
│   ├── HistorialDTO.java
│   
├── entity/
│   ├── Categoria.java
│   ├── Producto.java
│   ├── ListaDeseos.java
│   └── Historial.java
├── repository/
│   ├── CategoriaRepository.java
│   ├── ProductoRepository.java
│   ├── ListaDeseosRepository.java
│   └── HistoricoRepository.java
└── service/
    ├── CategoriaService.java
    └── ListaDeseosService.java
    ├── ProductoService.java
    



---

##  Dependencias principales

| Dependencia | Uso |
|-------------|-----|
| Spring Web | Creación de endpoints REST |
| Spring Data JPA | Conexión y manejo de base de datos |
| MySQL Driver | Conector con MySQL |
| Lombok | Reducción de código con @Data, @AllArgsConstructor |

---

## Autor

Yennifer Mazo Montoya
Prueba Técnica 
Carvajal E-commerce
ADSO:3231651
