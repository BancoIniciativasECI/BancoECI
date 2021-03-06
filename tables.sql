CREATE TABLE usuario(
   `documento` bigint PRIMARY KEY,
   `email` VARCHAR (50) UNIQUE,
   `nombre` VARCHAR (50) NOT NULL,
   `apellido` VARCHAR (50) NOT NULL,
   `password` VARCHAR (50) NOT NULL,
   `rol` VARCHAR (50),
   `area` VARCHAR (50)
);

CREATE TABLE iniciativa(
   `id` serial ,
   `nombre` VARCHAR (50) unique NOT NULL,
   `descripcion` VARCHAR (50) NOT NULL,
   `estado` VARCHAR (50) NOT null,
   `fecha_registro` date not null,
   `usuario` INTEGER REFERENCES usuario(documento) DEFERRABLE,
   primary key (id)
);

CREATE TABLE comentario(
   `id` serial ,
   `fecha_comentario` date not null,
   `contenido` VARCHAR (50) NOT NULL,
   `correo_usuario` VARCHAR (50) NOT NULL,
   `nombre_usuario` VARCHAR (50) NOT NULL,
   `apellido_usuario` VARCHAR (50) NOT NULL,
   `iniciativa` INTEGER REFERENCES iniciativa(id) DEFERRABLE,
   primary key (id)
);

CREATE TABLE votacion(
   `id` serial ,
   `usuario` INTEGER REFERENCES usuario(documento)  DEFERRABLE,
   `iniciativa` VARCHAR (50) references iniciativa(nombre) DEFERRABLE,
   primary key (id)
);

CREATE TABLE palabraClave(
   `id` serial ,
   `iniciativa` VARCHAR (50) REFERENCES iniciativa(nombre)  DEFERRABLE,
   `palabra` varchar(50) not null,
   primary key (id)
);

CREATE TABLE proyectoRelacionado(
   `iniciativa` INTEGER REFERENCES iniciativa(id)  DEFERRABLE,
   `iniciativaRelacionada` INTEGER REFERENCES iniciativa(id)  DEFERRABLE,
   primary key (iniciativa,iniciativaRelacionada)
);


insert into usuario (documento,email,nombre,apellido,password,rol,area ) values (2154021,'ernesto.camacho@mail.escuelaing.edu.co','Ernesto','Camacho','1234','Administrador','Pruebas');
insert into usuario (documento,email,nombre,apellido,password,rol,area ) values (2000003,'no.rol@mail.escuelaing.edu.co','no','rol','1234',null,'otro');
INSERT INTO iniciativa (id, nombre, descripcion, estado, fecha_registro, usuario) VALUES(1, 'Proyecto finanzas', 'Finanzas para la universidad', 'Espera', '2020-04-17', 2154021);
INSERT INTO iniciativa (id, nombre, descripcion, estado, fecha_registro, usuario) VALUES(2, 'Prueba 1', 'Prueba 1', 'Espera', '2020-04-17', 2154021);
INSERT INTO iniciativa (id, nombre, descripcion, estado, fecha_registro, usuario) VALUES(3, 'Prueba 2', 'Prueba 2', 'Espera', '2020-04-17', 2154021);
INSERT INTO palabraclave (id, iniciativa, palabra) VALUES(16, 'Prueba 1', 'Prueba 1');