CREATE schema DB_DAO;

CREATE TABLE usuario(
	  ID INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45),
    PRIMARY KEY (ID)
);

select * from usuario;