

CREATE DATABASE IF NOT EXISTS DBCampusTEC;

USE DBCampusTEC;


CREATE TABLE Perfil(
   IdPerfil INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   Nombre VARCHAR(30),
   Apellido VARCHAR(30),
   Usuario  VARCHAR(10),
   Pin VARCHAR(8),
   Rol CHAR(1),
   Activo INT
);


CREATE TABLE Profesor(
   IdProfesor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   IdPerfil INT NOT NULL,
   Email1 VARCHAR(30),
   Email2 VARCHAR(30),
   Celular VARCHAR(11),
   Foto VARCHAR(100),
   FOREIGN KEY (IdPerfil) REFERENCES Perfil(IdPerfil)
);

CREATE TABLE Curso(
   IdCurso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   IdProfesor INT NOT NULL,
   Nombre VARCHAR(40) NOT NULL,
   TecColones INT,
   FOREIGN KEY (IdProfesor) REFERENCES Profesor(IdProfesor)
);

CREATE TABLE Objetivo(
   IdObjetivo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   IdCurso INT NOT NULL,
   Descripcion VARCHAR(100) NOT NULL,
   FOREIGN KEY (IdCurso) REFERENCES Curso(IdCurso)
);

CREATE TABLE Estudiante(
   IdEstudiante INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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

CREATE TABLE Actividad(
   IdActividad INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   IdCurso INT NOT NULL,
   Nombre VARCHAR(50) NOT NULL,
   ArchivoAdjunto VARCHAR(100) NOT NULL,
   Descripcion VARCHAR(200),
   Fecha DATETIME,
   FOREIGN KEY (IdCurso) REFERENCES Curso(IdCurso)
);

CREATE TABLE Tarea(
   IdTarea INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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


CREATE TABLE EstudiantexActividad(
   IdEstudiante INT NOT NULL,
   IdActividad INT NOT NULL,
   Completada INT NOT NULL,
   FOREIGN KEY (IdEstudiante) REFERENCES Estudiante(IdEstudiante),
   FOREIGN KEY (IdActividad) REFERENCES Actividad(IdActividad)
);

CREATE TABLE EstudiantexCurso(
   IdEstudiante INT NOT NULL,
   IdCurso INT NOT NULL,
   FOREIGN KEY (IdEstudiante) REFERENCES Estudiante(IdEstudiante),
   FOREIGN KEY (IdCurso) REFERENCES Curso(IdCurso)
);

CREATE TABLE Reto(
   IdReto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   IdCurso INT NOT NULL,
   NombreReto VARCHAR(30) NOT NULL,
   Descripcion VARCHAR(100),
   FechaLimte DATETIME,
   TecColones INT NOT NULL,
   FOREIGN KEY (IdCurso) REFERENCES Curso(IdCurso)
);

CREATE TABLE RetoxObjetivo(
   IdReto INT NOT NULL,
   IdObjetivo INT NOT NULL,
   FOREIGN KEY (IdReto) REFERENCES Reto(IdReto),
   FOREIGN KEY (IdObjetivo) REFERENCES Objetivo(IdObjetivo)
);


CREATE TABLE RetoxActividad(
   IdReto INT NOT NULL,
   IdActividad INT NOT NULL,
   FOREIGN KEY (IdReto) REFERENCES Reto(IdReto),
   FOREIGN KEY (IdActividad) REFERENCES Actividad(IdActividad)
);