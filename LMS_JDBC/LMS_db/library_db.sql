create database LMS_db;
use LMS_db;

create table authors(
	author_code varchar(3),
	author_name varchar(50) not null,
	primary key(author_code)
);

insert into authors values("A1","Hellen Keller");
insert into authors values("A2","Blake Pierce");
insert into authors values("A3","Alicia Rades");
insert into authors values("A4","Harper Lin");
insert into authors values("A5","Marie Kondo");

select * from authors;

create table publishers(
	publisher_code varchar(3),
	publisher_name varchar(50) not null,
	primary key(publisher_code)
);

insert into publishers values("P1","ABC Company");
insert into publishers values("P2","XYZ Books");
insert into publishers values("P3","PQRS Publication");
insert into publishers values("P4","MNP Books");
insert into publishers values("P5","UTV Reads");

select * from publishers;

create table languages(
	lang_code varchar(4),
	lang_name varchar(30) not null,
	primary key(lang_code)
);

insert into languages values("ENG","English");
insert into languages values("TLG","Telugu");
insert into languages values("HND","Hindi");
insert into languages values("MRT","Marathi");
insert into languages values("BNG","Bengali");

select * from languages;

create table genres(
	genre_code varchar(4),
	genre_name varchar(30) not null,
	primary key(genre_code)
);

alter table genres modify column genre_code int;

insert into genres values(1,"Comic");
insert into genres values(2,"Fiction");
insert into genres values(3,"Psychology");
insert into genres values(4,"Biography");
insert into genres values(5,"Self help");

select * from genres;

create table book(
	isbn int,
	title varchar(100) not null unique,
	author varchar(3) not null,
	descrpt varchar(100),
	publisher varchar(3) not null,
	lang varchar(4) not null,
	genre int not null,
	inventory int not null,
	primary key(isbn),
	constraint au_fk foreign key(author) references authors(author_code),
	constraint pub_fk foreign key(publisher) references publishers(publisher_code),
	constraint lang_fk foreign key(lang) references languages(lang_code),
	constraint gen_fk foreign key(genre) references genres(genre_code)
);

select * from book;

create table librarian(
	libID varchar(3),
	libName varchar(50) not null,
	paswd varchar(20) not null unique,
    libPhNo bigint not null unique,
	libEmail varchar(100)  not null unique,
	primary key(libID)
);

insert into librarian values("L1","Pooja Gupta","admin@1991",8876454432,"librarian@abclibrary.com");

select * from librarian;

create table libraryMembers(
	lmID varchar(3),
	lmName varchar(50) not null,
	paswd varchar(20) not null unique,
    lmPhNo bigint not null unique,
	lmEmail varchar(100) not null unique,
	primary key(lmID)
);

insert into libraryMembers values("LM1","Pooja Singh","ps@1992",8076454432,"pooja.singh@abclibrary.com");
insert into libraryMembers values("LM2","Meera Reddy","meera@123",8876454032,"meera.reddy@abclibrary.com");
insert into libraryMembers values("LM3","Ramkrishna Gudala","Rk08#20",8806454432,"ramkrishna.gudala@abclibrary.com");
insert into libraryMembers values("LM4","Jay Gupta","jg#2001",8870454432,"jay.gupta@abclibrary.com");
insert into libraryMembers values("LM5","Neha Purohit","nehap123",8876454430,"neha.purohit@abclibrary.com");

select * from libraryMembers;




