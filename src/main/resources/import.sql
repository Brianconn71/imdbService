

insert into film (film_name, genre) values('Up', 'Comedy')
insert into film (film_name, genre) values('American Gangster', 'RomCom')
insert into film (film_name, genre) values('Shrek', 'Comedy')

INSERT INTO Genres (id, genre_name) VALUES (1, 'Comedy');
INSERT INTO Genres (id, genre_name) VALUES (2, 'RomCom');

INSERT INTO film_genres (film_id, genre_id) VALUES (1, 1);
INSERT INTO film_genres (film_id, genre_id) VALUES (2, 2);
INSERT INTO film_genres (film_id, genre_id) VALUES (3, 1);