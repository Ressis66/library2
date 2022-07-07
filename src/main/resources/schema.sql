DROP TABLE IF EXISTS authors CASCADE;
DROP TABLE IF EXISTS genres CASCADE;
DROP TABLE IF EXISTS books CASCADE;
CREATE TABLE authors (id int NOT NULL AUTO_INCREMENT, name varchar(255), PRIMARY KEY (id));
CREATE TABLE genres (id int NOT NULL AUTO_INCREMENT, name varchar(255), PRIMARY KEY (id));
CREATE TABLE books (
id int NOT NULL AUTO_INCREMENT,
name varchar(255),
genre_id int,
author_id int,
FOREIGN KEY (genre_id)  REFERENCES genres(id),
FOREIGN KEY (author_id)  REFERENCES  authors(id)
);


