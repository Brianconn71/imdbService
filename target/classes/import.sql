

insert into film (film_name, genre, language, director) values('Up', 'Comedy', 'English', 'Brad Pott')
insert into film (film_name, genre, language, director) values('American Gangster', 'RomCom', 'French', 'Brad Putt')
insert into film (film_name, genre, language, director) values('Shrek', 'Comedy', 'English', 'Brad Pett')

INSERT INTO Genres (id, genre_name) VALUES (1, 'Comedy');
INSERT INTO Genres (id, genre_name) VALUES (2, 'RomCom');

INSERT INTO film_genres (film_id, genre_id) VALUES (1, 1);
INSERT INTO film_genres (film_id, genre_id) VALUES (2, 2);
INSERT INTO film_genres (film_id, genre_id) VALUES (3, 1);