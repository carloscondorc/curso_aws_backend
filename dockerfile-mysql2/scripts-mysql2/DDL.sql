CREATE DATABASE IF NOT EXISTS encuestabd CHARACTER SET latin1 COLLATE latin1_swedish_ci;

USE encuestabd;

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS encuesta;


SET foreign_key_checks = 1;

CREATE TABLE curso(
  id INT(3) NOT NULL AUTO_INCREMENT,
  curso VARCHAR(50) NOT NULL,

    PRIMARY KEY (`id`)
) ENGINE=INNODB;


CREATE TABLE encuesta(
  id INT(4) NOT NULL AUTO_INCREMENT,
	nombres VARCHAR(20) NOT NULL,
  apellidos VARCHAR(20) NOT NULL,
  edad  INT(2) NOT NULL,
  profesion VARCHAR(40) NOT NULL,
  lugar_trabajo VARCHAR(40) NOT NULL,
  id_curso INT(3) NOT NULL,

  INDEX (id_curso),
  FOREIGN KEY (id_curso) REFERENCES curso(id),

	PRIMARY KEY (`id`)
) ENGINE=INNODB;



