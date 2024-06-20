CREATE TABLE contenido (
     id BIGINT NOT NULL AUTO_INCREMENT,
     titulo VARCHAR(100) NOT NULL,
     contenido VARCHAR(1000) NOT NULL,
     fecha DATETIME NOT NULL,
     estado VARCHAR(15) NOT NULL,
     usuario_uno_id BIGINT NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT fk_contenido_usuario_uno_id FOREIGN KEY (usuario_uno_id) REFERENCES usuarios(id)
 );

