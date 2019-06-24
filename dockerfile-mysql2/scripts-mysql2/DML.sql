USE encuestabd;

INSERT INTO curso VALUES(1,"Java");
INSERT INTO curso VALUES(2,"C#");

INSERT INTO persona VALUES(1,"Jose Luis","Marquez Campos",32,"Ingeniero de Sistemas","Consultora XYZ");
INSERT INTO persona VALUES(2,"Maria luisa","Arjona Rodrigues",35,"Tecnico Sistemas","Consultora Apple");
INSERT INTO persona VALUES(3,"Alberto Ademir","Farfan Ganoza",28,"Ingeniero de Industrial","Consultora Microsoft");

INSERT INTO encuesta VALUES(1, 1,1);
INSERT INTO encuesta VALUES(2, 2,1);
INSERT INTO encuesta VALUES(3, 3,2);


COMMIT;