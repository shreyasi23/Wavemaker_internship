use corridor_db;


create table cycle_data(
insurance_id varchar(4),
provider varchar(50) not null,
cycle_start int unique,
insurance_amt int not null,
primary key(insurance_id)
);

insert into cycle_data values("in01","National Insurance Company",2022,500000);
insert into cycle_data values("in02","National Insurance Company",2020,500000);
insert into cycle_data values("in03","National Insurance Company",2019,500000);
insert into cycle_data values("in04","National Insurance Company",2018,500000);
insert into cycle_data values("in05","National Insurance Company",2017,500000);

select * from cycle_data;


create table top_up_data(
tua_id varchar(4), 
top_up_amt int not null,
monthly_deduct int not null,
descriptn varchar(30),
insurance_id varchar(4),
primary key(tua_id),
constraint tud_fk foreign key(insurance_id) references cycle_data(insurance_id)
);


insert into top_up_data values("ta01",50000,1200,"Lorem ipsum dolor sit amet","in01");
insert into top_up_data values("ta02",75000,1800,"Lorem ipsum dolor sit amet","in01");
insert into top_up_data values("ta03",150000,2600,"Lorem ipsum dolor sit amet","in01");
insert into top_up_data values("ta04",45000,1000,"Lorem ipsum dolor sit amet","in02");
insert into top_up_data values("ta05",50000,1200,"Lorem ipsum dolor sit amet","in02");

select * from top_up_data;


create table department_table(
dept_name varchar(20),
dept_code varchar(4)unique,
primary key(dept_name)
);

insert into department_table values("Accounts","acnt");
insert into department_table values("Transport","trnp");
insert into department_table values("Operations","opr");
insert into department_table values("Human Resource","hr");
insert into department_table values("Marketing","mrk");

select * from department_table;


create table designation_table(
title varchar(20),
title_code varchar(4)unique,
primary key(title)
);

insert into designation_table values("Accounts manager","acm");
insert into designation_table values("finanace analyst","fan");
insert into designation_table values("Accountant","accn");
insert into designation_table values("Transport manager","trpm");
insert into designation_table values("Operations manager","opm");
insert into designation_table values("Operations analyst","opan");
insert into designation_table values("HR manager","hrm");
insert into designation_table values("Training manager","trm");
insert into designation_table values("Sales analyst","san");
insert into designation_table values("Marketing consultant","mkcn");

select * from designation_table;


create table marital_status(
status varchar(8),
status_code int unique,
primary key(status)
);

insert into marital_status values("married",1);
insert into marital_status values("single",0);

select * from marital_status;


create table employee_data(
emp_id varchar(2),
emp_name varchar(50) not null,
gender char(1) check(gender in("M","F","O")),
ph_no bigint unique,
email varchar(50) unique,
emp_dob date not null,
emp_dept varchar(4) not null,
emp_desig varchar(4) not null,
blood_grp varchar(3) not null check(blood_grp in("A+","A-","B+","B-","AB+","AB-","O+","O-")),
marital_status int not null,
primary key(emp_id),
constraint dpt_fk foreign key(emp_dept)references department_table(dept_code) on delete cascade,
constraint dt_fk foreign key(emp_desig) references designation_table(title_code) on update cascade,
constraint ms_fk foreign key(marital_status) references marital_status(status_code) on update cascade
);

insert into employee_data values("E1","Sushma Shetty","F",9833445270,"sushma.shetty@gmail.com","2001-04-19","acnt","fan","A+",0);
insert into employee_data values("E2","Saffa Khan","F",9732445270,"saffa.khan@gmail.com","2001-02-18","mrk","mkcn","B+",0);
insert into employee_data values("E3","Monvita Kancharla","F",9833400270,"monvita.kancharla@gmail.com","2000-08-20","hr","trm","B+",1);
insert into employee_data values("E4","Nikhil Kutty","M",7823445279,"nikhil.kutty@gmail.com","1998-04-19","hr","trm","AB+",1);
insert into employee_data values("E5","Sumit Reddy","M",9823835270,"sumit.reddy@gmail.com","2000-11-10","opr","opan","O+",1);
insert into employee_data values("E6","Yamini Gupta","F",9832445071,"yamini.gupta@gmail.com","1996-12-24","trnp","trpm","O+",1);
insert into employee_data values("E7","Andy Kumar","M",8830445170,"andy.kumar@gmail.com","2001-04-19","hr","hrm","O+",0);

select * from employee_data;


create table blood_rel_table(
relation varchar(12) unique,
relation_code varchar(3),
primary key(relation_code)
);


insert into blood_rel_table values("Mother","MO");
insert into blood_rel_table values("Father","FA");
insert into blood_rel_table values("Mother inlaw","MOL");
insert into blood_rel_table values("Father inlaw","FAL");
insert into blood_rel_table values("Daughter","D");
insert into blood_rel_table values("Son","S");
insert into blood_rel_table values("Wife","W");
insert into blood_rel_table values("Husband","H");

select * from blood_rel_table;


create table dependent_table(
dep_id varchar(2),
dep_name varchar(50) not null,
dep_dob date not null,
dep_rel varchar(3) not null,
emp_id varchar(2),
primary key(dep_id),
constraint dep_fk foreign key(emp_id) references employee_data(emp_id),
constraint brt_fk foreign key(dep_rel) references blood_rel_table(relation_code)
);

insert into dependent_table values("D1","Meesha Shetty","1975-07-09","MO","E1");
insert into dependent_table values("D2","Sukumar Shetty","1970-03-08","FA","E1");
insert into dependent_table values("D3","Siya Kancharla","2002-11-10","D","E3");
insert into dependent_table values("D4","Lakshman Kancharla","1999-08-12","H","E3");
insert into dependent_table values("D5","Mohit Kancharla","2004-07-09","S","E3");

select * from dependent_table;


create table nominee_data(
dep_id varchar(2),
primary key(dep_id),
constraint nom_fk foreign key(dep_id) references dependent_table(dep_id)
);

insert into nominee_data values("D1");
insert into nominee_data values("D2");
insert into nominee_data values("D3");
insert into nominee_data values("D4");
insert into nominee_data values("D5");

select * from nominee_data;


create table employee_insurance_data(
emp_id varchar(2),
insurance_id varchar(4),
opt_in char(1) check(opt_in in("Y","N","P")),
tpu_opt_in char(1) check(tpu_opt_in in("Y","N")),
no_nominee int check(no_nominee between 1 and 5),
top_up_amt int default null,
insurance_sum int not null,
primary key(emp_id),
constraint eid_fk1 foreign key(emp_id) references employee_data(emp_id),
constraint eid_fk2 foreign key(insurance_id) references cycle_data(insurance_id)
);

insert into employee_insurance_data values("E1","in01","Y","N",2,null,500000);
insert into employee_insurance_data values("E2","in01","P","N",1,null,500000);
insert into employee_insurance_data values("E3","in01","Y","Y",3,50000,550000);
insert into employee_insurance_data values("E4","in01","P","N",1,null,500000);
insert into employee_insurance_data values("E5","in01","P","N",1,null,500000);

select * from employee_insurance_data;

