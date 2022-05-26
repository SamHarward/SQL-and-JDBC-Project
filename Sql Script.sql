drop table Member cascade constraint;
drop table Profile cascade constraint;
drop table Movie cascade constraint;
drop table Actor cascade constraint;
drop table Genre cascade constraint;
drop table Has cascade constraint;
drop table Watch cascade constraint;
drop table Likes cascade constraint;
drop table Movie_Genre cascade constraint;
drop table Starred_By cascade constraint;

create table Member(
	member_ID   varchar2(30),
    first_Name  varchar2(30),
    last_Name   varchar2(30),
    card_number varchar2(30),
    exp_date    integer,
    primary key(member_ID)
);

create table Profile(
	member_ID   varchar2(30),
	profile_name    varchar2(30),
	primary key(member_ID, profile_name),
	foreign key(member_ID) references Member(member_ID)
);

create table Movie(
    movie_ID    varchar2(30),
    title   varchar2(30),
    movie_year  integer,
    producer    varchar2(30),
    avg_rating  integer,
    primary key(movie_ID)
);

create table Actor(
	actor_ID    varchar2(30),
	first_Name  varchar2(30),
    last_Name	varchar2(30),
    primary key(actor_ID)
);

create table Genre(
	m_genre varchar2(30),
	primary key(m_genre)
);

create table Has(
    member_ID	varchar2(30),
	profile_name	varchar2(30),
	primary key(member_ID, profile_name),
	foreign Key(member_ID, profile_name) references Profile(member_ID, profile_name)
);

create table Watch(
	member_ID	varchar2(30),
    profile_name	varchar2(30),
    movie_ID	varchar2(30),
    rating	integer,
    primary key(member_ID, profile_name, movie_ID),
	foreign key(member_ID, profile_name) References Profile (member_ID, profile_name),
    foreign key(movie_ID) References Movie (movie_ID)
);

create table Likes(
	member_ID	varchar2(30),
	profile_name	varchar2(30),
	m_genre varchar2(30),
	primary key(member_ID, profile_name, m_genre),
	foreign Key(member_ID, profile_name) references Profile(member_ID, profile_name),
	foreign Key(m_genre) references Genre(m_genre)
);

create table Movie_Genre(
    m_genre varchar2(30),
    movie_ID	varchar2(30),
	primary key(m_genre, movie_ID),
	foreign Key(movie_ID) references Movie(movie_ID),
	foreign Key(m_genre) references Genre(m_genre)
);

create table Starred_By(
	movie_ID	varchar2(30),
	actor_ID	varchar2(30),
	primary key(movie_ID, actor_ID),
	foreign key(movie_ID) References Movie (movie_ID),
	foreign key(actor_ID) References Actor (actor_ID)
);

insert into Member values ( '1', 'Wei-Chen', 'Yen', '3354 0057 9854 6412', 20220524);
insert into Member values ( '2', 'Xena', 'Bryant', '5514 3353 8754 0253', 20220817);
insert into Member values ( '3', 'Gus', 'Taylor', '9487 8522 3369 6546', 20220716);
insert into Member values ( '4', 'Aasiyah', 'Huber', '7741 2258 7754 3645', 20220714);
insert into Member values ( '5', 'Emillie', 'Molina', '1354 0057 9854 6412', 20230112);

insert into Profile values('1', 'Wei-Chen Yen');
insert into Profile values('1', 'Gina Yen');
insert into Profile values('2', 'Xena Bryant');
insert into Profile values('2', 'Tracey Andrews');
insert into Profile values('3', 'Gus Taylor');
insert into Profile values('3', 'Daniel Calvert');
insert into Profile values('4', 'Aasiyah Huber');
insert into Profile values('4', 'Breanna Small');
insert into Profile values('5', 'Emillie Molina');
insert into Profile values('5', 'Cari Rosas');

insert into Movie values('1', 'Movie 1', 2001, 'Bob Jones', 8);
insert into Movie values('2', 'Movie 2', 1992, 'Paisley Daly', 7);
insert into Movie values('3', 'Movie 3', 2021, 'Kylo OConnor', 8);
insert into Movie values('4', 'Movie 4', 2006, 'Jena Monroe', 7);
insert into Movie values('5', 'Movie 5', 2006, 'Kristi Mccullough', 8);
insert into Movie values('6', 'Movie 6', 2011, 'Zoe Meyers',7);
insert into Movie values('7', 'Movie 7', 2017, 'Aiza Foster',9);
insert into Movie values('8', 'Movie 8', 2019, 'Mariah Byers',8);
insert into Movie values('9', 'Movie 9', 1997, 'Misblah Blair',10);
insert into Movie values('10', 'Movie 10', 2001, 'Jessie Turnbull',10);

insert into Genre values('Action');
insert into Genre values('Romance');
insert into Genre values('Horror');
insert into Genre values('Comedy');

insert into Actor values('1', 'Abbigail', 'Farrow');
insert into Actor values('2', 'Aaminah', 'Torres');
insert into Actor values('3', 'Leonidas', 'Alvarez');
insert into Actor values('4', 'Jakob', 'Dickens');
insert into Actor values('5', 'Zeeshan', 'Burke');
insert into Actor values('6', 'Joe', 'Beck');
insert into Actor values('7', 'Abul', 'Dunne');
insert into Actor values('8', 'Ariella', 'Prentice');
insert into Actor values('9', 'Alan', 'Herring');
insert into Actor values('10', 'Jardel', 'Woolley');
insert into Actor values('11', 'Brendon', 'Underwood');
insert into Actor values('12', 'Zahrah', 'Lucero');
insert into Actor values('13', 'Monet', 'Jensen');
insert into Actor values('14', 'Azaan', 'Baker');
insert into Actor values('15', 'Anastazja', 'Fritz');
insert into Actor values('16', 'Suzanna', 'Bray');
insert into Actor values('17', 'Belle', 'Rowe');
insert into Actor values('18', 'Myrtle', 'Morse');
insert into Actor values('19', 'Misha', 'Mcdonald');
insert into Actor values('20', 'Suzannah', 'Adkins');

insert into Movie_Genre values('Action','1');
insert into Movie_Genre values('Romance','2');
insert into Movie_Genre values('Action','3');
insert into Movie_Genre values('Romance','4');
insert into Movie_Genre values('Action','5');
insert into Movie_Genre values('Romance','6');
insert into Movie_Genre values('Horror','7');
insert into Movie_Genre values('Horror','8');
insert into Movie_Genre values('Comedy','9');
insert into Movie_Genre values('Comedy','10');

insert into Starred_By values('1','1');
insert into Starred_By values('1','2');
insert into Starred_By values('1','3');
insert into Starred_By values('2','5');
insert into Starred_By values('2','18');
insert into Starred_By values('2','3');
insert into Starred_By values('3','2');
insert into Starred_By values('3','11');
insert into Starred_By values('4','16');
insert into Starred_By values('5','13');
insert into Starred_By values('5','20');
insert into Starred_By values('5','7');
insert into Starred_By values('5','5');
insert into Starred_By values('6','18');
insert into Starred_By values('6','4');
insert into Starred_By values('7','11');
insert into Starred_By values('7','20');
insert into Starred_By values('7','2');
insert into Starred_By values('8','10');
insert into Starred_By values('8','4');
insert into Starred_By values('8','18');
insert into Starred_By values('9','16');
insert into Starred_By values('9','15');
insert into Starred_By values('9','8');
insert into Starred_By values('10','5');
insert into Starred_By values('10','18');
insert into Starred_By values('10','19');

insert into Has values('1', 'Wei-Chen Yen');
insert into Has values('1', 'Gina Yen');
insert into Has values('2', 'Xena Bryant');
insert into Has values('2', 'Tracey Andrews');
insert into Has values('3', 'Gus Taylor');
insert into Has values('3', 'Daniel Calvert');
insert into Has values('4', 'Aasiyah Huber');
insert into Has values('4', 'Breanna Small');
insert into Has values('5', 'Emillie Molina');
insert into Has values('5', 'Cari Rosas');

insert into Likes values('1', 'Wei-Chen Yen', 'Action');
insert into Likes values('1', 'Gina Yen', 'Romance');
insert into Likes values('2', 'Xena Bryant', 'Action');
insert into Likes values('2', 'Tracey Andrews', 'Horror');
insert into Likes values('3', 'Gus Taylor', 'Horror');
insert into Likes values('3', 'Daniel Calvert', 'Horror');
insert into Likes values('4', 'Aasiyah Huber', 'Horror');
insert into Likes values('4', 'Breanna Small', 'Action');
insert into Likes values('5', 'Emillie Molina', 'Comedy');
insert into Likes values('5', 'Cari Rosas', 'Romance');

insert into Watch values('1', 'Wei-Chen Yen', '1', 10);
insert into Watch values('1', 'Wei-Chen Yen', '3', 9);
insert into Watch values('1', 'Wei-Chen Yen', '5', 8);
insert into Watch values('1', 'Gina Yen', '2', 9);
insert into Watch values('1', 'Gina Yen', '4', 6);
insert into Watch values('1', 'Gina Yen', '6', 7);
insert into Watch values('2', 'Xena Bryant', '1', 6);
insert into Watch values('2', 'Xena Bryant', '3', 8);
insert into Watch values('2', 'Xena Bryant', '5', 7);
insert into Watch values('2', 'Tracey Andrews', '2', 5);
insert into Watch values('2', 'Tracey Andrews', '7', 9);
insert into Watch values('2', 'Tracey Andrews', '8', 10);
insert into Watch values('3', 'Gus Taylor', '3', 7);
insert into Watch values('3', 'Gus Taylor', '7', 8);
insert into Watch values('3', 'Gus Taylor', '8', 7);
insert into Watch values('3', 'Daniel Calvert', '3', 10);
insert into Watch values('3', 'Daniel Calvert', '7', 9);
insert into Watch values('3', 'Daniel Calvert', '8', 6);
insert into Watch values('4', 'Aasiyah Huber', '4', 7);
insert into Watch values('4', 'Aasiyah Huber', '7', 10);
insert into Watch values('4', 'Aasiyah Huber', '8', 8);
insert into Watch values('4', 'Breanna Small', '3', 4);
insert into Watch values('4', 'Breanna Small', '5', 8);
insert into Watch values('4', 'Breanna Small', '10', 10);
insert into Watch values('5', 'Emillie Molina', '1', 8);
insert into Watch values('5', 'Emillie Molina', '9', 10);
insert into Watch values('5', 'Emillie Molina', '10', 10);
insert into Watch values('5', 'Cari Rosas', '1', 7);
insert into Watch values('5', 'Cari Rosas', '2', 6);
insert into Watch values('5', 'Cari Rosas', '4', 9);


select * from Member;
select * from Profile;
select * from Movie;
select * from Actor;
select * from Genre;
select * from Has;
select * from Watch;
select * from Likes;
select * from Movie_Genre;
select * from Starred_By;

COMMIT;

