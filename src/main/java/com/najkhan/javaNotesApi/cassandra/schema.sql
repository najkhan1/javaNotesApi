
use notesapi;
create table HealthCheck(id Text, status Text,primary key (id));
insert into HealthCheck(id,status) values('Healthy','true');

create table Users(id int, fullName Text, password Text, email Text, primary key(id,email));
create table Notes(email Text, title Text, note Text, primary key(email,title));