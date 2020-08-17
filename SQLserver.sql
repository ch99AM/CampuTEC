

--CREATE DATABASE DBCampusTEC;
--GO

USE DBCampusTEC;
GO

CREATE TABLE Perfil(
   IdPerfil INT IDENTITY(1,1) PRIMARY KEY,
   Nombre VARCHAR(30),
   Apellido VARCHAR(30),
   Usuario  VARCHAR(10),
   Pin VARCHAR(8),
   Rol CHAR(1),
   Activo INT
);
GO

CREATE TABLE Profesor(
   IdProfesor INT IDENTITY(1,1) PRIMARY KEY,
   IdPerfil INT NOT NULL,
   Email1 VARCHAR(30),
   Email2 VARCHAR(30),
   Celular VARCHAR(11),
   Foto VARCHAR(100),
   FOREIGN KEY (IdPerfil) REFERENCES Perfil(IdPerfil)
);
GO

CREATE TABLE Curso(
   IdCurso INT IDENTITY(1,1) PRIMARY KEY,
   IdProfesor INT NOT NULL,
   Nombre VARCHAR(40) NOT NULL,
   TecColones INT,
   FOREIGN KEY (IdProfesor) REFERENCES Profesor(IdProfesor)
);
GO

CREATE TABLE Objetivo(
   IdObjetivo INT IDENTITY(1,1) PRIMARY KEY,
   IdCurso INT NOT NULL,
   Descripcion VARCHAR(100) NOT NULL,
   FOREIGN KEY (IdCurso) REFERENCES Curso(IdCurso)
);
GO


CREATE TABLE Estudiante(
   IdEstudiante INT IDENTITY(1,1) PRIMARY KEY,
   IdPerfil INT NOT NULL,
   Universidad VARCHAR(50) NOT NULL,
   Sede VARCHAR(50) NOT NULL,
   Email1 VARCHAR(30),
   Email2 VARCHAR(30),
   Celular VARCHAR(11),
   Foto    VARCHAR(100),
   TecColones INT NOT NULL,
   FOREIGN KEY (IdPerfil) REFERENCES Perfil(IdPerfil)
);
GO

CREATE TABLE Actividad(
   IdActividad INT IDENTITY(1,1) PRIMARY KEY,
   IdCurso INT NOT NULL,
   Nombre VARCHAR(50) NOT NULL,
   ArchivoAdjunto VARCHAR(100) NOT NULL,
   Descripcion VARCHAR(200),
   Fecha DATETIME,
   FOREIGN KEY (IdCurso) REFERENCES Curso(IdCurso)
);
GO


CREATE TABLE Tarea(
   IdTarea INT IDENTITY(1,1) PRIMARY KEY,
   IdEstudiante INT NOT NULL,
   IdActividad INT NOT NULL,
   Descripcion VARCHAR(100) NOT NULL,
   Semana INT NOT NULL,
   Fecha DATE,
   HoraInicio TIME,
   HoraFinal TIME,
   FOREIGN KEY (IdEstudiante) REFERENCES Estudiante(IdEstudiante),
   FOREIGN KEY (IdActividad) REFERENCES Actividad(IdActividad)
);
GO

CREATE TABLE EstudiantexActividad(
   IdExA INT IDENTITY(1,1) PRIMARY KEY,
   IdEstudiante INT NOT NULL,
   IdActividad INT NOT NULL,
   Completada INT NOT NULL,
   FOREIGN KEY (IdEstudiante) REFERENCES Estudiante(IdEstudiante),
   FOREIGN KEY (IdActividad) REFERENCES Actividad(IdActividad)
);
GO


CREATE TABLE EstudiantexCurso(
   IdExC INT IDENTITY(1,1) PRIMARY KEY,
   IdEstudiante INT NOT NULL,
   IdCurso INT NOT NULL,
   FOREIGN KEY (IdEstudiante) REFERENCES Estudiante(IdEstudiante),
   FOREIGN KEY (IdCurso) REFERENCES Curso(IdCurso),
);
GO

CREATE TABLE Reto(
   IdReto INT IDENTITY(1,1) PRIMARY KEY,
   IdCurso INT NOT NULL,
   NombreReto VARCHAR(30) NOT NULL,
   Descripcion VARCHAR(100),
   FechaLimte DATETIME,
   TecColones INT NOT NULL,
   FOREIGN KEY (IdCurso) REFERENCES Curso(IdCurso)
);
GO

CREATE TABLE RetoxObjetivo(
   IdRxO INT IDENTITY(1,1) PRIMARY KEY,
   IdReto INT NOT NULL,
   IdObjetivo INT NOT NULL,
   FOREIGN KEY (IdReto) REFERENCES Reto(IdReto),
   FOREIGN KEY (IdObjetivo) REFERENCES Objetivo(IdObjetivo),
);
GO

CREATE TABLE RetoxActividad(
   IdRxA INT IDENTITY(1,1) PRIMARY KEY,
   IdReto INT NOT NULL,
   IdActividad INT NOT NULL,
   FOREIGN KEY (IdActividad) REFERENCES Actividad(IdActividad),
   FOREIGN KEY (IdReto) REFERENCES Reto(IdReto),
);
GO

select * from Perfil;
select * from Estudiante;
select * from Profesor;

INSERT INTO Perfil(Nombre, Apellido, Usuario, Pin, Rol, Activo) 
VALUES ('Christian', 'Alpizar', '2017146794', '1234', 'E', 1),
		('Jose', 'Monge', '2017146795', '1234', 'E', 1),
		('Andrey', 'Sibaja', '2017146796', '1234', 'P', 1),
		('Edgar', 'Chaves', '2017146797', '1234', 'E', 1);
GO

INSERT INTO Estudiante(IdPerfil, Universidad, Sede,TecColones) 
VALUES ((SELECT IdPerfil from Perfil 
			Where Nombre = 'Christian'), 'TEC', 'Central', 20),
		((SELECT IdPerfil from Perfil 
			Where Nombre = 'Jose'), 'TEC', 'Central', 20),
		((SELECT IdPerfil from Perfil 
			Where Nombre = 'Edgar'), 'TEC', 'Central', 20);
GO

INSERT INTO Profesor(IdPerfil, Email1, Celular) 
VALUES ((SELECT IdPerfil from Perfil 
			Where Nombre = 'Andrey'), 'example@gmail.com', '50688888888');
GO

select * from Perfil;


Delete Perfil;
Delete Profesor;
Delete Estudiante;
