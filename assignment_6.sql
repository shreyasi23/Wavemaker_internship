/* departments table*/
use data1;
create table departments(
dept_id varchar(5) unique,
dept_name varchar(20),
dept_head varchar(20),
dept_size int,
primary key(dept_id)
);

/*employees table*/
drop table employees;
create table employees(
emp_id varchar(5) unique,
emp_name varchar(20),
dept_name varchar(20),
emp_contact int unique,
emp_desig varchar(20),
primary key(emp_id)
);

/*address table*/
create table address(
emp_id varchar(5),
emp_name varchar(20),
emp_dept varchar(20),
emp_email varchar(40),
emp_pass varchar(16),
primary key(emp_id),
constraint fk_add foreign key(emp_id) references employees(emp_id)
);

select * from departments;
select * from employees;
select * from address;

insert into departments values("A1","Accounts","Seema Sharma",20);
insert into departments values("A2","Marketing","Geeta Reddy",20);
insert into departments values("A3","Sales","Raj Varma",30);
insert into departments values("A4","IT","Reema Sharma",40);
select * from departments;

insert into employees values("E1","Kiran Rao","IT","480766575","Senior developer");
insert into employees values("E2","Kiran Shetty","IT","481766575","Senior developer");
insert into employees values("E3","Dharam Sharma","IT","582766575","Junior developer");
insert into employees values("E4","Simar Kapoor","Sales","583766575","Manager");
insert into employees values("E5","Kiran Mishra","Sales","584766575","Senior manager");
insert into employees values("E6","Manisha Gupta","Accounts","684766575","Manager");
insert into employees values("E7","Geeta Singh","Accounts","685766575","Accountant");
insert into employees values("E8","Meena Rao","Accounts","686766575","Financial analyst");
insert into employees values("E9","Meena Mehta","Marketing","186766575","Manager");
select * from employees;

insert into address values("E1","Kiran Rao","IT","kiran.rao@gmail.com","kiran123");
insert into address values("E2","Kiran Shetty","IT","kiran.shetty@gmail.com","kirans123");
insert into address values("E3","Dharam Sharma","IT","dharam.sharma@gmail.com","ds123");
insert into address values("E4","Simar Kapoor","Sales","simar.kapoor@gmail.com","sk123");
insert into address values("E5","Kiran Mishra","Sales","kiran.mishra@gmail.com","kiranm123");
insert into address values("E6","Manisha Gupta","Accounts","manisha.gupta@gmail.com","mg123");
insert into address values("E7","Geeta Singh","Accounts","geeta.singh@gmail.com","gs123");
insert into address values("E8","Meena Rao","Accounts","meena.rao@gmail.com","meena123");
select * from address;

/*inner join*/
select e.emp_name, e.emp_contact, a.emp_email from employees as e inner join address as a on e.emp_name = a.emp_name;

/*left join*/
select e.emp_name, d.dept_head from employees as e left join departments as d on e.dept_name = d.dept_name;

/*right join*/
select e.emp_id, d.dept_name from employees as e right join departments as d on e.dept_name = d.dept_name;

/*full join*/
select dept_id, dept_name, emp_id, emp_dept from departments full join address on dept_name = emp_dept; 





