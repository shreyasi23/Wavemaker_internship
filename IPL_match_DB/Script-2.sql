use IPL_db;


create table homeground(
hg_code varchar(4),
hg_name varchar(40) not null unique,
primary key(hg_code)
);

alter table homeground modify hg_name varchar(60);
insert into homeground values("NMS","Narendra Modi Stadium");
insert into homeground values("WS","Wankhede Stadium");
insert into homeground values("ISBS","Inderjit Singh Bindra Stadium");
insert into homeground values("AJS","Arun Jaitley Stadium ");
insert into homeground values("SMS","Sawai Mansingh Stadium");
insert into homeground values("MCS","M. Chinnaswamy Stadium");
insert into homeground values("RGIC","Rajiv Gandhi International Cricket Stadium");
insert into homeground values("MACS","M. A. Chidambaram Stadium");
insert into homeground values("ECS","Ekana Cricket Stadium");
insert into homeground values("EGS","Eden Gardens stadium");

select * from homeground;


create table team(
team_id varchar(4),
team_name varchar(30),
home_ground varchar(4)unique not null,
primary key(team_id),
constraint hg_fk foreign key(home_ground) references homeground(hg_code) on update cascade
); 

insert into team values("GT","Gujrat Titans","NMS");
insert into team values("MI","Mumbai Indians","WS");
insert into team values("PK","Punjab Kings","ISBS");
insert into team values("DC","Delhi Capitals","AJS");
insert into team values("RR","Rajasthan Royal","SMS");
insert into team values("RCB","Royal Challengers Bangalore","MCS");
insert into team values("SH","Sunrisers Hyderabad","RGIC");
insert into team values("CSK","Chennai Super Kings","MACS");
insert into team values("LSG","Lucknow Supergiants","ECS");
insert into team values("KKR","Kolkata Knight Riders","EGS");

select * from team;


create table player_category(
category_code varchar(3),
category varchar(13) not null unique,
primary key(category_code)
);

insert into player_category values("BA","Batsman");
insert into player_category values("BO","Bowler");
insert into player_category values("AR","All rounder");

select * from player_category;


create table nationality(
country_code varchar(3),
country varchar(20) not null unique,
primary key(country_code)
);

insert into nationality values("IN","Indian");
insert into nationality values("AM","American");
insert into nationality values("AF","Afgan");
insert into nationality values("AU","Australian");
insert into nationality values("BA","Bangladeshi");
insert into nationality values("BR","British");
insert into nationality values("IR","Irish");
insert into nationality values("AFR","African");
insert into nationality values("SI","Sinhalese");

select * from nationality;


create table players(
jersey_no int,
p_name varchar(30) not null,
age int,
team_id varchar(4) not null,
p_category varchar(3) not null,
p_nation varchar(3) not null,
runs int not null,
six int not null,
four int not null,
catch int not null,
wicket int not null,
primary key(jersey_no),
constraint team_fk foreign key(team_id) references team(team_id),
constraint pc_fk foreign key(p_category) references player_category(category_code),
constraint n_fk foreign key(p_nation) references nationality(country_code)
);

insert into players values(18, "Virat Kholi", 34, "RCB", "BA", "IN", 6624, 218, 546, 0, 0);
insert into players values(7, "MS Dhoni", 41, "CSK", "BA", "IN", 4945, 228, 345, 3644, 0);
insert into players values(38, "Josh Hazlewood", 32, "RCB", "BO", "AU", 734, 0, 1, 2, 32);
insert into players values(45, "Rohit Sharma", 35, "MI", "BA", "IN", 5879, 240, 519, 97, 15);
insert into players values(17, "Dewald Brevis", 19, "MI", "BA", "AFR", 161, 11, 14, 0, 1);
insert into players values(33, "Hardik Pandya", 29, "KKR", "AR", "IN", 1963, 110, 146, 57, 50);

select * from players;


create table results(
res_code varchar(2),
res_type varchar(30) not null unique,
primary key(res_code)
);

insert into results values("W","Home team wins");
insert into results values("L","Home team lost");
insert into results values("T","Tie");
insert into results values("NR","No result");

select * from results;


create table match_table(
match_no varchar(3),
match_date_time datetime not null,
home_team_id varchar(4) not null,
guest_team_id varchar(4) not null,
match_result varchar(2) not null,
primary key(match_no),
constraint ht_fk foreign key(home_team_id) references team(team_id),
constraint gt_fk foreign key(guest_team_id) references team(team_id),
constraint res_fk foreign key(match_result) references results(res_code),
unique(home_team_id, guest_team_id)
);

alter table match_table alter match_result set default 'NR';
alter table match_table add constraint ht_uk unique(home_team_id);
alter table match_table add constraint gt_uk unique(guest_team_id);
alter table match_table add check(home_team_id != guest_team_id);
alter table match_table add check(guest_team_id != home_team_id);

insert into match_table values("M01","2022-03-25 19:30:00","CSK","KKR","W");
insert into match_table values("M02","2022-03-26 19:30:00","DC","MI","L");
insert into match_table values("M03","2022-03-27 19:30:00","PK","RCB","L");
insert into match_table values("M04","2022-03-28 19:30:00","GT","LSG","T");
insert into match_table values("M05","2022-03-29 19:30:00","SH","RR","W");
-- test cases
-- insert into match_table values("M06","2022-03-29 19:30:00","CSK","RR","W");
-- insert into match_table values("M07","2022-03-29 19:30:00","CSK","CSK","W");
-- insert into match_table values("M08","2022-03-29 19:30:00","CSK","KKR","W");


select * from match_table;


create table umpire(
u_id varchar(3),
u_name varchar(40) not null,
u_nation varchar(3) not null,
match_no varchar(3),
primary key(u_id),
constraint un_fk foreign key(u_nation) references nationality(country_code),
constraint mn_fk foreign key(match_no) references match_table(match_no)
);

insert into umpire values("U01","Anil Chaudhary","IN","M01");
insert into umpire values("U02","Kumar Dharmasena","IN","M02");
insert into umpire values("U03","Chettithody Shamshuddin","SI","M01");
insert into umpire values("U04","Nitin Menon","IN","M02");
insert into umpire values("U05","Marais Erasmus","AFR","M03");

select * from umpire;

