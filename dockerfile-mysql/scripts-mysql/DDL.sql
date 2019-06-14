CREATE DATABASE IF NOT EXISTS encuestabd CHARACTER SET latin1 COLLATE latin1_swedish_ci;

USE encuestabd;

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS encuesta;


SET foreign_key_checks = 1;

CREATE TABLE persona(
  id INT(4) NOT NULL AUTO_INCREMENT,
	nombres VARCHAR(20) NOT NULL,
  apellidos VARCHAR(20) NOT NULL,
  edad  INT(2) NOT NULL,
  profesion VARCHAR(40),
  lugar_trabajo VARCHAR(40),
	PRIMARY KEY (`id`)
) ENGINE=INNODB;

CREATE TABLE curso(
  id INT(3) NOT NULL AUTO_INCREMENT,
  curso VARCHAR(50) NOT NULL,

    PRIMARY KEY (`id`)
) ENGINE=INNODB;

CREATE TABLE encuesta(
    id_persona INT(4) NOT NULL AUTO_INCREMENT,
    id_curso   INT(3) NOT NULL,
    
    INDEX (id_curso),
    INDEX (id_persona),
    INDEX (id_curso,id_persona),
	  FOREIGN KEY (id_curso) REFERENCES curso(id),
    FOREIGN KEY (id_persona) REFERENCES persona(id),
    PRIMARY KEY (`id_persona`,`id_curso`)
) ENGINE=INNODB;


