create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("naveen", "testing@123"); 

----------------------------------------------
--realEstate 

create table usermessages(
name varchar(20) not null,
email varchar(30),
subject varchar(50),
message varchar(50));

insert into usermessages values("manzoor","manzoor@gmail.com","asdfas","sdfsdfsd");